plugins {
    id ("com.android.library")
    id ("org.jetbrains.kotlin.android")
}
apply (plugin = "kotlin-android")
apply (plugin = "kotlin-parcelize")
apply (plugin = "kotlin-kapt")

android {
    compileSdk = 31

    defaultConfig {
        minSdk = 23
        targetSdk = 31

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        proguardFiles(getDefaultProguardFile("proguard-android.txt"), "proguard-rules.pro")

    }

    buildTypes {
        release {
            val minifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
}

dependencies {
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))
    implementation (project(path = ":domain"))
    implementation (libs.androidx.ktx)
    implementation (libs.androidx.appcompat)
    implementation (libs.android.material)
    testImplementation (libs.junit)

    //retrofit
    implementation (libs.squareup.retrofit2)
    implementation (libs.squareup.retrofit2.gson)
    implementation (libs.squareup.retrofit2.moshi)
    implementation (libs.squareup.okhttp3)

    //unit test
    implementation (libs.mockk)
    implementation (libs.mockito.android)
    implementation (libs.mockito.core)

    //rxjava
    implementation (libs.reactivex.rxjava)
    implementation (libs.reactivex.rxjava.rxkotlin)
    implementation (libs.reactivex.rxjava.rxandroid)
}