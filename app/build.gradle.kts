plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("org.jetbrains.kotlin.kapt") //them
    id("androidx.navigation.safeargs.kotlin")//them

 //them


}


android {


    namespace = "com.example.bai30rom"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.bai30rom"
        minSdk = 29
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
    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_1_8.toString() //them

    }
    buildFeatures {
        viewBinding=true
    }

}

dependencies {

    implementation("androidx.core:core-ktx:1.9.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.11.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")





    //them

    implementation("androidx.room:room-runtime:2.6.1")
    annotationProcessor("androidx.room:room-compiler:2.6.1")

    // To use Kotlin annotation processing tool (kapt)
    kapt("androidx.room:room-compiler:2.6.1")
    // To use Kotlin Symbol Processing (KSP)

    // optional - Kotlin Extensions and Coroutines support for Room
    implementation("androidx.room:room-ktx:2.6.1")

    // optional - RxJava2 support for Room
    implementation("androidx.room:room-rxjava2:2.6.1")

    // optional - RxJava3 support for Room
    implementation("androidx.room:room-rxjava3:2.6.1")

    // optional - Guava support for Room, including Optional and ListenableFuture
    implementation("androidx.room:room-guava:2.6.1")

    // optional - Test helpers
    testImplementation("androidx.room:room-testing:2.6.1")

    // optional - Paging 3 Integration
    implementation("androidx.room:room-paging:2.6.1")


    //them Lifecycle components
    implementation ("androidx.lifecycle:lifecycle-extensions:2.2.0")
    implementation ("androidx.lifecycle:lifecycle-common-java8:2.7.0")
    implementation ("androidx.lifecycle:lifecycle-viewmodel-ktx:2.7.0")
    kapt ("com.android.databinding:compiler:3.2.0-alpha10")
    api ("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.7.1")
    api ("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.7.1")
    implementation ("org.jetbrains.kotlin:kotlin-stdlib-jdk7:1.9.21")
    implementation ("com.google.android.material:material:1.11.0")
    // Java language implementation
    implementation("androidx.navigation:navigation-fragment-ktx:2.7.6")
    implementation("androidx.navigation:navigation-ui-ktx:2.7.6")


    // Kotlin
    implementation("androidx.navigation:navigation-fragment-ktx:2.7.6")
    implementation("androidx.navigation:navigation-ui-ktx:2.7.6")

    // Feature module Support
    implementation("androidx.navigation:navigation-dynamic-features-fragment:2.7.6")

    // Testing Navigation
    androidTestImplementation("androidx.navigation:navigation-testing:2.7.6")

    // Jetpack Compose Integration
    implementation("androidx.navigation:navigation-compose:2.7.6")
    implementation ("com.google.android.material:material:1.11.0")
}