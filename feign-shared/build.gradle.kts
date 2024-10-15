plugins {
    java
    id("io.freefair.lombok") version "8.10.2"
}

tasks.compileJava {
    sourceCompatibility = "11"
    targetCompatibility = "11"
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework:spring-context:5.3.39")
    implementation("ch.qos.logback:logback-classic:1.5.10")
}
