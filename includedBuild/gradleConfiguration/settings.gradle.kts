dependencyResolutionManagement {
    versionCatalogs {
        create("libs") {
            from(files("../../gradle/libs.versions.toml"))
            val kotlin_version: String? by settings
            kotlin_version?.let { version("kotlin", it) }
        }
    }
}
