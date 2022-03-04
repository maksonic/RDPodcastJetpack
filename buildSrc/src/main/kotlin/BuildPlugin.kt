/**
 * @Author: maksonic on 04.03.2022
 */
class BuildPlugin {
    object ToolsGradle {
        private const val version = "7.1.2"
        const val init = "com.android.tools.build:gradle:$version"
    }

    object KotlinGradle {
        private const val version = "1.6.10"
        const val init = "org.jetbrains.kotlin:kotlin-gradle-plugin:$version"
    }
}