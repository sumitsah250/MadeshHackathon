import java.net.URI

pluginManagement {
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
        gradlePluginPortal()
        maven { url=uri("https://jitpack.io") }
        maven {
            url = uri("https://my.nutrient.io/maven")
        }

        maven {
            url =  uri("https://github.com/jitsi/jitsi-maven-repository/raw/master/releases")
        }

        
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        maven { url=uri("https://jitpack.io") }

        maven {
            url = uri("https://my.nutrient.io/maven")
        }

        maven {
            url =  uri("https://github.com/jitsi/jitsi-maven-repository/raw/master/releases")
        }


    }
}

rootProject.name = "EduTech"
include(":app")
 