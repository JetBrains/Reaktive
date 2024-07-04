plugins {
    `kotlin-dsl`
    `java-gradle-plugin`
}

repositories {
    google()
    mavenCentral()
    gradlePluginPortal()

    val kotlin_repo_url: String? by project
    kotlin_repo_url?.let { maven(it) }
}

dependencies {
    implementation(libs.kotlin.plugin)
    implementation(libs.android.plugin)
    implementation(libs.jmh.plugin)
    implementation(libs.detekt.plugin)
    implementation(libs.shadow)
    implementation(libs.kotlinx.compatibility)
    implementation(libs.publish.plugin)
    implementation(libs.dokka.plugin)
    implementation(libs.kotlinx.metadata)
}

gradlePlugin {
    plugins.register("mpp-configuration") {
        id = "mpp-configuration"
        implementationClass = "com.badoo.reaktive.configuration.MppConfigurationPlugin"
    }
    plugins.register("publish-configuration") {
        id = "publish-configuration"
        implementationClass = "com.badoo.reaktive.publish.PublishConfigurationPlugin"
    }
    plugins.register("binary-compatibility-configuration") {
        id = "binary-compatibility-configuration"
        implementationClass = "com.badoo.reaktive.compatibility.BinaryCompatibilityConfigurationPlugin"
    }
    plugins.register("detekt-configuration") {
        id = "detekt-configuration"
        implementationClass = "com.badoo.reaktive.detekt.DetektConfigurationPlugin"
    }
}
