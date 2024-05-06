pluginManagement {
    plugins {
        kotlin("jvm") version "1.9.23"
    }

    val lombokVersion: String by settings
    val jetVersion: String by settings


    resolutionStrategy {
        eachPlugin {
            when (requested.id.id) {
                "io.freefair.lombok" -> useVersion(lombokVersion)
                "gg.jte.gradle" -> useVersion(jetVersion)
            }
        }
    }
}

plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "0.8.0"
}

rootProject.name = "betterc"

include(":bc_common", ":bc_builder", ":bc_language_server", ":bc_jetbrains_plugin")