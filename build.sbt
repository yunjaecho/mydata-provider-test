name := "mydata-provider-test"

version := "0.1"

scalaVersion := "2.13.8"

resolvers += "jitpack".at("https://jitpack.io")

libraryDependencies ++= Seq(
  "io.circe" %% "circe-json-schema" % "0.2.0",

//  "io.circe" %% "circe-generic" % "0.14.1",
  "io.circe" %% "circe-parser" % "0.14.1",
  "io.circe" %% "circe-literal" % "0.14.1"
)