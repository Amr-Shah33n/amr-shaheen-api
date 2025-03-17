plugins {
    id("java")
}

group = "org.moneyapp"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    implementation(platform("io.qameta.allure:allure-bom:2.25.0"))
    testImplementation("io.qameta.allure:allure-junit5")
    implementation("io.qameta.allure:allure-rest-assured")
    implementation("io.rest-assured:rest-assured:5.5.0")
    implementation("com.fasterxml.jackson.core:jackson-databind:2.18.2")
}

tasks.test {
    useJUnitPlatform()
}