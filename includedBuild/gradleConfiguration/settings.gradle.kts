dependencyResolutionManagement {
    versionCatalogs {
        create("libs") {
            from(files("../../gradle/libs.versions.toml"))
            val kotlin_version: String? by settings
            if (kotlin_version != null) {
                version("kotlin", kotlin_version)
            }
        }
    }
}
