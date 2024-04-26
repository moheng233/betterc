plugins {
    `java-platform`
    id("idea")
    id("de.l11n.gvgp.gradle-git-versioning") version "1.0.18"
}


subprojects {
    apply {
        plugin("java")
//        plugin("checkstyle")
        plugin("de.l11n.gvgp.gradle-git-versioning")
    }

    gitVersioning {
        createGetVersionTask = true
    }

    group = "site.moheng.betterc"

    repositories {
        mavenCentral()
    }

    tasks.withType<JavaCompile>().configureEach {
        options.release = 21
    }
}