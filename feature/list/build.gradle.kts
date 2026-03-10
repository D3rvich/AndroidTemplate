import com.android.build.api.dsl.LibraryExtension

plugins {
    alias(libs.plugins.template.android.feature)
}

configure<LibraryExtension> {
    namespace = "ru.d3rvich.list"
}

dependencies {
}