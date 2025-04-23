plugins {
    id("io.micronaut.application") version "4.5.3"
    id("com.gradleup.shadow") version "8.3.6"
    id("io.micronaut.aot") version "4.5.3"
}

version = "0.1"
group = "com.example"

repositories {
    mavenCentral()
}

dependencies {
    annotationProcessor("org.projectlombok:lombok")
    annotationProcessor("io.micronaut:micronaut-http-validation")
    annotationProcessor("io.micronaut.serde:micronaut-serde-processor")

    compileOnly("io.micronaut:micronaut-http-client")
    compileOnly("org.projectlombok:lombok")

    implementation("io.micronaut.serde:micronaut-serde-jackson")
    implementation("io.micronaut:micronaut-inject:4.8.11")
    implementation("io.micronaut:micronaut-runtime:4.8.11")
    implementation("io.micronaut.data:micronaut-data-model:4.12.0")
    implementation("io.micronaut.data:micronaut-data-tx-hibernate:4.12.0")
    implementation("io.micronaut.flyway:micronaut-flyway")
    implementation("org.mapstruct:mapstruct:1.6.3")
    runtimeOnly("ch.qos.logback:logback-classic")
    runtimeOnly("io.micronaut.data:micronaut-data-jdbc:4.12.0")

    testImplementation("io.micronaut:micronaut-http-client")
    testImplementation("org.testcontainers:postgresql:1.20.6")
}


application {
    mainClass = "com.example.Application"
}
java {
    sourceCompatibility = JavaVersion.toVersion("21")
    targetCompatibility = JavaVersion.toVersion("21")
}


graalvmNative.toolchainDetection = false

micronaut {
    runtime("netty")
    testRuntime("junit5")
    processing {
        incremental(true)
        annotations("com.example.*")
    }
    aot {
        // Please review carefully the optimizations enabled below
        // Check https://micronaut-projects.github.io/micronaut-aot/latest/guide/ for more details
        optimizeServiceLoading = false
        convertYamlToJava = false
        precomputeOperations = true
        cacheEnvironment = true
        optimizeClassLoading = true
        deduceEnvironment = true
        optimizeNetty = true
        replaceLogbackXml = true
    }
}


tasks.named<io.micronaut.gradle.docker.NativeImageDockerfile>("dockerfileNative") {
    jdkVersion = "21"
}


