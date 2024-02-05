To reproduce:

* git clone https://github.com/martinbonnin/test-gradle-8-6
* cd test-gradle-8-6
* ./gradlew test --configuration-cache -i

Output:

```
> Task :test FAILED

MainTest > testPlugin FAILED
    org.gradle.testkit.runner.UnexpectedBuildFailure: Unexpected build execution failure in /Users/mbonnin/git/test-gradle-8-6/./build/testProject with arguments [exampleTask, --configuration-cache]

    Output:
    Calculating task graph as no cached configuration is available for tasks: exampleTask

    FAILURE: Build failed with an exception.

    * What went wrong:
    Could not load the value of field `specs` of `org.gradle.api.specs.AndSpec` bean found in task `:exampleTask` of type `example.ExampleTask`.
    > example.ExampleTask$$Lambda$1306/0x0000000300b226b0

    * Try:
    > Run with --stacktrace option to get the stack trace.
    > Run with --info or --debug option to get more log output.
    > Run with --scan to get full insights.
    > Get more help at https://help.gradle.org.

    BUILD FAILED in 2s
    Configuration cache entry stored.
        at app//org.gradle.testkit.runner.internal.DefaultGradleRunner.lambda$build$2(DefaultGradleRunner.java:269)
        at app//org.gradle.testkit.runner.internal.DefaultGradleRunner.run(DefaultGradleRunner.java:362)
        at app//org.gradle.testkit.runner.internal.DefaultGradleRunner.build(DefaultGradleRunner.java:267)
        at app//MainTest.testPlugin(MainTest.kt:18)
```

Reverting to Gradle `8.5` removes the error