plugins {
    application
    `java-library`
}

application {
    mainClass = "site.moheng.betterc.lsp.Main"
}

dependencies {
    implementation("org.jetbrains:annotations:24.1.0")
    implementation("org.eclipse.lsp4j:org.eclipse.lsp4j:0.22.0")
    implementation("org.eclipse.lsp4j:org.eclipse.lsp4j.jsonrpc:0.22.0")
    implementation("org.eclipse.lsp4j:org.eclipse.lsp4j.debug:0.22.0")

    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")

    implementation(project(":bc_common"))
}

tasks.test {
    useJUnitPlatform()
}