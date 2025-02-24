plugins {
    id(Plugins.library)
    id(Plugins.android)
}

android {
    namespace = Feature.VideoList.api.toBundle()
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
}

dependencies {

    implementation(libs.androidx.junit.ktx)
    coreBase()
    hiltNavigation()
}