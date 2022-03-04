pluginManagement {
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}
rootProject.name = "RDPodcast"
include (":app")
include(":core")
include(":data")
include(":domain")
include(":screen:main")
include(":screen:home")
include(":screen:categories")
include(":screen:collection")
include(":feature")
include(":feature:onboarding")
