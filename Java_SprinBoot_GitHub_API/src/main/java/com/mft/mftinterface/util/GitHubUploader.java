package com.mft.mftinterface.util;

import org.eclipse.jgit.lib.Repository;
import org.springframework.beans.factory.annotation.Value;

public class GitHubUploader {

    private static final String GITHUB_REPO_OWNER = @Value("${github.repo.owner}");
    private static final String GITHUB_REPONAME = @Value("${github.repo.reponame}");
    private static final String GITHUB_TOKEN = @Value("${github.token}");

    public static void uploadFilesToGitHub(String tfconfig) {
        try {
            RepositoryService repositoryService = new RepositoryService();
            ContentServvice contentServvice = new ContentService();

            Repository repository = repositoryService.getRepository(GITHUB_REPO_OWNER,GITHUB_REPONAME);

            RepositoryContents contents =new RepositoryContents();
            contents.setPath("mft_request.tf");
            contents.setContent(tfconfig);
            contents.setMessage("Added MFT Request");

            //Upload File to the repository
            contentServvice.createFile(repository,contents);
        } catch (Exception e) {
            System.out.print(e.getMessage());
        }
    }
}
