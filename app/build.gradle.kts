import com.android.build.api.dsl.Packaging

plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.ksp)
    alias(libs.plugins.hilt)
}

android {
    namespace = "com.example.composenavigation"
    compileSdk = rootProject.extra["sdkVersion"] as Int?

    defaultConfig {
        applicationId = "com.example.composenavigation"
        minSdk = rootProject.extra["minSdkVersion"] as Int?
        targetSdk = rootProject.extra["sdkVersion"] as Int?
        versionCode = 1
        versionName = "0.0.1"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
    
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = libs.versions.kotlinCompilerExtension.get()
    }
    fun Packaging.() {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }

    applicationVariants.all {
        addJavaSourceFoldersToModel(
            File(buildDir, "generated/ksp/$name/kotlin")
        )
    }
}

dependencies {
    implementation(project(":core:common"))
    implementation(project(":feature:home"))
    implementation(project(":feature:latest"))

    implementation(libs.android.core.ktx)
    implementation(libs.android.activity)
    implementation(libs.bundles.compose)

    implementation(libs.bundles.hilt)
    ksp(libs.hilt.compiler)

    implementation(libs.compose.destinations)
    ksp(libs.compose.destinations.ksp)

    testImplementation(libs.junit)
    androidTestImplementation(libs.bundles.test.android)
    debugImplementation(libs.bundles.test.debug)
}