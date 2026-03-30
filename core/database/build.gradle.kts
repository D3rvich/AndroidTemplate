import com.android.build.api.dsl.LibraryExtension

plugins {
    alias(libs.plugins.template.android.library)
    alias(libs.plugins.template.android.room)
    alias(libs.plugins.template.android.hilt)
    alias(libs.plugins.kotlin.serialization)
}

configure<LibraryExtension> {
    namespace = "ru.d3rvich.database"

    defaultConfig {
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }
}

dependencies {
    implementation(projects.core.domain)
    implementation(libs.kotlinx.serializationJson)
    implementation(libs.kotlinx.datetime)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}