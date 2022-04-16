/**
 * @Author: maksonic on 04.03.2022
 */
class BuildPlugin {
    object ToolsGradle {
        private const val version = "7.1.3"
        const val init = "com.android.tools.build:gradle:$version"
    }

    object HiltGradle {
        private const val version = "2.40"
        const val init = "com.google.dagger:hilt-android-gradle-plugin:$version"
    }

    object KotlinGradle {
        private const val version = "1.6.10"
        const val init = "org.jetbrains.kotlin:kotlin-gradle-plugin:$version"
    }
}