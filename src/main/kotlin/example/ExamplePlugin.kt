package example

import org.gradle.api.Plugin
import org.gradle.api.Project

class ExamplePlugin: Plugin<Project> {
    override fun apply(target: Project) {
        val configuration = target.configurations.getByName("runtimeClasspath")
        target.tasks.register("exampleTask", ExampleTask::class.java) {
            it.nameToJarSize.set(configuration.elements.map {
                it.map { it.asFile.name to setOf("test", "oi") }
                    .toMap()
            })
            it.nameToJarSize.finalizeValueOnRead()
            it.outputFile.set(target.file("build/output.txt"))
        }

    }
}