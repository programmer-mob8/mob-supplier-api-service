plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)

    alias(libs.plugins.kotlin.kapt)
    alias(libs.plugins.dagger.hilt.android)
    alias(libs.plugins.kotlinx.kover)
}

group = "com.project.libs"

android {
    namespace = "com.project.libs"
    compileSdk = 35

    defaultConfig {
        minSdk = 26

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    kotlin {
        jvmToolchain(17)
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
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)

    // Retrofit
    implementation(libs.retrofit)
    implementation(libs.retrofit.converter.gson)
    implementation(libs.okhttp.logging.interceptor)

    // Coroutines
    implementation(libs.kotlinx.coroutines.core)
    implementation(libs.kotlinx.coroutines.android)

    // Hilt
    implementation(libs.hilt.android)
    implementation(libs.hilt.navigation.compose)
    kapt(libs.hilt.android.compiler)
    kapt(libs.hilt.compiler)

    // Testing
    testImplementation(libs.junit)
    testImplementation(libs.truth)
    testImplementation(libs.truth.java8.extension)
    testImplementation(libs.mockk)
    testImplementation(libs.kotlinx.coroutines.test)
    testImplementation(libs.core.testing)
    testImplementation("com.squareup.okhttp3:mockwebserver:4.9.3")

}

koverReport {
    val excludePackages = listOf(
        "dagger.hilt.internal.aggregatedroot.codegen.*",
        "hilt_aggregated_deps.*",
        "com.project.libs.*.di.*",
        "com.project.libs.*.Hilt_*",
        "com.project.libs.*.*_Factory*",
        "com.project.libs.*.*_HiltModules*",
        "com.project.libs.*.*Module_*",
        "com.project.libs.*.*MembersInjector*",
        "com.project.libs.*.*_Impl*",
        "com.project.libs.ComposableSingletons*",
        "com.project.libs.BuildConfig*",
        "com.project.libs.*.Fake*",
        "com.project.libs.app.ComposableSingletons*",
        "*_*Factory.*",
        "*_*Factory*",
        "*_Factory.*",
        "Hilt_*",
        "*_Hilt*",
        "*.navigation.*"
    )

    val includePackages = listOf(
        "com.project.libs.data.*",
        "com.project.libs.domain*",
        "com.project.libs.ui.*.viewmodel",
        "com.project.libs.ui.*.uistate",
        "com.project.libs.ui.*.model",
    )

    filters {
        excludes {
            classes(
                "dagger.hilt.internal.aggregatedroot.codegen.*",
                "hilt_aggregated_deps.*",
                "com.project.libs.*.di.*",
                "com.project.libs.*.Hilt_*",
                "com.project.libs.*.*_Factory*",
                "com.project.libs.*.*_HiltModules*",
                "com.project.libs.*.*Module_*",
                "com.project.libs.*.*MembersInjector*",
                "com.project.libs.*.*_Impl*",
                "com.project.libs.ComposableSingletons*",
                "com.project.libs.BuildConfig*",
                "com.project.libs.*.Fake*",
                "com.project.libs.app.ComposableSingletons*"
            )

            packages(
                "kotlinx.coroutines.*"
            )
        }
    }

    androidReports("debug") {
        xml {
            onCheck = true

            setReportFile(file("result.xml"))

            filters {
                excludes {
                    classes(
                        excludePackages
                    )

                    packages(
                        "kotlinx.coroutines.*"
                    )
                }

                includes {
                    packages(
                        includePackages
                    )
                }
            }
        }
        html {
            title = "Kover Report"

            charset = "UTF-8"

            onCheck = true

            filters {
                excludes {
                    classes(
                        excludePackages
                    )

                    packages(
                        "kotlinx.coroutines.*"
                    )
                }

                includes {
                    packages(
                        includePackages
                    )
                }
            }
        }
    }
}
