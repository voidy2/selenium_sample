name := "Selenium Introduction"

version := "1.0"

resolvers ++= Seq(
  "Sonatype Nexus Snapshots" at "https://oss.sonatype.org/content/repositories/snapshots",
  "Sonatype Nexus Releases" at "https://oss.sonatype.org/content/repositories/releases",
  "FuseSource Snapshot Repository" at "http://repo.fusesource.com/nexus/content/repositories/snapshots",
  "Morphia Repo at Google Code" at "http://morphia.googlecode.com/svn/mavenrepo"
)

libraryDependencies ++= Seq(
  "junit" % "junit" % "4.8" % "test",
  "com.novocode" % "junit-interface" % "0.7" % "test->default"
)

scalacOptions += "-deprecation"

scalaVersion := "2.9.0"

crossPaths := false

fork := true

javaOptions += "-DFile.encoding=utf8 -Xmx1G"

ivyLoggingLevel := UpdateLogging.Full

logLevel := Level.Info

// Java then Scala for main sources
compileOrder in Compile := CompileOrder.JavaThenScala

// allow circular dependencies for test sources
compileOrder in Test := CompileOrder.Mixed

testFrameworks := Seq(TestFrameworks.JUnit)
