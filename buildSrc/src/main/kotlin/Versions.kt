import kotlin.String
import org.gradle.plugin.use.PluginDependenciesSpec
import org.gradle.plugin.use.PluginDependencySpec

/**
 * Generated by https://github.com/jmfayard/buildSrcVersions
 *
 * Find which updates are available by running
 *     `$ ./gradlew buildSrcVersions`
 * This will only update the comments.
 *
 * YOU are responsible for updating manually the dependency version.
 */
object Versions {
    const val androidx_compose_material: String = "1.0.0-alpha05"

    const val com_squareup_sqldelight: String = "1.4.4"

    const val com_squareup_retrofit2: String = "2.9.0"

    const val org_jetbrains_kotlin: String = "1.4.10"

    const val com_google_dagger: String = "2.28-alpha"

    const val androidx_ui: String = "1.0.0-alpha05"

    const val org_jacoco: String = "0.7.9"

    const val com_google_android_material_material: String = "1.3.0-alpha03"

    const val androidx_compose_compiler_compiler: String = "1.0.0-alpha05"

    const val com_android_tools_build_gradle: String = "4.2.0-alpha15"

    const val io_gitlab_arturbosch_detekt_gradle_plugin: String = "1.14.2"

    const val de_fayard_buildsrcversions_gradle_plugin: String = "0.7.0"

    const val moshi_kotlin_codegen: String = "1.11.0"

    const val constraintlayout: String = "2.0.3"

    const val runtime_livedata: String = "1.0.0-alpha05"

    const val espresso_core: String = "3.4.0-alpha02"

    const val fragment_ktx: String = "1.3.0-beta01"

    const val recyclerview: String = "1.2.0-alpha06"

    const val lint_gradle: String = "27.2.0-alpha15"

    const val viewbinding: String = "4.2.0-alpha15"

    const val foundation: String = "1.0.0-alpha05"

    const val appcompat: String = "1.3.0-alpha02"

    const val junit_ktx: String = "1.1.3-alpha02"

    const val core_ktx: String = "1.5.0-alpha04"

    const val xml_apis: String = "1.4.01"

    const val junit: String = "4.13.1"

    const val ui: String = "1.0.0-alpha05"

    /**
     * Current version: "6.7"
     * See issue 19: How to update Gradle itself?
     * https://github.com/jmfayard/buildSrcVersions/issues/19
     */
    const val gradleLatestVersion: String = "6.7"
}

/**
 * See issue #47: how to update buildSrcVersions itself
 * https://github.com/jmfayard/buildSrcVersions/issues/47
 */
val PluginDependenciesSpec.buildSrcVersions: PluginDependencySpec
    inline get() =
            id("de.fayard.buildSrcVersions").version(Versions.de_fayard_buildsrcversions_gradle_plugin)
