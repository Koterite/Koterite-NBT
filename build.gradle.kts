plugins {
    kotlin("multiplatform") version "1.3.71"
}

group = "br.com.gamemods.koterite"
version = "1.0.0-SNAPSHOT"

repositories {
    mavenCentral()
}

kotlin {
    jvm()
    mingwX64("windows").binaries.sharedLib("koterite_nbt")
    linuxX64().binaries.sharedLib("koterite_nbt")
    /* Targets configuration omitted. 
    *  To find out how to configure the targets, please follow the link:
    *  https://kotlinlang.org/docs/reference/building-mpp-with-gradle.html#setting-up-targets */

    sourceSets {
        val commonMain by getting {
            dependencies {
                api(kotlin("stdlib-common"))
                api("br.com.gamemods.koterite:koterite-annotations:1.0.0-SNAPSHOT")
            }
        }
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test-common"))
                implementation(kotlin("test-annotations-common"))
            }
        }

        val jvmMain by getting {
            dependencies {
                api(kotlin("stdlib"))
            }
        }
        val jvmTest by getting {
            dependencies {
                implementation(kotlin("test-junit"))
            }
        }
    }
}