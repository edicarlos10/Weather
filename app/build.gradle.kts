plugins {
    id ("com.android.application")
    id ("org.jetbrains.kotlin.android")
}

apply (plugin = "kotlin-android")
apply (plugin = "kotlin-parcelize")
apply (plugin = "kotlin-kapt")
apply (plugin = "androidx.navigation.safeargs")

android {
    compileSdk = 33

    buildFeatures {
        dataBinding = true
        viewBinding = true
        compose = true
    }

    defaultConfig {
        applicationId = "com.example.weather"
        minSdk = 23
        targetSdk = 31
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }

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
    composeOptions {
        kotlinCompilerExtensionVersion = "1.3.2"
    }
    packagingOptions {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {
    implementation (project(path = ":network"))
    implementation (project(path = ":domain"))

    implementation (libs.androidx.ktx)
    implementation (libs.androidx.appcompat)
    implementation (libs.android.material)
    implementation (libs.androidx.constraintlayout)
    implementation (libs.androidx.lifecycle.livedata.ktx)
    implementation (libs.androidx.lifecycle.viewmodel)
    implementation (libs.androidx.legacy.support)
    testImplementation (libs.junit)
    androidTestImplementation (libs.androidx.test.ext)

    //retrofit
    implementation (libs.squareup.retrofit2.adapter)
    implementation (libs.squareup.retrofit2)
    implementation (libs.squareup.retrofit2.gson)
    implementation (libs.squareup.retrofit2.moshi)
    implementation (libs.squareup.okhttp3)
    implementation (libs.squareup.okhttp3.logging)
    implementation (libs.squareup.moshi)
    implementation (libs.squareup.okhttp3.mockwebserver)

    //rxJava
    implementation (libs.reactivex.rxjava)
    implementation (libs.reactivex.rxjava.rxkotlin)
    implementation (libs.reactivex.rxjava.rxandroid)

    // Di koin
    implementation (libs.koin)

    // compose
    implementation(libs.icons.material)
    implementation(libs.compose.runtime.livedata)
    implementation(libs.compose.lifecycle.runtime.ktx)
    implementation(libs.compose.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.compose.ui)
    implementation(libs.compose.ui.graphics)
    implementation(libs.compose.ui.tooling.preview)
    implementation(libs.compose.material3)
}