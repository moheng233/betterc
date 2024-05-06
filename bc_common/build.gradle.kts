import gg.jte.ContentType

plugins {
    `java-library`
    id("antlr")
    id("io.freefair.lombok")
    id("gg.jte.gradle")
}

val jetVersion: String by project

repositories {
    maven("https://oss.sonatype.org/content/repositories/snapshots/")
}

java {
    sourceCompatibility = JavaVersion.VERSION_21;
    targetCompatibility = JavaVersion.VERSION_21;
}

jte {
    generate()
    contentType = ContentType.Plain


    jteExtension("gg.jte.models.generator.ModelExtension") {
        property("language", "Java")
    }

}

val junitVersion: String by project
val jetbrainsAnnotationsVersion: String by project

dependencies {
    implementation("org.jetbrains:annotations:$jetbrainsAnnotationsVersion")
    implementation("org.ainslec:picocog:1.0.7")
    implementation("org.apache.commons:commons-lang3:3.14.0")
    implementation("org.apache.commons:commons-collections4:4.5.0-M1")

    implementation("gg.jte:jte-runtime:$jetVersion")
    implementation("gg.jte:jte-watcher:$jetVersion")
    jteGenerate("gg.jte:jte-models:$jetVersion")

    testImplementation(platform("org.junit:junit-bom:$junitVersion"))
    testImplementation("org.junit.jupiter:junit-jupiter")

    antlr("org.antlr:antlr4:4.13.1")
}

tasks.test {
    useJUnitPlatform()
}