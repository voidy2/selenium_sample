import sbt._
import sbt.Process._
import Keys._
import grizzled.sys._
import OperatingSystem._

object MyBuild extends Build
{
  lazy val root = Project("root", file(".")) settings(
    commands += selenium_test
  )

  def selenium_test = Command.args("selenium-test", "<args>") { (state, args) =>
    "%s %s -f %s".format(cmd("bin/ant"), args.headOption.getOrElse("htmlUnit"), "bin/build.xml")!

    state
  }

  def cmd(cmd_string: String) = cmd_string + (if (os == Windows) ".bat" else "")

}
