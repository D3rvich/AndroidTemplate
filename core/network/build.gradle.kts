import com.android.build.api.dsl.LibraryExtension

plugins {
    alias(libs.plugins.template.android.library)
    alias(libs.plugins.template.android.hilt)
}

configure<LibraryExtension> {
    namespace = "ru.d3rvich.network"
}

dependencies {
    implementation(projects.core.domain)

    implementation(libs.ktor.client.core)
    implementation(libs.ktor.client.android)
    implementation(libs.ktor.client.resources)
    implementation(libs.ktor.client.content.negotiation)
    implementation(libs.ktor.client.serialization.json)
    implementation(libs.ktor.client.logging)
    implementation(libs.ktor.client.logging.slf4j)
}