// Top-level build file where you can add configuration options common to all sub-projects/modules.
//
buildscript {
    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.7.20")
        val naVersion = "2.4.2"
        classpath("androidx.navigation:navigation-safe-args-gradle-plugin:$naVersion")
    }
}

allprojects {
    repositories {
        google()
        mavenCentral()
        maven { url = uri("https://jitpack.io") }
    }
}
tasks {
    register("clean", Delete::class) {
        delete(rootProject.buildDir)
    }
}