plugins {
    id(Plugins.library)
    id(Plugins.android)
    id(Plugins.hilt)
    kotlin(Plugins.kapt)
}

android {
    namespace = Feature.VideoItem.impl.toBundle()
    compileSdk = ProjectConfig.compileSdk

    defaultConfig {
        minSdk = ProjectConfig.minSdk

        testInstrumentationRunner = ProjectConfig.TEST_INSTRUMENTATION_RUNNER
    }

    compileOptions {
        sourceCompatibility = ProjectConfig.javaVersion
        targetCompatibility = ProjectConfig.javaVersion
    }
    kotlinOptions {
        jvmTarget = ProjectConfig.jvmTarget
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = Versions.composeCompiler
    }
}

dependencies {

    implementation(libs.androidx.media3.exoplayer)
    implementation(libs.androidx.media3.ui)
    coreBase()
    coreTheme()
    coreUiCommon()

    hilt()
    compose()
    navigation()
    coil()

    implementation(Dependencies.exoPlayer)

    itemApi()
}

kapt {
    correctErrorTypes = true
}