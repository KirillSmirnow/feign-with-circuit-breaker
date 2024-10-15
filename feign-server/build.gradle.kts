plugins {
    java
    id("io.freefair.lombok") version "8.10.2"
    id("org.springframework.boot") version "3.3.4"
}

apply(plugin = "io.spring.dependency-management")

tasks.compileJava {
    sourceCompatibility = "21"
    targetCompatibility = "21"
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-web")
}
