/*
 * Use the following Gradle tasks to run your application:
 * :jsBrowserProductionRun - release mode JS
 * :jsBrowserDevelopmentRun - debug mode JS
 * :wasmJsBrowserProductionRun - release mode WASM-JS
 * :wasmJsBrowserDevelopmentRun - debug mode WASM-JS
 */
import org.jetbrains.kotlin.gradle.targets.js.dsl.ExperimentalWasmDsl

plugins {
    id("kotlin-multiplatform")
}

kotlin {
    js {
        browser()
        binaries.executable()
    }
    @OptIn(ExperimentalWasmDsl::class)
    wasmJs {
        binaries.executable()
        browser()
    }

    compilerOptions {
        val kotlin_language_version: String? by project
        kotlin_language_version?.let { languageVersion.set(org.jetbrains.kotlin.gradle.dsl.KotlinVersion.fromVersion(it)) }

        val kotlin_api_version: String? by project
        kotlin_api_version?.let { apiVersion.set(org.jetbrains.kotlin.gradle.dsl.KotlinVersion.fromVersion(it)) }
    }


    sourceSets {
        commonMain.dependencies {
            implementation(project(":reaktive"))
            implementation(project(":sample-mpp-module"))
        }
        wasmJsMain.dependencies {
            implementation("org.jetbrains.kotlinx:kotlinx-browser:0.1")
        }
    }
}
