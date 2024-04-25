plugins {
    `java-library`
    id("antlr")
    id("io.freefair.lombok") version "8.6"
}

dependencies {
    implementation("org.jetbrains:annotations:24.1.0")
    implementation("org.ainslec:picocog:1.0.7")
    implementation("org.apache.commons:commons-lang3:3.14.0")
    implementation("org.apache.commons:commons-collections4:4.5.0-M1")

    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")

    antlr("org.antlr:antlr4:4.13.1")
    implementation("org.antlr:ST4:4.3.4")
}

tasks.test {
    useJUnitPlatform()
}