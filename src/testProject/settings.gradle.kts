pluginManagement {
    listOf(repositories, dependencyResolutionManagement.repositories).forEach {
        it.apply {
            mavenCentral()
            google()
            maven(url = uri(rootDir.resolve("../../build/localTest").absolutePath))
        }
    }
}