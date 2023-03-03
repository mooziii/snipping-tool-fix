plugins {
    kotlin("jvm") version "1.8.10"
    id("com.github.johnrengelman.shadow") version "8.1.0"
}

group = "me.obsilabor"
version = "1.0.1"

repositories {
    mavenCentral()
}

dependencies {
    implementation("com.dorkbox:SystemTray:4.1")
}

tasks {
    compileJava {
        options.release.set(17)
        options.encoding = "UTF-8"
    }
    compileKotlin {
        kotlinOptions.jvmTarget = "17"
    }
    shadowJar {
        manifest {
            attributes(
                "Main-Class" to "me.obsilabor.snippingtoolfix.SnippingToolFixKt"
            )
        }
    }
}