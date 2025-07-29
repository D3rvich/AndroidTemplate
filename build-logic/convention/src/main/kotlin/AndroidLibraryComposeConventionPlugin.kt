import com.android.build.api.dsl.LibraryExtension
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.getByType
import ru.d3rvich.androidtemplate.androidTestImplementation
import ru.d3rvich.androidtemplate.configureAndroidCompose
import ru.d3rvich.androidtemplate.libs

class AndroidLibraryComposeConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            pluginManager.apply("template.android.library")

            val extension = extensions.getByType<LibraryExtension>()
            configureAndroidCompose(extension)

            dependencies {
                androidTestImplementation(libs.findLibrary("androidx-junit").get())
                androidTestImplementation(libs.findLibrary("androidx-espresso-core").get())
                androidTestImplementation(libs.findLibrary("androidx-ui-test-junit4").get())
            }
        }
    }
}