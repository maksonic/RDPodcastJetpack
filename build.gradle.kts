buildscript {
    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        classpath(BuildPlugin.ToolsGradle.init)
        classpath(BuildPlugin.HiltGradle.init)
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.6.10")
    }
}

task<Delete>("clean") {
    delete(rootProject.buildDir)
}