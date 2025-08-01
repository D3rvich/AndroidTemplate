plugins {
    alias(libs.plugins.template.android.application.compose)
    alias(libs.plugins.template.android.hilt)
    alias(libs.plugins.kotlin.serialization)
}

android {
    namespace = "ru.d3rvich.androidtemplate"

    defaultConfig {
        applicationId = "ru.d3rvich.androidtemplate"
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }
}

dependencies {
    implementation(project(":core:domain"))
    implementation(project(":core:data"))
    implementation(project(":core:ui"))
    implementation(project(":feature:list"))
    implementation(project(":feature:detail"))

    implementation(libs.androidx.activity.compose)
    implementation(libs.androidx.compose.navigation)
}