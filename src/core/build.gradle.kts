plugins {
    kotlin("jvm")
}

dependencies {
    testImplementation("org.mockito:mockito-core:3.10.+")
    testImplementation("org.mockito:mockito-junit-jupiter:3.10.+")
    testImplementation("org.junit.jupiter:junit-jupiter:5.7.+")
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.7.+")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.7.+")
}