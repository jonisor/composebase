import java.io.FileInputStream
import java.util.Properties

@Suppress("DSL_SCOPE_VIOLATION") // TODO: Remove once KTIJ-19369 is fixed
plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.ksp)
}
android {
    namespace = "jonisor.composenavigation.core.network"
    compileSdk = rootProject.extra["sdkVersion"] as Int?

    defaultConfig {
        minSdk = rootProject.extra["minSdkVersion"] as Int?
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildFeatures {
        buildConfig = true
    }

    buildTypes {
        val prop = Properties().apply {
            load(FileInputStream(project.rootProject.file("config/test.properties")))
        }

        debug {
            buildConfigField("String", "BASE_URL", prop.getProperty("API_URL_DEBUG"))
        }
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
            buildConfigField("String", "BASE_URL", prop.getProperty("API_URL_RELEASE"))
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
    implementation(libs.bundles.hilt)
    ksp(libs.hilt.compiler)
    implementation(libs.bundles.retrofit)
}