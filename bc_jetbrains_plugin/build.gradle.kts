plugins {
    java
    id("org.jetbrains.intellij.platform") version "2.0.0-beta1"
}

repositories {
    maven(url = "https://jitpack.io")
    intellijPlatform {
        defaultRepositories()
    }
}

intellijPlatform {
    buildSearchableOptions = true
    projectName = "betterc-intellij-plugin"

    autoReload = true


}

val jetbrainsAnnotationsVersion: String by project
val lsp4jVersion: String by project

dependencies {
    intellijPlatform {
        intellijIdeaCommunity("2024.1")
        instrumentationTools()
    }

    implementation("org.jetbrains:annotations:$jetbrainsAnnotationsVersion")
    implementation("org.eclipse.lsp4j:org.eclipse.lsp4j:$lsp4jVersion")
    implementation("com.github.ballerina-platform:lsp4intellij:0.96.0") {
        exclude("org.eclipse.lsp4j", "org.eclipse.lsp4j")
    }
    implementation(project(":bc_common"))
    implementation(project(":bc_language_server"))
}
