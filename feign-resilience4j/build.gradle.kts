import io.spring.gradle.dependencymanagement.dsl.DependencyManagementExtension

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

configure<DependencyManagementExtension> {
    imports {
        mavenBom("org.springframework.cloud:spring-cloud-dependencies:2023.0.3")
    }
}

dependencies {
    implementation(project(":feign-shared"))
    implementation("org.springframework.boot:spring-boot-starter")
    implementation("org.springframework.cloud:spring-cloud-starter-openfeign")
    implementation("org.springframework.cloud:spring-cloud-circuitbreaker-resilience4j")
}
