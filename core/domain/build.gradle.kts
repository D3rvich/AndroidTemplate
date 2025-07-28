plugins {
    alias(libs.plugins.template.jvm.library)
    alias(libs.plugins.ksp)
}
dependencies {
    implementation(libs.javax.inject)
    implementation(libs.kotlinx.coroutines)
}
