plugins {
    id("java")
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
    testImplementation("org.seleniumhq.selenium:selenium-java:4.33.0")
    implementation("com.squareup.okhttp3:okhttp:5.1.0")
    testImplementation("com.squareup.okhttp3:okhttp-urlconnection:5.1.0")
    testImplementation("org.eclipse.angus:angus-mail:2.0.4")
}

tasks.test {
    useJUnitPlatform()
}