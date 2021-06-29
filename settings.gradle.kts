rootProject.name = "gamist"

requireNotNull(file("src").listFiles()) { "Unable to list files under <src> directory" }
        .asSequence()
        .filter(File::isDirectory)
        .map(File::getName)
        .forEach { dir ->
            val moduleName = dir.replace(".", ":")
            include(":$moduleName")
            project(":$moduleName").apply {
                projectDir = File("src/$dir")
                buildFileName = "build.gradle.kts"
            }
        }
