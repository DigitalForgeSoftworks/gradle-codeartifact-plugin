package org.digitalforge.gradle.codeartifact

import org.gradle.api.artifacts.dsl.RepositoryHandler

class CodeArtifactRepository {

    private String name;
    private String region
    private String domain
    private String domainOwner
    private String repository

    void name(String name) {
        this.name = name;
    }

    void region(String region) {
        this.region = region
    }

    void domain(String domain) {
        this.domain = domain
    }

    void domainOwner(String domainOwner) {
        this.domainOwner = domainOwner
    }

    void repository(String repository) {
        this.repository = repository
    }

    void add(RepositoryHandler repositories) {

        CodeArtifactApi api = new CodeArtifactApi(
            this.region,
            this.domain,
            this.domainOwner,
            this.repository,
        )

        repositories.maven {
            name this.name ?: 'codeArtifact'
            url api.repositoryUrl()
            credentials {
                username 'aws'
                password api.authorizationToken()
            }
        }

    }

}
