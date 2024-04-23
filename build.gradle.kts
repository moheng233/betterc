plugins {
    id("idea")
    id("de.l11n.gvgp.gradle-git-versioning") version "1.0.18"
}

allprojects {
    apply {
        plugin("java")
    }

    group = "site.moheng.betterc"

    repositories {
        mavenCentral()
    }

    tasks.withType<JavaCompile>().configureEach {
        options.release = 21;
    }
}