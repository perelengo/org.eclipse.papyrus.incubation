/*****************************************************************************
 * Copyright (c) 2019 CEA LIST, and others.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *   Nicolas FAUVERGUE (CEA LIST) nicolas.fauvergue@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.gitlight.git.utils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.egit.ui.internal.selection.SelectionUtils;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jgit.api.CheckoutCommand;
import org.eclipse.jgit.api.CreateBranchCommand;
import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.ListBranchCommand.ListMode;
import org.eclipse.jgit.api.MergeCommand;
import org.eclipse.jgit.api.MergeResult;
import org.eclipse.jgit.api.PushCommand;
import org.eclipse.jgit.api.ResetCommand.ResetType;
import org.eclipse.jgit.api.errors.AbortedByHookException;
import org.eclipse.jgit.api.errors.CanceledException;
import org.eclipse.jgit.api.errors.CheckoutConflictException;
import org.eclipse.jgit.api.errors.ConcurrentRefUpdateException;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.eclipse.jgit.api.errors.InvalidConfigurationException;
import org.eclipse.jgit.api.errors.InvalidRefNameException;
import org.eclipse.jgit.api.errors.InvalidRemoteException;
import org.eclipse.jgit.api.errors.NoFilepatternException;
import org.eclipse.jgit.api.errors.NoHeadException;
import org.eclipse.jgit.api.errors.NoMessageException;
import org.eclipse.jgit.api.errors.RefAlreadyExistsException;
import org.eclipse.jgit.api.errors.RefNotAdvertisedException;
import org.eclipse.jgit.api.errors.RefNotFoundException;
import org.eclipse.jgit.api.errors.TransportException;
import org.eclipse.jgit.api.errors.UnmergedPathsException;
import org.eclipse.jgit.api.errors.WrongRepositoryStateException;
import org.eclipse.jgit.errors.IncorrectObjectTypeException;
import org.eclipse.jgit.errors.MissingObjectException;
import org.eclipse.jgit.lib.Constants;
import org.eclipse.jgit.lib.Ref;
import org.eclipse.jgit.lib.Repository;
import org.eclipse.jgit.revwalk.RevCommit;
import org.eclipse.jgit.revwalk.RevWalk;
import org.eclipse.jgit.transport.RefSpec;
import org.eclipse.papyrus.gitlight.git.Activator;
import org.eclipse.uml2.uml.Element;

/**
 * This class allows to define utils method for the git.
 */
@SuppressWarnings("restriction")
public class GitUtils {

	/**
	 * This allows to open the git.
	 * 
	 * @param repositoryPath
	 *            The repository path.
	 * @return The opened git or <code>null</code>.
	 */
	public static Git openGit(final String repositoryPath) {
		if (!repositoryPath.isEmpty()) {
			try {
				Git git = Git.open(new File(repositoryPath));
				return git;
			} catch (IOException e) {
				Activator.getLogHelper().error("Error during the repository opening", e); //$NON-NLS-1$
			}
		}
		return null;
	}

	/**
	 * This allows to get repository from project.
	 * 
	 * @param project
	 *            The project.
	 * @param shell
	 *            The shell.
	 * @return The repository corresponding to the project.
	 */
	public static Repository getRepository(final Element element) {
		final IFile umlFile = PapyrusFileUtils.getFile(element);
		final IProject project = umlFile.getProject();
		return null != project ? getRepository(project) : null;
	}

	/**
	 * This allows to get repository from project.
	 * 
	 * @param project
	 *            The project.
	 * @param shell
	 *            The shell.
	 * @return The repository corresponding to the project.
	 */
	public static Repository getRepository(final IProject project) {
		return SelectionUtils.getRepository(new StructuredSelection(project));
	}

	/**
	 * This allows to add a file for the commit.
	 * 
	 * @param git
	 *            The git.
	 * @param filePath
	 *            The file path of file to add.
	 */
	public static void addFile(final Git git, final String filePath) {
		if (null != git && !filePath.isEmpty()) {
			try {
				git.add().addFilepattern(filePath).call();
			} catch (NoFilepatternException e) {
				Activator.getLogHelper().error("Error while adding file: Pattern file is not correct", e); //$NON-NLS-1$
			} catch (GitAPIException e) {
				Activator.getLogHelper().error("Error while adding file: Unknow error", e); //$NON-NLS-1$
			}
		}
	}

