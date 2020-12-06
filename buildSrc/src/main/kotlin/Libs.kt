import kotlin.String

object Kotlin {
    const val GRADLE_PLUGIN = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.KOTLIN}"
    const val STDLIB = "org.jetbrains.kotlin:kotlin-stdlib:${Versions.KOTLIN}"
    const val COROUTINES_CORE = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.COROUTINES}"
    const val COROUTINES_ANDROID = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.COROUTINES}"
}

object Android {

    // Gradle Plugin
    const val GRADLE_PLUGIN = "com.android.tools.build:gradle:${Versions.AGP}"

    // Core
    const val APP_CORE = "androidx.core:core-ktx:${Versions.APP_CORE}"
    const val APP_COMPAT = "androidx.appcompat:appcompat:${Versions.APP_COMPAT}"

    // UI
    const val FRAGMENT = "androidx.fragment:fragment-ktx:${Versions.FRAGMENT}"
    const val MATERIAL_UI = "com.google.android.material:material:${Versions.MATERIAL}"
    const val CONSTRAINT_LAYOUT = "androidx.constraintlayout:constraintlayout:${Versions.CONSTRAINT_LAYOUT}"
    const val RECYCLER_VIEW = "androidx.recyclerview:recyclerview:${Versions.RECYCLER_VIEW}"

    // Compose
//    const val COMPOSE_UI = "androidx.compose.ui:ui:${Versions.COMPOSE}"
//    const val COMPOSE_MATERIAL = "androidx.compose.material:material:${Versions.COMPOSE}"
//    const val COMPOSE_ICONS = "androidx.compose.material:material-icons-core:${Versions.COMPOSE}"
//    const val COMPOSE_ICONS_EXT = "androidx.compose.material:material-icons-extended:${Versions.COMPOSE}"
//    const val COMPOSE_TOOLING = "androidx.ui:ui-tooling:${Versions.COMPOSE}"
//    const val COMPOSE_COMPILER = "androidx.compose.compiler:compiler:${Versions.COMPOSE}"
//    const val COMPOSE_LIVEDATA = "androidx.compose.runtime:runtime-livedata:${Versions.COMPOSE}"
//    const val COMPOSE_FOUNDATION = "androidx.compose.foundation:foundation:${Versions.COMPOSE}"

    // Navigation
    const val NAV_FRAGMENT = "androidx.navigation:navigation-fragment-ktx:${Versions.NAVIGATION}"
    const val NAV_UI = "androidx.navigation:navigation-ui-ktx:${Versions.NAVIGATION}"
    const val NAV_GRADLE_PLUGIN = "androidx.navigation:navigation-safe-args-gradle-plugin:${Versions.NAVIGATION}"
}

object Testing {

    // Junit
    const val JUNIT = "junit:junit:${Versions.JUNIT}"
    const val JUNIT_KTX = "androidx.test.ext:junit-ktx:${Versions.JUNIT_KTX}"

    // Espresso
    const val ESPRESSO = "androidx.test.espresso:espresso-core:${Versions.ESPRESSO}"

    // Hilt
    const val HILT_TESTS = "com.google.dagger:hilt-android-testing:${Versions.DAGGER}"
    const val HILT_TEST_COMPILER = "com.google.dagger:hilt-android-compiler:${Versions.DAGGER}"

    // Compose
//    const val COMPOSE_TESTS = "androidx.ui:ui-test:${Versions.COMPOSE}"

    // SQLDelight
    const val SQLDELIGHT_TEST_DRIVER = "com.squareup.sqldelight:sqlite-driver:${Versions.SQLDELIGHT}"
    const val SQLDELIGHT_JDBC = "org.xerial:sqlite-jdbc:${Versions.SQLDELIGHT_TEST_DRIVER}"

    // Coroutines
    const val COROUTINES = "org.jetbrains.kotlinx:kotlinx-coroutines-test:${Versions.COROUTINES}"

    // Mockk
    const val MOCKK = "io.mockk:mockk:${Versions.MOCKK}"
}

object Other {

    // Gradle XML Apis
    const val XML_APIS: String = "xml-apis:xml-apis:${Versions.XML_APIS}"

    // SQLDelight
    const val SQLDELIGHT_PLUGIN = "com.squareup.sqldelight:gradle-plugin:${Versions.SQLDELIGHT}"
    const val SQLDELIGHT_COROUTINES = "com.squareup.sqldelight:coroutines-extensions-jvm:${Versions.SQLDELIGHT}"

    // Retrofit
    const val RETROFIT = "com.squareup.retrofit2:retrofit:${Versions.RETROFIT}"
    const val RETROFIT_MOSHI = "com.squareup.retrofit2:converter-moshi:${Versions.RETROFIT}"

    // Moshi
    const val MOSHI = "com.squareup.moshi:moshi:${Versions.MOSHI}"
    const val MOSHI_KAPT = "com.squareup.moshi:moshi-kotlin-codegen:${Versions.MOSHI}"

    //Lottie
    const val LOTTIE = "com.airbnb.android:lottie:${Versions.LOTTIE}"

    // Hilt
    const val HILT = "com.google.dagger:hilt-android:${Versions.DAGGER}"
    const val HILT_COMPILER = "com.google.dagger:hilt-android-compiler:${Versions.DAGGER}"
    const val HILT_PLUGIN = "com.google.dagger:hilt-android-gradle-plugin:${Versions.DAGGER}"
    const val HILT_VIEWMODEL = "androidx.hilt:hilt-lifecycle-viewmodel:${Versions.HILT_VIEWMODEL}"

    // Detekt
    const val DETEKT = "io.gitlab.arturbosch.detekt:io.gitlab.arturbosch.detekt.gradle.plugin:${Versions.DETEKT}"

    //Jacoco
    const val JACOCO = "org.jacoco:org.jacoco.core:${Versions.JACOCO}"

    // Arrow
    const val ARROW_BOM = "io.arrow-kt:arrow-stack:${Versions.ARROW}"
    const val ARROW_CORE = "io.arrow-kt:arrow-core"
}
