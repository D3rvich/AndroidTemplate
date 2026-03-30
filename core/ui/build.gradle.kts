import com.android.build.api.dsl.LibraryExtension

plugins {
    alias(libs.plugins.template.android.library.compose)
    alias(libs.plugins.kotlin.serialization)
}

configure<LibraryExtension> {
    namespace = "ru.d3rvich.ui"
}

dependencies {
    implementation(project(":core:domain"))

    implementation(libs.androidx.lifecycle.viewmodel.ktx)
    implementation(libs.androidx.navigation3.runtime)
}