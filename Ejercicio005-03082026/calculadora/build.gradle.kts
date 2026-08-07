// build.gradle.kts
plugins {
    kotlin("multiplatform") version "2.0.0"
}

repositories {
    mavenCentral()
}



kotlin {
    js {
        browser {
            commonWebpackConfig {
                outputFileName = "main.bundle.js"
            }
        }
        binaries.executable()
    }
}