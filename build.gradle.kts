import java.net.URI

plugins {
  id("java-gradle-plugin")
  id("maven-publish")
  id("org.jetbrains.kotlin.jvm").version("1.9.22")
}

dependencies {
  gradleApi()
  gradleTestKit()
  testImplementation(kotlin("test"))
}

gradlePlugin {
  this.plugins {
    this.create("example") {
      this.id = "example"
      this.implementationClass = "example.ExamplePlugin"
    }
  }
}

group = "example"
version = "0.1"

publishing {
  repositories {
    maven {
      this.name = "localTest"
      this.url = URI("file://" + rootProject.buildDir.resolve("localTest").absolutePath)
    }
  }
}
tasks.withType(Test::class.java) {
  dependsOn("publishAllPublicationsToLocalTestRepository")

  // See https://github.com/gradle/gradle/issues/22765
  jvmArgs(
    "--add-opens",
    "java.base/java.util=ALL-UNNAMED",
    "--add-opens",
    "java.base/java.lang.invoke=ALL-UNNAMED",
  )
}