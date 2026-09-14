name := "shapes-oo-scala"

version := "0.4"

libraryDependencies ++= Seq(
  "org.creativescala" %% "doodle"         % "0.34.0",
  "ch.qos.logback" % "logback-classic" % "1.4.11",
  "org.slf4j" % "slf4j-api" % "2.0.9",
  "org.scalatest"     %% "scalatest"      % "3.2.20"  % Test,
  "org.scalacheck"    %% "scalacheck"     % "1.20.0"  % Test
)
