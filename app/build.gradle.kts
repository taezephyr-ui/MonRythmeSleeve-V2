plugins {
    id("com.android.application")
}

android {
    namespace = "fr.monrythmesleeve.app"
    compileSdk = 35

    defaultConfig {
        applicationId = "fr.monrythmesleeve.app"
        minSdk = 26
        targetSdk = 34
        versionCode = 20
        versionName = "2.0.0-beta"
    }
    buildTypes {
        getByName("debug") {
            // Beta independante: elle ne peut pas ecraser la V1 avec une autre signature debug.
            applicationIdSuffix = ".beta"
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
}
