package org.digitalforge.gradle.codeartifact

import org.gradle.api.Project
import org.gradle.api.Plugin
import org.gradle.api.artifacts.dsl.RepositoryHandler
import org.gradle.api.initialization.Settings
import org.gradle.api.plugins.PluginAware

class CodeArtifactPlugin implements Plugin<PluginAware> {

    void apply(PluginAware pluginAware) {

        if(pluginAware instanceof Project) {

            Project project = (Project)pluginAware;

            setupCodeArtifactRepository(project.repositories)

            if (project.plugins.hasPlugin('maven-publish')) {
                setupCodeArtifactRepository(project.publishing.repositories)
            }

        }

        if(pluginAware instanceof Settings) {

            Settings settings = (Settings)pluginAware;

            setupCodeArtifactRepository(settings.dependencyResolutionManagement.repositories)

        }

    }

    void setupCodeArtifactRepository(RepositoryHandler repositories) {
        repositories.metaClass.codeartifact = { Closure closure ->
            CodeArtifactRepository repository = new CodeArtifactRepository()
            closure.delegate = repository
            closure.resolveStrategy = Closure.DELEGATE_FIRST
            closure()
            repository.add(repositories)
        }
    }

}
