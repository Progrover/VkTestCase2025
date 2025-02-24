pluginManagement {
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "VkTestCase"
include(":app")
include(":core")
include(":feature")
include(":core:base")
include(":core:uicommon")
include(":core:theme")
include(":feature:videoitem")
include(":feature:videolist")
include(":feature:videoitem:api")
include(":feature:videoitem:impl")
include(":feature:videolist:api")
include(":feature:videolist:impl")
