import org.jetbrains.intellij.platform.gradle.TestFrameworkType
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("java")
    id("org.jetbrains.kotlin.jvm") version "2.0.20"
    id("org.jetbrains.intellij.platform") version "2.1.0"
}

group = "dev.ja.godepdemo"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()

    intellijPlatform {
        defaultRepositories()
    }
}

dependencies {
    testImplementation("junit:junit:4.13.2")
    testImplementation("org.opentest4j:opentest4j:1.3.0")

    intellijPlatform {
        // 2024.3 eap
        intellijIdeaUltimate("243.19420.21")
        plugin("org.jetbrains.plugins.go:243.19420.21")

        // 2024.2
        // intellijIdeaUltimate("2024.2.3")
        // plugin("org.jetbrains.plugins.go:242.22855.36")

        instrumentationTools()
        pluginVerifier()
        testFramework(TestFrameworkType.Platform)
    }
}

intellijPlatform {
    pluginConfiguration {
        ideaVersion {
            sinceBuild = "242.0"
            untilBuild = "243.*"
        }
    }

    pluginVerification {
        ides {
            recommended()
        }
    }
}

java {
    toolchain {
        sourceCompatibility = JavaVersion.toVersion(21)
        targetCompatibility = JavaVersion.toVersion(21)
    }
}

// Additional tasks to help testing the localized plugin
tasks {
    withType<KotlinCompile>().configureEach {
        kotlinOptions {
            jvmTarget = "21"
            apiVersion = "1.9"
        }
    }
}