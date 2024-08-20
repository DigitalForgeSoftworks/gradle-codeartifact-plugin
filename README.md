# Gradle CodeArtifact Plugin

This plugin extends the Gradle `RepositoryHandler` to add support for CodeArtifact repositories.


## Usage

You can add the plugin like this and add as many codeartifact repositories, as you want:

```groovy
plugins {
    id 'org.digitalforge.gradle.codeartifact' version '1.0.1'
}

repositories {
    codeartifact {
        region '<region>'
        domain '<domain>'
        domainOwner '<domainOwner>'
        repository '<repository>'
    }
}
```

Or to add repositories to the Publishing plugin:

```groovy
plugins {
    id 'maven-publish'
    id 'org.digitalforge.gradle.codeartifact' version '1.0.1'
}

publishing {
    repositories {
        codeartifact {
            region '<region>'
            domain '<domain>'
            domainOwner '<domainOwner>'
            repository '<repository>'
        }
    }
}
```

## License

[![Apache License 2.0](https://img.shields.io/badge/License-Apache_2.0-blue.svg)](LICENSE)