	/**
	 * This allows to create a commit.
	 * 
	 * @param git
	 *            The git.
	 * @param message
	 *            The commit message.
	 * @return The commit revision or <code>null</code>.
	 */
	public static RevCommit createCommit(final Git git, final String message) {
		if (null != git) {
			try {
				return git.commit().setMessage(message).call();
			} catch (NoHeadException e) {
				Activator.getLogHelper().error("Error while creating commit: No head defined", e); //$NON-NLS-1$
			} catch (NoMessageException e) {
				Activator.getLogHelper().error("Error while creating commit: No defined message", e); //$NON-NLS-1$
			} catch (UnmergedPathsException e) {
				Activator.getLogHelper().error("Error while creating commit: Unknow error", e); //$NON-NLS-1$
			} catch (ConcurrentRefUpdateException e) {
				Activator.getLogHelper().error("Error while creating commit: Concurrent update", e); //$NON-NLS-1$
			} catch (WrongRepositoryStateException e) {
				Activator.getLogHelper().error("Error while creating commit: Wrong repository state", e); //$NON-NLS-1$
			} catch (AbortedByHookException e) {
				Activator.getLogHelper().error("Error while creating commit: Repository hooked", e); //$NON-NLS-1$
			} catch (GitAPIException e) {
				Activator.getLogHelper().error("Error while creating commit: Unknow error", e); //$NON-NLS-1$
			}
		}
		return null;
	}

	/**
	 * This allows to push the commit.
	 * 
	 * @param git
	 *            The git.
	 */
	public static void pushCommit(final Git git) {
		if (null != git) {
			try {
				git.push().call();
			} catch (InvalidRemoteException e) {
				Activator.getLogHelper().error("Error while pushing: Invalid remote", e); //$NON-NLS-1$
			} catch (TransportException e) {
				Activator.getLogHelper().error("Error while pushing: Connection problem", e); //$NON-NLS-1$
			} catch (GitAPIException e) {
				Activator.getLogHelper().error("Error while pushing: Unknow error", e); //$NON-NLS-1$
			}
		}
	}

	/**
	 * This allows to push a branch into repository.
	 * 
	 * @param git
	 *            The git.
	 * @param branchName
	 *            The branch name to push.
	 */
	public static void pushBranchCommit(final Git git, final String branchName) {
		if (null != git && !branchName.isEmpty()) {
			try {
				final PushCommand pushCommand = git.push();
				pushCommand.setRemote(Constants.DEFAULT_REMOTE_NAME);
				pushCommand.setRefSpecs(new RefSpec(branchName + ":" + branchName));
				pushCommand.call();
			} catch (InvalidRemoteException e) {
				Activator.getLogHelper().error("Error while pushing: Invalid remote", e); //$NON-NLS-1$
			} catch (TransportException e) {
				Activator.getLogHelper().error("Error while pushing: Connection problem", e); //$NON-NLS-1$
			} catch (GitAPIException e) {
				Activator.getLogHelper().error("Error while pushing: Unknow error", e); //$NON-NLS-1$
			}
		}
	}

	/**
	 * This allows to create a local branch.
	 * 
	 * @param git
	 *            The git.
	 * @param branchName
	 *            The branch name.
	 */
	public static void createBranch(final Git git, final String branchName) {
		if (null != git && !branchName.isEmpty()) {
			try {
				git.checkout().setCreateBranch(true).setName(branchName).call();
			} catch (RefAlreadyExistsException e) {
				Activator.getLogHelper().error("Error while creating branch: Branch '" + branchName + "' already exists", e); //$NON-NLS-1$ //$NON-NLS-2$
			} catch (RefNotFoundException e) {
				Activator.getLogHelper().error("Error while creating branch: Reference not found", e); //$NON-NLS-1$
			} catch (InvalidRefNameException e) {
				Activator.getLogHelper().error("Error while creating branch: Invalid name", e); //$NON-NLS-1$
			} catch (CheckoutConflictException e) {
				Activator.getLogHelper().error("Error while creating branch: Checkout conflict", e); //$NON-NLS-1$
			} catch (GitAPIException e) {
				Activator.getLogHelper().error("Error while creating branch: Unknow error", e); //$NON-NLS-1$
			}
		}
	}

