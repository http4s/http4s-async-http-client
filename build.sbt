ThisBuild / tlBaseVersion := "0.23"
ThisBuild / tlMimaPreviousVersions ++= (0 to 11).map(y => s"0.23.$y").toSet
ThisBuild / developers := List(
  tlGitHubDev("rossabaker", "Ross A. Baker")
)

val Scala213 = "2.13.11"
ThisBuild / crossScalaVersions := Seq("2.12.18", Scala213, "3.3.0")
ThisBuild / scalaVersion := Scala213

lazy val root = project.in(file(".")).aggregate(asyncHttpClient).enablePlugins(NoPublishPlugin)

val http4sVersion = "0.23.22"
val asyncHttpClientVersion = "2.12.3"
val fs2Version = "3.7.0"
val nettyVersion = "4.1.94.Final"
val reactiveStreamsVersion = "1.0.4"

lazy val asyncHttpClient = project
  .in(file("async-http-client"))
  .settings(
    name := "http4s-async-http-client",
    description := "async http client implementation for http4s clients",
    startYear := Some(2016),
    libraryDependencies ++= Seq(
      "org.http4s" %% "http4s-client" % http4sVersion,
      "org.asynchttpclient" % "async-http-client" % asyncHttpClientVersion,
      "co.fs2" %% "fs2-reactive-streams" % fs2Version,
      "io.netty" % "netty-buffer" % nettyVersion,
      "io.netty" % "netty-codec-http" % nettyVersion,
      "org.reactivestreams" % "reactive-streams" % reactiveStreamsVersion,
      "org.http4s" %% "http4s-client-testkit" % http4sVersion % Test,
    ),
  )
