package example

import org.gradle.api.DefaultTask
import org.gradle.api.file.RegularFileProperty
import org.gradle.api.provider.MapProperty
import org.gradle.api.tasks.CacheableTask
import org.gradle.api.tasks.Input
import org.gradle.api.tasks.OutputFile
import org.gradle.api.tasks.TaskAction

@CacheableTask
abstract class ExampleTask: DefaultTask() {
    @get:Input
    abstract val nameToJarSize: MapProperty<String, Set<String>>

    @get:OutputFile
    abstract val outputFile: RegularFileProperty

    init {
        outputs.upToDateWhen {
            false
        }
    }
    @TaskAction
    fun taskAction() {
        outputFile.get().asFile.writeText(nameToJarSize.get().values.joinToString(","))
    }
}