	/**
	 * This allows to create a local branch.
	 * 
	 * @param git
	 *            The git.
	 * @param branchName
	 *            The branch name.
	 */
	public static void createBranch(final Git git, final String branchName, final String remoteBranchName) {
		if (null != git && !branchName.isEmpty()) {
			try {
				git.checkout()
						.setCreateBranch(true)
						.setName(branchName)
						.setUpstreamMode(CreateBranchCommand.SetupUpstreamMode.TRACK)
						.setStartPoint(Constants.DEFAULT_REMOTE_NAME + "/" + remoteBranchName) //$NON-NLS-1$
						.call();
			} catch (RefAlreadyExistsException e) {
				Activator.getLogHelper().error("Error while creating branch: Branch '" + branchName + "' already exists", e); //$NON-NLS-1$ //$NON-NLS-2$
			} catch (RefNotFoundException e) {
				Activator.getLogHelper().error("Error while creating branch: Reference not found", e); //$NON-NLS-1$
			} catch (InvalidRefNameException e) {
				Activator.getLogHelper().error("Error while creating branch: Invalid name", e); //$NON-NLS-1$
			} catch (CheckoutConflictException e) {
				Activator.getLogHelper().error("Error while creating branch: Checkout conflict", e); //$NON-NLS-1$
			} catch (GitAPIException e) {
				Activator.getLogHelper().error("Error while creating branch: Unknow error", e); //$NON-NLS-1$
			}
		}
	}

	/**
	 * This allows to reset hard the current branch.
	 * 
	 * @param git
	 *            The git.
	 */
	public static void resetHardCurrentBranch(final Git git) {
		if (null != git) {
			try {
				git.reset().setMode(ResetType.HARD).call();
			} catch (GitAPIException e) {
				Activator.getLogHelper().error("Error while creating branch: Unknow error", e); //$NON-NLS-1$
			}
		}
	}

	/**
	 * this allows to checkout an existing local branch.
	 * 
	 * @param git
	 *            The git.
	 * @param branchName
	 *            The branch name.
	 */
	public static void checkoutExistingBranch(final Git git, final String branchName) {
		if (null != git && !branchName.isEmpty()) {
			try {
				git.checkout().setCreateBranch(false).setName(branchName).call();
			} catch (RefNotFoundException e) {
				Activator.getLogHelper().error("Error while creating branch: Reference not found", e); //$NON-NLS-1$
			} catch (InvalidRefNameException e) {
				Activator.getLogHelper().error("Error while creating branch: Invalid name", e); //$NON-NLS-1$
			} catch (CheckoutConflictException e) {
				Activator.getLogHelper().error("Error while creating branch: Checkout conflict", e); //$NON-NLS-1$
			} catch (GitAPIException e) {
				Activator.getLogHelper().error("Error while creating branch: Unknow error", e); //$NON-NLS-1$
			}
		}
	}

	/**
	 * This allows to pull the current local branch.
	 * 
	 * @param git
	 *            The git.
	 */
	public static void pull(final Git git) {
		if (null != git) {
			try {
				git.pull().call();
			} catch (WrongRepositoryStateException e) {
				Activator.getLogHelper().error("Error while pulling: Reference not found", e); //$NON-NLS-1$
			} catch (InvalidConfigurationException e) {
				Activator.getLogHelper().error("Error while pulling: Invalid configuration", e); //$NON-NLS-1$
			} catch (InvalidRemoteException e) {
				Activator.getLogHelper().error("Error while pulling: Invalid Remote", e); //$NON-NLS-1$
			} catch (CanceledException e) {
				Activator.getLogHelper().error("Error while pulling: Cancel request", e); //$NON-NLS-1$
			} catch (RefNotFoundException e) {
				Activator.getLogHelper().error("Error while pulling: Branch not found", e); //$NON-NLS-1$
			} catch (RefNotAdvertisedException e) {
				Activator.getLogHelper().error("Error while pulling: Branch not Advertised", e); //$NON-NLS-1$
			} catch (NoHeadException e) {
				Activator.getLogHelper().error("Error while pulling: No head", e); //$NON-NLS-1$
			} catch (TransportException e) {
				Activator.getLogHelper().error("Error while pulling: Transport Exception", e); //$NON-NLS-1$
			} catch (GitAPIException e) {
				Activator.getLogHelper().error("Error while pulling: Unknow error", e); //$NON-NLS-1$
			}
		}
	}

