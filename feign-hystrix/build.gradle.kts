plugins {
    java
    id("io.freefair.lombok") version "8.10.2"
    id("org.springframework.boot") version "2.6.0"
}

apply(plugin = "io.spring.dependency-management")

tasks.compileJava {
    sourceCompatibility = "11"
    targetCompatibility = "11"
}

repositories {
    mavenCentral()
}

dependencies {
    implementation(project(":feign-shared"))
    implementation("org.springframework.boot:spring-boot-starter")

    implementation("org.springframework.cloud:spring-cloud-starter-openfeign:3.1.1")

    implementation("com.netflix.hystrix:hystrix-core:1.5.12")
    implementation("org.springframework.cloud:spring-cloud-starter-netflix-hystrix:2.2.10.RELEASE")
}
