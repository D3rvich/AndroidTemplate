import com.android.build.api.dsl.LibraryExtension

plugins {
    alias(libs.plugins.template.android.library)
    alias(libs.plugins.template.android.hilt)
}

configure<LibraryExtension> {
    namespace = "ru.d3rvich.data"
}

dependencies {
    implementation(project(":core:domain"))
}