	/**
	 * This allows to delete a local branch.
	 * 
	 * @param git
	 *            The git.
	 * @param branchName
	 *            The branch name to delete.
	 */
	public static void deleteLocalBranch(final Git git, final String branchName) {
		if (null != git && !branchName.isEmpty()) {
			try {
				final List<Ref> branches = git.branchList().setListMode(ListMode.ALL).call();
				branches.removeAll(git.branchList().setListMode(ListMode.REMOTE).call());

				for (final Ref branch : branches) {
					if (branch.getName().endsWith(branchName)) {
						git.branchDelete().setBranchNames(branch.getName()).setForce(true).call();
						break;
					}
				}

			} catch (GitAPIException e) {
				Activator.getLogHelper().error("Error while deleting local branch: Unknow error", e); //$NON-NLS-1$
			}
		}
	}

	/**
	 * This allows to get a local branch, return <code>null</code> if it does not exist.
	 * 
	 * @param git
	 *            The git.
	 * @param branchName
	 *            The branch name to search.
	 * @return The branch found or <code>null</code>.
	 */
	public static Ref getLocalBranch(final Git git, final String branchName) {
		if (null != git && !branchName.isEmpty()) {
			try {
				final List<Ref> branches = git.branchList().setListMode(ListMode.ALL).call();
				branches.removeAll(git.branchList().setListMode(ListMode.REMOTE).call());

				for (final Ref branch : branches) {
					if (branch.getName().endsWith(branchName)) {
						return branch;
					}
				}

			} catch (GitAPIException e) {
				Activator.getLogHelper().error("Error while deleting local branch: Unknow error", e); //$NON-NLS-1$
			}
		}
		return null;
	}

	/**
	 * This allows to delete a remote branch.
	 * 
	 * @param git
	 *            The git.
	 * @param branchName
	 *            The branch name to delete.
	 */
	public static void deleteBranch(final Git git, final String branchName) {
		if (null != git && !branchName.isEmpty()) {
			try {
				git.branchDelete().setBranchNames(branchName).setForce(true).call();

				final RefSpec refSpec = new RefSpec().setSource(null).setDestination(branchName);
				git.push().setRefSpecs(refSpec).setRemote(Constants.DEFAULT_REMOTE_NAME).call();
			} catch (GitAPIException e) {
				Activator.getLogHelper().error("Error while deleting branch: Unknow error", e); //$NON-NLS-1$
			}
		}
	}

	/**
	 * This allows to get the list of reviews branches (branches started with 'Review_'.
	 * 
	 * @param git
	 *            The git.
	 * @return The list of reviews branches.
	 */
	public static List<Ref> getReviewBranches(final Git git) {
		final List<Ref> reviewsBranches = new ArrayList<Ref>();
		if (null != git) {
			try {
				final List<Ref> branches = git.branchList().setListMode(ListMode.REMOTE).call();

				for (final Ref branch : branches) {
					if (branch.getName().contains(GitConstants.CONTRIBUTION_BRANCH_PREFIX)) {
						reviewsBranches.add(branch);
					}
				}
			} catch (GitAPIException e) {
				Activator.getLogHelper().error("Error while getting branches: Unknow error", e); //$NON-NLS-1$
			}
		}
		return reviewsBranches;
	}

	/**
	 * This allows to get a branch depending to its name.
	 * 
	 * @param git
	 *            The git.
	 * @param branchName
	 *            The branch name to search.
	 * @return The found branch or <code>null</code>.
	 */
	public static Ref getBranchForName(final Git git, final String branchName) {
		if (null != git) {
			try {
				final List<Ref> branches = git.branchList().setListMode(ListMode.REMOTE).call();

				for (final Ref branch : branches) {
					if (branch.getName().endsWith(branchName)) {
						return branch;
					}
				}
			} catch (GitAPIException e) {
				Activator.getLogHelper().error("Error while getting branches: Unknow error", e); //$NON-NLS-1$
			}
		}
		return null;
	}

	/**
	 * This allows to get the current branch.
	 * 
	 * @param git
	 *            The git;
	 * @return The current branch or <code>null</code> if any problem.
	 */
	public static Ref getCurrentBranch(final Git git) {
		if (null != git) {
			try {
				final String branchName = git.getRepository().getFullBranch();
				return getLocalBranch(git, branchName);
			} catch (IOException e) {
				Activator.getLogHelper().error("Error while getting current branch: Unknow error", e); //$NON-NLS-1$
			}
		}
		return null;
	}

