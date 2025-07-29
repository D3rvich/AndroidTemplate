plugins {
    alias(libs.plugins.template.android.library.compose)
}

android {
    namespace = "ru.d3rvich.ui"
}

dependencies {
    implementation(project(":core:domain"))

    implementation(libs.androidx.lifecycle.viewmodel.ktx)
}