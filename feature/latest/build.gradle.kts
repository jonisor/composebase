@Suppress("DSL_SCOPE_VIOLATION") // TODO: Remove once KTIJ-19369 is fixed
plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.ksp)
}

android {
    namespace = "jonisor.composenavigation.feature.latest"
    compileSdk = rootProject.extra["sdkVersion"] as Int?

    defaultConfig {
        minSdk = rootProject.extra["minSdkVersion"] as Int?

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
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

    ksp {
        arg("compose-destinations.moduleName", "latest")
        arg("compose-destinations.mode", "destinations")
    }
}

dependencies {
    implementation(project(":core:common"))
    implementation(project(":core:data"))

    implementation(libs.android.activity)

    implementation(libs.bundles.hilt)
    ksp(libs.hilt.compiler)

    implementation(libs.compose.destinations)
    ksp(libs.compose.destinations.ksp)

    implementation(libs.bundles.compose)

    testImplementation(libs.junit)
    androidTestImplementation(libs.bundles.test.android)
}