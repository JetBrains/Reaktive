pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()

        val kotlin_repo_url: String? by settings
        val kotlin_version: String? by settings
        val kotlinRepoUrl = kotlin_repo_url
        val kotlinVersion = kotlin_version
        if (!kotlinRepoUrl.isNullOrEmpty() && !kotlinVersion.isNullOrEmpty()) {
            exclusiveContent {
                forRepository {
                    maven(kotlinRepoUrl)
                }
                filter {
                    includeVersionByRegex("org.jetbrains.kotlin.*", ".*", kotlinVersion)
                }
            }
        }
    }
}

dependencyResolutionManagement {
    versionCatalogs {
        create("libs") {
            val kotlin_version: String? by settings
            if (kotlin_version != null) {
                version("kotlin", kotlin_version)
            }
        }
    }
}

includeBuild("includedBuild/gradleConfiguration")

if (!startParameter.projectProperties.containsKey("check_publication")) {
    include(":utils-internal")
    include(":reaktive")
    include(":reaktive-testing")
    include(":reaktive-annotations")
    include(":coroutines-interop")
    include(":rxjava2-interop")
    include(":rxjava3-interop")
    include(":benchmarks:jmh")
    include(":sample-mpp-module")
    include(":sample-android-app")
    include(":sample-js-browser-app")
    include(":sample-linuxx64-app")
} else {
    include(":tools:check-publication")
}
