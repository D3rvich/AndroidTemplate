import com.android.build.api.dsl.ApplicationExtension

plugins {
    alias(libs.plugins.template.android.application.compose)
    alias(libs.plugins.template.android.hilt)
    alias(libs.plugins.kotlin.serialization)
}

configure<ApplicationExtension> {
    namespace = "ru.d3rvich.androidtemplate"

    defaultConfig {
        applicationId = "ru.d3rvich.androidtemplate"
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        debug {
            applicationIdSuffix = ".debug"
        }
        release {
            isMinifyEnabled = providers.gradleProperty("minifyWithR8")
                .map(String::toBooleanStrict).getOrElse(true)
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
            signingConfig = signingConfigs.named("debug").get()
        }
    }
}

dependencies {
    implementation(projects.core.domain)
    implementation(projects.core.data)
    implementation(projects.core.ui)
    implementation(projects.core.network)
    implementation(projects.core.database)
    implementation(projects.feature.list)
    implementation(projects.feature.detail)

    implementation(libs.androidx.activity.compose)
    implementation(libs.androidx.navigation3.runtime)
    implementation(libs.androidx.navigation3.ui)
    implementation(libs.androidx.lifecycle.viewmodel.navigation3)
}