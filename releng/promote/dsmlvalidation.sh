#Based upon Gef4 publish.sh script

#causes the shell to exit if any subcommand or pipeline returns a non-zero status.
#set -e

# Script may take 5-6 command line parameters:
# $1: Hudson job name: <name>
# $2: Hudson build id: <id>
# $3: Build type: i(ntegration), s(table), r(elease)
# $4: The release label used to label the drop files, e.g. 3.10.0 or 3.10.1
# $5: The eclipse target version, e.g. mars or neon
# $6: Override if exists
# $7: An optional release label suffix to be appended to drop files name, e.g. M1, RC1 

##Additional variables to specify for each project

#The root url that enables to find the job with ${hudsonJobRootUrl}/$jobName/$buildId
hudsonJobRootUrl="https://hudson.eclipse.org/papyrus/job"

#The name of the tool
repo="incubation"
subRepo="dsml.validation"

#The specific localization
remoteRoot="/home/data/httpd/download.eclipse.org"
remoteUpdateSiteRoot="modeling/mdt/papyrus"
remoteJobDir=${remoteRoot}/${remoteUpdateSiteRoot}/${repo}

#The localization of the local build target
targetResults="archive/${subRepo}/releng/org.eclipse.papyrus.${repo}.${subRepo}.p2/target/repository"

#The rcpPrompote.sh script may be used to publish the Incubation build results. 
if [ $# -eq 6 -o $# -eq 7  ];
then
	jobName=$1
	echo "jobName: $jobName"
	buildId=$2
	echo "buildId: $buildId"
	buildType=$3
	echo "buildType: $buildType"
	releaseLabel=$4	
	echo "releaseLabel: $releaseLabel"
	eclipseTarget=$5	
	echo "eclipseTarget: $eclipseTarget"
	override=$6	
	echo "override: $override"

	if [ -n "$7" ];
	then
		releaseLabelSuffix=$7
		echo "releaseLabelSuffix: $releaseLabelSuffix"
	fi
else
	echo "Missing so parameters: command jobName buildId buildType releaseLabel eclipseTarget override [releaseLabelSuffix]"
	exit 1;
fi

###########jobName parameter###########
if [ -z "$jobName" ];
then
	echo "The Hudson job you want to promote must be specified"
	exit 1
fi

###########buildId parameter###########
if [ -z "$buildId" ];
then
	echo "The id of the $jobName build you want to promote must be specified"
	exit 1
fi

###########buildType parameter###########
if [ -z "$buildType" ];
then
    echo "The type of build you want to publish to [i(integration), s(table), r(elease)]."
    exit;
fi
echo "Publishing as $buildType build"

###########releaseLabel parameter###########
if [ -z "$releaseLabel" ];
then
    echo "The release label (e.g. 3.10.0, 3.10.1M2) must be specified."
    exit 1
fi
echo "Release label: $releaseLabel"

###########eclipseTarget parameter###########
if [ -z "$eclipseTarget" ];
then
    echo "The Eclipse target (e.g. mars, neon) must be specified."
    exit 1
fi
echo "Eclipse target : $eclipseTarget"

###########Override parameter###########
if [ "$override" != y -a "$override" != n ];
then
	echo "Parameter override has to 'y'(es) or 'n'(o) but was: $override"
    exit 0
fi

if [ "$override" == "y" ];
then
	echo "Will override the previous artifacts if found"
else
	echo "Will not override the previous arifacts if found"
fi

########### Compute local build results using buildId ###########
if [ "$buildId" = "lastStable" -o "$buildId" = "lastSuccessful" ];
then
	# Reverse lookup the build id (in case lastSuccessful or lastStable was used)
	for i in $(find ~/.hudson/jobs/$jobName/builds/ -type l)
	do
		if [ "$(readlink -f $i)" = "$(readlink -f ~/.hudson/jobs/$jobName/$buildId)" ];
		then
			buildId=${i##*/}
		fi
	done
	echo "Reverse lookup (lastStable/lastSuccessful) yielded buildId: $buildId"
fi

echo "~/.hudson/jobs/${jobName}/builds/${buildId}"
jobDir=$(readlink -f ~/.hudson/jobs/${jobName}/builds/${buildId})
if ! [ -d $jobDir ];
then
	echo "The specified buildId does not refer to an existing build: $buildId"
	exit 1
fi

localResults=${jobDir}/${targetResults}
echo "localResults=${localResults}"

########### Promote Job ###########
updateSiteDir=$remoteJobDir/$subRepo
destination=$updateSite/$eclipseTarget/${releaseLabel}${releaseLabelSuffix}
echo "Destination: $destination"

if [ "$override" == "n" ];
then
	if [ -d $destination ];
	then
		if [ "$(ls -A ${destination})" ];
		then
			echo "The destination is not empty. You may consider overriding or archiving"
			exit 1
		fi
	fi
fi

if [ "$override" == "y" ];
then
	if [ -d $destination ];
	then
		echo "Overriding the RCP by cleaning the $destination folder"
		rm -rf ${destination}/*
	fi
fi

cd $localResults
tmpdir=$localResults/tmp
#Clean if already exists
rm -rf $tmpdir
mkdir $tmpdir

#Copy the contents onto the temp folder and change the permissions
#cp -R * tmp
rsync -av --exclude='$tmpdir' $localResults/* $tmpdir

function setAccessRights() {
	chmod -R 775 "$1"
	chgrp -hR modeling.mdt.papyrus "$1"
}

setAccessRights "$tmpdir"

#No error if exists, makes parent directories as needed
mkdir -p $destination
echo "Promoting the Job to $destination"
mv $tmpdir/* $destination
setAccessRights "$updateSiteDir"

# Clean up
echo "Cleaning up"
rm -rf $tmpdir

########### Update composites ###########
cd $updateSiteDir

function updateComposites() {
childrenArray=()
while IFS= read -r -d $'\0'; do
	childrenArray+=("$REPLY")
done < <(find . -maxdepth 1 -type d  \( ! -iname ".*" \))

children=${find . -maxdepth 1 -type d  \( ! -iname ".*" \) | wc -l}
timestamp=${date+%s000}

cat > "compositeArtifacts.xml" <<EOF
<?xml version="1.0" encoding="UTF-8"?>
<repository name="Papyrus" type="org.eclipse.equinox.internal.p2.artifact.repository.CompositeArtifactRepository" version="1.0.0">
  <properties size="1">
    <property name="p2.timestamp" value="${timestamp}"/>
  </properties>
  <children size="${children}">
    ${for file in *; do 
		if [ -d $folder ]; then 
		echo "<child location='${folder}'/>"
		fi
	done)	
  </children>
</repository>
EOF

cat > "compositeContent.xml" <<EOF
<?xml version="1.0" encoding="UTF-8"?>
<repository name="Papyrus" type="org.eclipse.equinox.internal.p2.metadata.repository.CompositeMetadataRepository" version="1.0.0">
  <properties size="1">
    <property name="p2.timestamp" value="$(timestamp)"/>
  </properties>
  <children size="${children}">
    ${for file in *; do 
		if [ -d $folder ]; then 
		echo "<child location='${folder}'/>"
		fi
	done)	
  </children>
</repository>
EOF
}

#updateComposites