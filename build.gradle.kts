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
    // External, added in package.json
    // implementation(npm("tabris", "3.7.2"))
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
            }
            useCommonJs()
        }
    }
}