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

dependencies {
    intellijPlatform {
        intellijIdeaCommunity("2024.1")
        instrumentationTools()
    }

    implementation("org.jetbrains:annotations:24.1.0")
    implementation("org.eclipse.lsp4j:org.eclipse.lsp4j:0.22.0")
    implementation("com.github.ballerina-platform:lsp4intellij:0.96.0") {
        exclude("org.eclipse.lsp4j", "org.eclipse.lsp4j")
    }
    implementation(project(":bc_common"))
    implementation(project(":bc_language_server"))
}
