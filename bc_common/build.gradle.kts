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

val junitVersion: String by project
val jetbrainsAnnotationsVersion: String by project

dependencies {
    implementation("org.jetbrains:annotations:$jetbrainsAnnotationsVersion")
    implementation("org.ainslec:picocog:1.0.7")
    implementation("org.apache.commons:commons-lang3:3.14.0")
    implementation("org.apache.commons:commons-collections4:4.5.0-M1")

    implementation("com.googlecode.cqengine:cqengine:3.6.0") {
        version {
            implementation("org.xerial:sqlite-jdbc:3.41.2.1")
        }
    }

    testImplementation(platform("org.junit:junit-bom:$junitVersion"))
    testImplementation("org.junit.jupiter:junit-jupiter")

    antlr("org.antlr:antlr4:4.13.1")
}

tasks.test {
    useJUnitPlatform()
    jvmArgs = listOf("--enable-preview")
}

tasks.withType<JavaCompile>().all() {
    options.compilerArgs.add("--enable-preview")
}

tasks.generateGrammarSource {
    arguments.addAll(listOf("-visitor"))
}