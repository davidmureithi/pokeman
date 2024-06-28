plugins {
    `kotlin-dsl`
}

repositories {
    google()
    mavenCentral()
}

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-gradle-plugin:1.9.22")
    implementation("com.android.tools.build:gradle:8.2.2")

//    implementation(Dependencies.kotlinGradlePlugin)
//    implementation(Dependencies.gradlePlugin)
}
