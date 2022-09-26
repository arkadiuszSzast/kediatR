group = "com.trendyol"
version = "2.0.0"

plugins {
    kotlin("jvm") version "1.7.10"
}

allprojects {
    repositories {
        mavenCentral()
        maven {
            url = uri("https://oss.sonatype.org/content/repositories/snapshots")
        }

        maven {
            url = uri("https://repo.maven.apache.org/maven2/")
        }
    }
}

subprojects {
    apply(plugin = "kotlin")

    dependencies {
        implementation(platform("org.jetbrains.kotlinx:kotlinx-coroutines-bom:1.6.4"))
        implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.4")
    }

    dependencies {
        testImplementation("org.jetbrains.kotlinx:kotlinx-coroutines-test:1.6.4")
        testImplementation(platform("org.junit:junit-bom:5.9.1"))
        testImplementation("org.junit.jupiter:junit-jupiter")
    }

    tasks.test {
        useJUnitPlatform()
        testLogging {
            showStandardStreams = true
            showCauses = true
            showStackTraces = true
            events("PASSED", "FAILED", "SKIPPED", "STANDARD_OUT")
            exceptionFormat = org.gradle.api.tasks.testing.logging.TestExceptionFormat.FULL
        }
    }

    tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
        kotlinOptions {
            freeCompilerArgs = listOf("-Xjsr305=strict")
            jvmTarget = "11"
        }
    }
}