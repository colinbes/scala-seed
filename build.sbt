organization := "com.besterdesigns"
version := "0.1-SNAPSHOT"
scalaVersion := "2.12.11"

resolvers += Resolver.mavenLocal
resolvers ++= Seq(
  "Artificatory" at "https://abtart.biocharger.com/artifactory/abt-repo",
  "Maven Repo" at "https://repo1.maven.org/maven2",
  "repo2_maven_org" at "https://repo2.maven.org/maven2",
  "Scala-Tools Dependencies Repository for Releases" at "https://scala-tools.org/repo-releases",
)

scalacOptions := "-deprecation" :: "-unchecked" :: "-feature" :: "-language:postfixOps" :: "-language:implicitConversions" :: Nil
publishTo := Some("Artifactory Realm" at "https://abtart.biocharger.com/sbt-release-local")
credentials += Credentials(Path.userHome / ".sbt" / ".credentials")

lazy val dependencies =
  new {
    val specs2Version = "4.10.3"
    val slf4jApi = "org.slf4j" % "slf4j-api" % "1.7.30"
    val logback = "ch.qos.logback" % "logback-classic" % "1.2.3"
    val specs2Core = "org.specs2" %% "specs2-core" % specs2Version % Test
    val specs2jUnit = "org.specs2" %% "specs2-junit" % specs2Version % Test
  }

dependencyOverrides += "org.slf4j" % "slf4j-api" % "1.7.25"

lazy val commonDependencies = Seq(
  dependencies.slf4jApi,
  dependencies.logback,
  dependencies.specs2Core
)

lazy val root = (project in file("."))
  .settings(
    name := "scala-seed",
    libraryDependencies ++= commonDependencies ++ Seq(
    )
  )