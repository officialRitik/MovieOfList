// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {
   // val kotlin_version = " 1.8.10"

    repositories {
        google()
    }
    dependencies {

        val nav_version = "2.7.7"
        classpath("androidx.navigation:navigation-safe-args-gradle-plugin:$nav_version")

        classpath ("com.google.dagger:hilt-android-gradle-plugin:2.51.1")
    }
}

plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.jetbrains.kotlin.android) apply false
    id("com.google.dagger.hilt.android") version "2.44" apply false

}