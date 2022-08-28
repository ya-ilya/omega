val omegaVersion: String by project
val forgeVersion: String by project
val mappingsChannel: String by project
val mappingsVersion: String by project

buildscript {
    repositories {
        mavenCentral()
        maven("https://maven.minecraftforge.net/")
    }

    dependencies {
        classpath("net.minecraftforge.gradle:ForgeGradle:4.+")
    }
}

plugins {
    kotlin("jvm")
}

apply(plugin = "net.minecraftforge.gradle")

group = "me.yailya"
version = omegaVersion

configure<net.minecraftforge.gradle.userdev.UserDevExtension> {
    mappings(mappingsChannel, mappingsVersion)

    runs {
        create("client") {
            workingDirectory(project.file("run"))

            property("forge.logging.markers", "SCAN,REGISTRIES,REGISTRYDUMP")
            property("forge.logging.console.level", "debug")
        }
    }
}

repositories {
    mavenCentral()
}

dependencies {
    "minecraft"("net.minecraftforge:forge:${forgeVersion}")
}