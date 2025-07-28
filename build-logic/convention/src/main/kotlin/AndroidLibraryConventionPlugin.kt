import com.android.build.api.dsl.LibraryExtension
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.dependencies
import ru.d3rvich.androidtemplate.androidTestImplementation
import ru.d3rvich.androidtemplate.configureKotlinAndroid
import ru.d3rvich.androidtemplate.implementation
import ru.d3rvich.androidtemplate.libs
import ru.d3rvich.androidtemplate.testImplementation

class AndroidLibraryConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            pluginManager.apply {
                apply("com.android.library")
                apply("org.jetbrains.kotlin.android")
            }

            extensions.configure<LibraryExtension> {
                configureKotlinAndroid(this)
                lint.targetSdk = 36
                testOptions {
                    targetSdk = 36
                }
                buildTypes {
                    release {
                        isMinifyEnabled = false
                        proguardFiles(
                            getDefaultProguardFile("proguard-android-optimize.txt"),
                            "proguard-rules.pro"
                        )
                    }
                }
                defaultConfig {
                    testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
                    consumerProguardFiles("consumer-rules.pro")
                }
            }

            dependencies {
                implementation(libs.findLibrary("timber").get())
                testImplementation(libs.findLibrary("junit").get())
                androidTestImplementation(libs.findLibrary("junit").get())
                androidTestImplementation(libs.findLibrary("androidx-espresso-core").get())
                androidTestImplementation(libs.findLibrary("androidx-ui-test-junit4").get())
            }
        }
    }
}