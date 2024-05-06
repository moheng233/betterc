plugins {
    application
    `java-library`
}

application {
    mainClass = "site.moheng.betterc.lsp.Main"
}

val junitVersion: String by project
val jetbrainsAnnotationsVersion: String by project
val lsp4jVersion: String by project

dependencies {
    implementation("org.jetbrains:annotations:$jetbrainsAnnotationsVersion")
    implementation("org.eclipse.lsp4j:org.eclipse.lsp4j:$lsp4jVersion")
    implementation("org.eclipse.lsp4j:org.eclipse.lsp4j.jsonrpc:$lsp4jVersion")
    implementation("org.eclipse.lsp4j:org.eclipse.lsp4j.debug:$lsp4jVersion")

    testImplementation(platform("org.junit:junit-bom:$junitVersion"))
    testImplementation("org.junit.jupiter:junit-jupiter")

    implementation(project(":bc_common"))
}

tasks.test {
    useJUnitPlatform()
}