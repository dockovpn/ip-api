
lazy val root = (project in file("."))
  .settings(
    organization := "com.alekslitvinenk",
    name := "ip-api",
    version := "0.1",
    scalaVersion := "2.12.8",
    
    mainClass in (Compile, run) := Some("com.alekslitvinenk.doppler.Main"),
    
    libraryDependencies ++= Seq(
      "com.typesafe.akka" %% "akka-http" % "10.1.8",
      "com.typesafe.akka" %% "akka-stream" % "2.5.24",
      "com.typesafe.akka" %% "akka-http-spray-json" % "10.1.8",
      "com.typesafe.akka" %% "akka-slf4j" % "2.5.24",
      "ch.qos.logback" % "logback-classic" % "1.2.3",
      "com.alekslitvinenk" %% "logshingles" % "0.1",
      "org.scalatest" %% "scalatest" % "3.0.5" % Test,
      "org.scalamock" %% "scalamock" % "4.1.0" % Test,
    ),
    
    unmanagedResourceDirectories in Compile += { baseDirectory.value / "src/main/resources" }
  )

addCommandAlias(
  "build",
  """|;
     |clean;
     |assembly;
  """.stripMargin)
