plugins {
    alias(libs.plugins.runique.android.feature.ui)
}

android {
}

dependencies {
    implementation(projects.core.domain)
    implementation(projects.auth.domain)
}
