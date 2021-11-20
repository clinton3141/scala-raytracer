name := "scala-raytracer"

organization := "uk.co.slightlymore"

version := "0.0.1"

scalaVersion := "2.12.13"

libraryDependencies ++= Seq (
        "io.cucumber" % "cucumber-core" % "6.10.3" % Test,
        "io.cucumber" %% "cucumber-scala" % "6.10.3" % Test,
        "io.cucumber" % "cucumber-jvm" % "6.10.3" % Test,
        "io.cucumber" % "cucumber-junit" % "6.10.3" % Test,
        "org.scalatest" %% "scalatest" % "3.2.8" % Test)

enablePlugins(CucumberPlugin)

CucumberPlugin.monochrome := false
CucumberPlugin.glues := List("uk.co.slightlymore.sbt")
