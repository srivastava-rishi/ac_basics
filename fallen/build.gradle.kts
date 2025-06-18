 plugins {
    /*
        alias(libs.plugins.jetbrainsKotlinAndroid) changed this to
   alias(libs.plugins.androidLibrary)
     */
//     alias(libs.plugins.androidLibrary)
     id("com.android.library")
     alias(libs.plugins.jetbrainsKotlinAndroid)
     id("kotlin-kapt")
     id("com.google.dagger.hilt.android")
     kotlin("plugin.serialization") version "2.0.21"
     alias(libs.plugins.compose.compiler)
}

android {
    namespace = "com.rsstudio.fallen"
    compileSdk = 35

    defaultConfig {
       // applicationId = "com.rsstudio.fallen"
        minSdk = 24
        targetSdk = 35
//        versionCode = 1
//        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
    buildFeatures {
        compose = true
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)

    // for navGraph
    implementation(libs.androidx.navigation.compose)
    //hilt
    implementation(libs.dagger.hilt.android)
    implementation(libs.hilt.navigation.compose)
    implementation(libs.hilt.work)
    kapt(libs.dagger.hilt.android.compiler)
    kapt(libs.hilt.compiler)

    // work-work
    implementation(libs.work.runtime)

    // permission
    implementation ("com.google.accompanist:accompanist-permissions:0.31.1-alpha")

    // work manager with coroutine
    val work_version = "2.9.1"
    implementation("androidx.work:work-runtime-ktx:$work_version")


    // JSON serialization library, works with the Kotlin serialization plugin
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.7.3")

    implementation("androidx.graphics:graphics-shapes:1.0.1")
}