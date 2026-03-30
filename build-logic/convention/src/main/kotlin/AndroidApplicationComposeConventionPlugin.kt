import com.android.build.api.dsl.ApplicationExtension
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.getByType
import ru.d3rvich.androidtemplate.configureAndroidCompose
import ru.d3rvich.androidtemplate.configureKotlinAndroid
import ru.d3rvich.androidtemplate.libs

class AndroidApplicationComposeConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            pluginManager.apply("com.android.application")
            extensions.configure<ApplicationExtension> {
                configureKotlinAndroid(this)
                defaultConfig {
                    targetSdk = 36
                    minSdk = 24
                }
                testOptions.animationsDisabled = true
            }

            val extension = extensions.getByType<ApplicationExtension>()
            configureAndroidCompose(extension)
            dependencies {
                "debugImplementation"(libs.findLibrary("leakcanary").get())
                "implementation"(libs.findLibrary("timber").get())
                "testImplementation"(libs.findLibrary("junit").get())
                "androidTestImplementation"(libs.findLibrary("junit").get())
                "androidTestImplementation"(libs.findLibrary("androidx-espresso-core").get())
                "androidTestImplementation"(libs.findLibrary("androidx-ui-test-junit4").get())
            }
        }
    }
}