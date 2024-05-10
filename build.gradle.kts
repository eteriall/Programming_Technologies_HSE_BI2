plugins {
    id("java")
}

sourceSets {
  main {
    resources {
      srcDir("src/test/resources")
//        include("src/test/resources")
    }
  }
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

tasks.test {
    useJUnitPlatform()
}