	/**
	 * This allows to determinate if the current branch is up-do_date with the remote master.
	 * 
	 * @param git
	 *            The git.
	 * @return <code>true</code> if the current branch is up-do-date, <code>false</code> otherwise.
	 */
	public static boolean isCurrentBranchIsUpToDate(final Git git) {
		if (null != git) {
			try {
				final String branchName = git.getRepository().getFullBranch();
				final Ref currentBranch = getLocalBranch(git, branchName);
				final Ref remoteBranch = getBranchForName(git, getBranchShortName(branchName));
				if (null != currentBranch && null != remoteBranch) {
					final RevCommit lastCommitOnLocal = getLastCommitOfBranch(git, currentBranch);
					final RevCommit lastCommitOnRemote = getLastCommitOfBranch(git, remoteBranch);
					return null != lastCommitOnLocal && null != lastCommitOnRemote && lastCommitOnLocal.getId().getName().equals(lastCommitOnRemote.getId().getName());
				}
			} catch (IOException e) {
				Activator.getLogHelper().error("Error while getting current branch: Unknow error", e); //$NON-NLS-1$
			}
		}
		return false;
	}

	/**
	 * This allows to merge a branch into master.
	 * 
	 * @param git
	 *            The git.
	 * @param masterBranchName
	 *            The master branch (can be null or empty).
	 * @param branch
	 *            The branch.
	 */
	public static void mergeBranch(final Git git, final String masterBranchName, final Ref branch) {
		if (null != git && null != branch) {
			try {
				String masterName = null == masterBranchName || masterBranchName.isEmpty() ? Constants.MASTER : masterBranchName;

				// Checkout the master branch
				final CheckoutCommand checkoutCommand = (CheckoutCommand) git.checkout();
				checkoutCommand.setName(masterName).setCreateBranch(false).call();

				// Create the merge command
				final MergeCommand mergeCommand = git.merge();
				mergeCommand.include(branch);
				MergeResult res = mergeCommand.call();

				if (res.getMergeStatus().equals(MergeResult.MergeStatus.CONFLICTING)) {
					throw new Exception("Cannot merge the branch due to conflict status"); //$NON-NLS-1$
				}
			} catch (GitAPIException e) {
				Activator.getLogHelper().error("Error while merging branch: Unknow error", e); //$NON-NLS-1$
			} catch (Exception e) {
				Activator.getLogHelper().error(e);
			}
		}
	}

	/**
	 * Get the list commit of a branch.
	 * 
	 * @param git
	 *            The git.
	 * @param branch
	 *            The branch.
	 * @return The last commit of the branch or <code>null</code>.
	 */
	public static RevCommit getLastCommitOfBranch(final Git git, final Ref branch) {
		if (null != git && null != branch) {
			try {
				final RevWalk revWalk = new RevWalk(git.getRepository());
				final RevCommit lastCommit = revWalk.parseCommit(branch.getObjectId());
				revWalk.close();
				return lastCommit;
			} catch (MissingObjectException e) {
				e.printStackTrace();
			} catch (IncorrectObjectTypeException e) {
				e.printStackTrace();
			} catch (IOException e) {
				Activator.getLogHelper().error("Error while getting last commit: Unknow error", e); //$NON-NLS-1$
			}
		}
		return null;
	}

	/**
	 * This allows to get the short name (removing refs/heads or refs/remotes/origin) of a branch.
	 * 
	 * @param branch
	 *            The branch.
	 * @return The short name.
	 */
	public static String getBranchShortName(final Ref branch) {
		return getBranchShortName(branch.getName());
	}

	/**
	 * This allows to get the short name (removing refs/heads or refs/remotes/origin) of a branch.
	 * 
	 * @param branchName
	 *            The branch name.
	 * @return The short name.
	 */
	public static String getBranchShortName(final String branchName) {
		if (branchName.contains(Constants.R_REMOTES)) {
			return branchName.substring(branchName.indexOf(Constants.R_REMOTES) + Constants.R_REMOTES.length() + Constants.DEFAULT_REMOTE_NAME.length() + 1);
		} else if (branchName.contains(Constants.R_HEADS)) {
			return branchName.substring(branchName.indexOf(Constants.R_HEADS) + Constants.R_HEADS.length());
		}
		return branchName;
	}
}
