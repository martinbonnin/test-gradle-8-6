import org.gradle.testkit.runner.GradleRunner
import java.io.File
import kotlin.test.Test

class MainTest {
  @Test
  fun testPlugin() {
    val dir = File(".").resolve("build/testProject")
    dir.deleteRecursively()
    File("src/testProject").copyRecursively(dir)

    GradleRunner.create()
      .withDebug(true)
      .withProjectDir(dir)
      .forwardStdError(System.err.writer())
      .forwardStdOutput(System.out.writer())
      .withArguments("exampleTask", "--configuration-cache")
      .build()
  }
}