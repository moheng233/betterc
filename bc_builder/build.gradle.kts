plugins {
    application
    id("org.graalvm.buildtools.native") version "0.10.1"
}

application {
    mainClass = "site.moheng.betterc.builder.Main"
    applicationName = "bcc"
}

graalvmNative {
    binaries.all {
        resources.autodetect()
    }
}

dependencies {
    implementation("org.jetbrains:annotations:24.1.0")
    implementation("info.picocli:picocli:4.7.5")
    annotationProcessor("info.picocli:picocli-codegen:4.7.5")

    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")

    implementation(project(":bc_common"))
}

tasks.compileJava {
    options.compilerArgs.addLast("-Aproject=${project.group}/${project.name}")
}

tasks.test {
    useJUnitPlatform()
}