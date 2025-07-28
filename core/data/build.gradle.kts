plugins {
    alias(libs.plugins.template.android.library)
    alias(libs.plugins.template.android.hilt)
}

android {
    namespace = "ru.d3rvich.data"
}

dependencies {
    implementation(project(":core:domain"))
}