plugins {
    id("antlr")
}

dependencies {
    implementation("org.jetbrains:annotations:24.1.0")
    implementation("org.ainslec:picocog:1.0.7")

    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")

    antlr("org.antlr:antlr4:4.13.1")
}

tasks.test {
    useJUnitPlatform()
}