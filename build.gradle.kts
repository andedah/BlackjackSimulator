plugins {
    kotlin("jvm") version "1.6.10"
    id("com.diffplug.spotless") version "6.2.2"
    application
}

group = "org.andedah.blackjack"
version = "1.0"

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-stdlib")
    implementation("org.junit.jupiter:junit-jupiter:5.8.2")
}

tasks.withType<Test> {
    useJUnitPlatform()
}

spotless {
    kotlin {
        ktfmt()
    }
    format("markdown") {
        target("**/*.md")
        prettier().config(mapOf(
            "parser" to "markdown",
            "proseWrap" to "always",
            "printWidth" to 100))
    }
}

application {
    mainClass.set("org.andedah.blackjack.BlackjackApplicationKt")
}