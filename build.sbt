name := "prosemirror-xml-schemagen"
organization := "com.evolvedbinary.prosemirror"
version := "0.1"

startYear := Some(2017)
organizationName := "Adam Retter"
licenses += ("AGPL-3.0" -> new URL("https://opensource.org/licenses/agpl-3.0"))
homepage := Some(url("https://github.com/adamretter/prosemirror-xml-schemagen"))

scalaVersion := "2.12.4"

mainClass in Compile := Some("com.evolvedbinary.prosemirror.xmlschemagen.CmdLine")

libraryDependencies ++= {

  val fs2V = "0.10.0-M8"
  val catsV = "0.5"
  val jacksonV = "2.9.2"

  Seq(
    "org.typelevel" %% "cats-effect" % catsV,
    "co.fs2" %% "fs2-io" % fs2V,
    "co.fs2" %% "fs2-core" % fs2V,

    "com.github.scopt" %% "scopt" % "3.7.0",

    "xerces" % "xercesImpl" % "2.11.0",
    "com.fasterxml.jackson.core" % "jackson-core" % jacksonV
  )
}
        