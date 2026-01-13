plugins {
    alias(libs.plugins.runique.android.library)
}

android {
    namespace = "eu.indiewalkabout.core.database"
}

dependencies {
    implementation(libs.org.mongodb.bson)

    implementation(projects.core.domain)
}
