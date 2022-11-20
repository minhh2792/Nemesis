group = "nemesis"
version = "1.0"

plugins {
    `java-library`
}

apply(plugin = "java")

repositories {
    mavenCentral()
    maven("https://hub.spigotmc.org/nexus/content/repositories/snapshots/")
    maven("https://oss.sonatype.org/content/groups/public/")
    maven("https://repo.spongepowered.org/repository/maven-public/")
}

dependencies {
    compileOnly("org.spigotmc:spigot-api:1.17.1-R0.1-SNAPSHOT")
    compileOnly("org.spongepowered:mixin:0.8.5-SNAPSHOT")
}

tasks.withType<JavaCompile>() {
    options.encoding = "UTF-8"
}

java {
    toolchain.languageVersion.set(JavaLanguageVersion.of(11))
}