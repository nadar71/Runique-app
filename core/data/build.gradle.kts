plugins {
    alias(libs.plugins.runique.android.library)

}

android {
    namespace = "eu.indiewalkabout.core.data"
}

dependencies {
    implementation(libs.timber)

    implementation(projects.core.domain)
    implementation(projects.core.database)
}
