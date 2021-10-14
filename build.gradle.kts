plugins {
    kotlin("js") version "1.5.10"
}

group = "com.tabris"
version = "1.0-SNAPSHOT"

repositories {
    jcenter()
    mavenCentral()
}

dependencies {
    api(project("tabris-kotlin-wrapper"))
}

kotlin {
    js(IR) {
        binaries.executable()
        browser {
            distribution {
                directory = File("$projectDir/dist/")
            }
            webpackTask {
                outputFileName = "index.js"
                output?.libraryTarget = "commonjs2"
                mode = org.jetbrains.kotlin.gradle.targets.js.webpack.KotlinWebpackConfig.Mode.DEVELOPMENT
            }
            useCommonJs()
        }
    }
}