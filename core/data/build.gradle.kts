@Suppress("DSL_SCOPE_VIOLATION") // TODO: Remove once KTIJ-19369 is fixed
plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.ksp)
}
android {
    namespace = "jonisor.composenavigation.core.data"
    compileSdk = rootProject.extra["sdkVersion"] as Int?

    defaultConfig {
        minSdk = rootProject.extra["minSdkVersion"] as Int?
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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
}

dependencies {
    implementation((project(":core:network")))
    implementation(libs.core.ktx)
    implementation(libs.bundles.retrofit)
    implementation(libs.bundles.hilt)
    ksp(libs.hilt.compiler)
}