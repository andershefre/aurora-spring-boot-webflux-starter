plugins {
    `java-library`
    id("no.skatteetaten.gradle.aurora") version "4.4.15"
}

aurora {
    useLibDefaults
    useJavaDefaults
    useSpringBoot {
        useWebFlux
    }

    features {
        auroraStarters = false
    }
}

repositories {
    mavenLocal()
    maven {
        url = uri("https://repo.spring.io/milestone")
    }
}

dependencies {
    api(platform("org.springframework.cloud:spring-cloud-dependencies:2021.0.1"))
    api(platform("org.springframework.cloud:spring-cloud-sleuth-otel-dependencies:1.1.0-M5"))
    api(platform("io.opentelemetry:opentelemetry-bom:1.11.0"))

    api("org.springframework.cloud:spring-cloud-starter-sleuth") {
        exclude("org.springframework.cloud", "spring-cloud-sleuth-brave")
    }
    api("org.springframework.cloud:spring-cloud-sleuth-otel-autoconfigure")
    api("io.opentelemetry:opentelemetry-exporter-otlp-http-trace")

    api("org.springframework.boot:spring-boot-starter-webflux")
    api("no.skatteetaten.aurora.springboot:aurora-spring-boot-base-starter:1.3.7") {
        exclude("org.springframework.cloud", "spring-cloud-sleuth-brave")
    }
    api("org.springframework.boot:spring-boot-configuration-processor")

    testImplementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8:1.6.20")
    testImplementation("org.junit.jupiter:junit-jupiter")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testImplementation("com.willowtreeapps.assertk:assertk-jvm:0.25")
    testImplementation("com.squareup.okhttp3:mockwebserver:4.9.3")
    testImplementation("org.testcontainers:testcontainers:1.16.3")
    testImplementation("org.testcontainers:junit-jupiter:1.16.3")
    testImplementation("org.awaitility:awaitility-kotlin:4.2.0")
}
