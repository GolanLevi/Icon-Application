plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.google.services)
}

android {
    namespace = "com.example.iconapplication"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.iconapplication"
        minSdk = 26
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}

dependencies {

    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.activity)
    implementation(libs.constraintlayout)
    implementation(libs.play.services.location)
    implementation(libs.recyclerview)
    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)

    //Lottie:
    implementation (libs.lottie)

    //Glide:
    implementation (libs.glide)

    //Maps:
    implementation (libs.play.services.maps)

    //noinspection UseTomlInstead
    implementation("com.google.android.play:app-update:2.1.0")
    implementation(libs.app.update.ktx)
    implementation (libs.play.services.maps.vyourversion)
    implementation (libs.google.gson)



    implementation (libs.material)

    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.activity)
    implementation(libs.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)

    //FireBase:
    implementation(platform(libs.firebase.bom))
    implementation(libs.firebase.analytics)

    //FireBase Authentication:
    implementation(libs.firebase.ui.auth)

    implementation (libs.google.firebase.auth)


}