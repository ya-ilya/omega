val omegaVersion: String by project
val forgeVersion: String by project
val mappingsChannel: String by project
val mappingsVersion: String by project

buildscript {
    repositories {
        mavenCentral()
        maven("https://maven.minecraftforge.net/")
        maven("https://repo.spongepowered.org/maven/")
    }

    dependencies {
        classpath("net.minecraftforge.gradle:ForgeGradle:4.+")
        classpath("org.spongepowered:mixingradle:0.7-SNAPSHOT")
    }
}

plugins {
    kotlin("jvm")
}

apply(plugin = "net.minecraftforge.gradle")
apply(plugin = "org.spongepowered.mixin")

group = "me.yailya"
version = omegaVersion

configure<net.minecraftforge.gradle.userdev.UserDevExtension> {
    mappings(mappingsChannel, mappingsVersion)

    runs {
        create("client") {
            workingDirectory(project.file("run"))

            property("fml.coreMods.load", "me.yailya.omega.mixin.MixinLoader")
            property("mixin.env.disableRefMap", "true")

            property("forge.logging.markers", "SCAN,REGISTRIES,REGISTRYDUMP")
            property("forge.logging.console.level", "debug")
        }
    }
}

configure<org.spongepowered.asm.gradle.plugins.MixinExtension> {
    defaultObfuscationEnv = "searge"
    add(sourceSets["main"], "mixins.omega.refmap.json")
}

repositories {
    mavenCentral()
    maven("https://repo.spongepowered.org/maven/")
}

configurations.create("include")

dependencies {
    "minecraft"("net.minecraftforge:forge:${forgeVersion}")

    "include"("org.spongepowered:mixin:0.8.5") {
        exclude(module = "guava")
        exclude(module = "gson")
        exclude(module = "commons-io")
    }

    annotationProcessor("org.spongepowered:mixin:0.8.5:processor") {
        exclude(module = "gson")
    }

    "include"(kotlin("stdlib-jdk8"))

    implementation(configurations["include"])
}

tasks.processResources {
    from(sourceSets["main"].resources.srcDirs) {
        duplicatesStrategy = DuplicatesStrategy.INCLUDE
        include("mcmod.info")
        expand(mapOf(
            "version" to version,
            "mcversion" to "1.12.2"
        ))
    }
}

tasks.jar {
    manifest.attributes(mapOf(
        "Manifest-Version" to 1.0,
        "MixinConfigs" to "mixins.omega.json",
        "TweakClass" to "org.spongepowered.asm.launch.MixinTweaker",
        "FMLCorePluginContainsFMLMod" to "true",
        "FMLCorePlugin" to "me.yailya.omega.mixin.MixinLoader",
        "ForceLoadAsMod" to "true"
    ))

    duplicatesStrategy = DuplicatesStrategy.INCLUDE

    exclude(
        "**/module-info.class",
        "DebugProbesKt.bin",
        "META-INF/versions/**",
        "META-INF/**.RSA",
        "META-INF/*.kotlin_module",
        "LICENSE.txt",
        "kotlin/**/*.kotlin_metadata",
        "kotlin/**/*.kotlin_builtins",
        "META-INF/*.version"
    )

    from(
        *configurations["include"].map {
            if (it.isDirectory) it else zipTree(it)
        }.toTypedArray()
    )

    finalizedBy("reobfJar")
}