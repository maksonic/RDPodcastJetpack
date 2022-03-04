
plugins {
    androidApp()
    kotlinAndroid()
}

android {
    compileSdk = Config.compileSdk

    defaultConfig {
        applicationId = Config.appId
        minSdk = Config.minSdk
        targetSdk = Config.targetSdk
        versionCode = Config.versionCode
        versionName = Config.versionName

        testInstrumentationRunner = Config.testInstrumentationRunner
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        getByName(BuildType.RELEASE) {
            isMinifyEnabled = true

            proguardFiles(
                    getDefaultProguardFile("proguard-android-optimize.txt"),
                    "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = Config.javaVersion
        targetCompatibility = Config.javaVersion
    }

    kotlinOptions {
        jvmTarget = Config.jvmTarget
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = Config.composeVersion
    }
    packagingOptions {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {

    implementation(project(Screen.MAIN))
    implementation(project(Screen.HOME))
    implementation(project(Screen.CATEGORIES))
    implementation(project(Screen.COLLECTION))
    implementation(project(Feature.ONBOARDING))
    implementation(Lib.AndroidX.APP_COMPAT)
    implementation(Lib.AndroidX.CORE_KTX)
    implementation(Lib.AndroidX.MATERIAL)
    implementation(Lib.Compose.ACTIVITY)
    implementation(Lib.Compose.COMPILER)
    implementation(Lib.Compose.MATERIAL)
    implementation(Lib.Compose.NAVIGATION)
    implementation(Lib.Compose.UI)
    implementation(Lib.Compose.UI_PREVIEW)
    implementation(Lib.Lifecycle.RUNTIME_KTX)

    testImplementation(Lib.Test.Junit.JUNIT)
    androidTestImplementation(Lib.Test.Junit.EXT)
    androidTestImplementation(Lib.Test.Espresso.CORE)
    androidTestImplementation(Lib.Test.Compose.UI)
    debugImplementation(Lib.Test.Compose.UI_TOOLING)
}