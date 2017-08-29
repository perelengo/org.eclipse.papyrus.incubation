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

#The root url that enables to find the job with ${hudsonJobRootUrl}/$jobName/$buildNumber
hudsonJobRootUrl="https://hudson.eclipse.org/papyrus/job"

#The name of the tool
repo="incubation"
subRepo="alf"
updates="updates"
drops="downloads/drops"

#The specific localization
remoteRoot="/home/data/httpd/download.eclipse.org"
papyrusRoot="modeling/mdt/papyrus"
remoteUpdateSiteRoot=${remoteRoot}/${papyrusRoot}/${repo}
remoteUpdateSite=${remoteUpdateSiteRoot}/${subRepo}
remoteUpdateSiteDir=${remoteUpdateSite}/${updates}
echo "remoteUpdateSiteDir: $remoteUpdateSiteDir"

#The localization of the local build target
targetResults="archive/${subRepo}/releng/org.eclipse.papyrus.${repo}.${subRepo}.p2/target/repository"
echo "targetResults: $targetResults"

#The rcpPrompote.sh script may be used to publish the Incubation build results. 
#if [ $# -eq 6 -o $# -eq 7  ];
#then
#	jobName=$1
jobName="Papyrus-Incubation-DiagramTemplate"
	echo "jobName: $jobName"
#	buildNumber=$2
buildNumber="4"
	echo "buildNumber: $buildNumber"
#	releaseType=$3
releaseType="i"
	echo "releaseType: $releaseType"
#	releaseLabel=$4	
releaseLabel="1.2.0"
	echo "releaseLabel: $releaseLabel"
#	eclipseTarget=$5
eclipseTarget="oxygen"	
	echo "eclipseTarget: $eclipseTarget"
#	override=$6	
override="y"
	echo "override: $override"

	if [ -n "$7" ];
	then
		releaseLabelSuffix=$7
		echo "releaseLabelSuffix: $releaseLabelSuffix"
	fi
#else
#	echo "Missing so parameters: command jobName buildNumber releaseType releaseLabel eclipseTarget override [releaseLabelSuffix]"
#	exit 1;
#fi

###########jobName parameter###########
if [ -z "$jobName" ];
then
	echo "The Hudson job you want to promote must be specified"
	exit 1
fi

###########buildNumber parameter###########
if [ -z "$buildNumber" ];
then
	echo "The id of the $jobName build you want to promote must be specified"
	exit 1
fi

###########releaseType parameter###########
if [ -z "$releaseType" ];
then
    echo "The type of build you want to publish to [i(integration), s(table), r(elease)]."
    exit;
fi
echo "Publishing as $releaseType build"

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

########### Compute local build results using buildNumber ###########
if [ "$buildNumber" = "lastStable" -o "$buildNumber" = "lastSuccessful" ];
then
	# Reverse lookup the build id (in case lastSuccessful or lastStable was used)
	for i in $(find ~/.hudson/jobs/$jobName/builds/ -type l)
	do
		if [ "$(readlink -f $i)" = "$(readlink -f ~/.hudson/jobs/$jobName/$buildNumber)" ];
		then
			buildNumber=${i##*/}
		fi
	done
	echo "Reverse lookup (lastStable/lastSuccessful) yielded buildNumber: $buildNumber"
fi

echo "~/.hudson/jobs/${jobName}/builds/${buildNumber}"
jobDir=$(readlink -f ~/.hudson/jobs/${jobName}/builds/${buildNumber})
if ! [ -d $jobDir ];
then
	echo "The specified buildNumber does not refer to an existing build: $buildNumber"
	exit 1
fi

localResults=${jobDir}/${targetResults}
echo "localResults: ${localResults}"

########### Promote Job ###########
destination=$remoteUpdateSiteDir/$eclipseTarget/${releaseLabel}${releaseLabelSuffix}
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

#Go to the artifact directory
cd $localResults
echo "Promoting the Job to $destination"
#No error if exists, makes parent directories as needed
mkdir -p $destination

#Copy the contents onto the temp folder and change the permissions
cp -R * $destination


########### Update composites ###########
# TODO update composite root ./eclipseTarget/* and parent ./*
echo "Update Composites"
timestamp=$(date +%s000)

# This function indents the text with two white spaces
indent() {
sed 's/^/  /';
}

# This function is used to generate the composites
function updateComposites() {
cat > "compositeArtifacts.xml" <<EOF
<?xml version="1.0" encoding="UTF-8"?>
<repository name="Papyrus" type="org.eclipse.equinox.internal.p2.artifact.repository.CompositeArtifactRepository" version="1.0.0">
  <properties size="1">
    <property name="p2.timestamp" value="$1"/>
  </properties>
  <children size="$2">
$(	
for file in *; do 
if [ -d $file ]; then 
    printf "<child location='${file}'/>" | indent | indent
fi
done
)
  </children>
</repository>
EOF

cat > "compositeContent.xml" <<EOF
<?xml version="1.0" encoding="UTF-8"?>
<repository name="Papyrus" type="org.eclipse.equinox.internal.p2.metadata.repository.CompositeMetadataRepository" version="1.0.0">
  <properties size="1">
    <property name="p2.timestamp" value="$1"/>
  </properties>
  <children size="$2">
$(	
for file in *; do 
if [ -d $file ]; then 
    printf "<child location='${file}'/>" | indent | indent
fi
done
)
  </children>
</repository>
EOF
}

echo "Update root composites: $remoteUpdateSite"
cd $remoteUpdateSite
childrenCount=$(find . -maxdepth 1 -type d  \( ! -iname ".*" \) | wc -l)
updateComposites $timestamp $childrenCount

echo "Update eclipseTarget composites: $remoteUpdateSiteDir"
cd $remoteUpdateSiteDir
childrenCount=$(find . -maxdepth 1 -type d  \( ! -iname ".*" \) | wc -l)
updateComposites $timestamp $childrenCount

echo "Update releaseLabel composites: $remoteUpdateSiteDir/$eclipseTarget"
cd $remoteUpdateSiteDir/$eclipseTarget
childrenCount=$(find . -maxdepth 1 -type d  \( ! -iname ".*" \) | wc -l)
updateComposites $timestamp $childrenCount


########### Set Access Rights ###########

# This function sets the acess rights to allow all memebers of the group to edit the files
function setAccessRights() {
	chmod -R 775 "$1"
	chgrp -hR modeling.mdt.papyrus "$1"
}
echo "Set access right -R: $remoteUpdateSiteDir"
setAccessRights $remoteUpdateSiteDir


echo "publishing done."