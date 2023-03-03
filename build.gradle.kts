plugins {
    kotlin("jvm") version "1.8.10"
    id("com.github.johnrengelman.shadow") version "8.1.0"
}

group = "me.obsilabor"
version = "1.0.0"

repositories {
    mavenCentral()
}

dependencies {
    implementation("com.dorkbox:SystemTray:4.1")
}

tasks {
    compileJava {
        options.release.set(11)
        options.encoding = "UTF-8"
    }
    compileKotlin {
        kotlinOptions.jvmTarget = "11"
    }
    shadowJar {
        manifest {
            attributes(
                "Main-Class" to "me.obsilabor.snippingtoolfix.SnippingToolFixKt"
            )
        }
    }
}