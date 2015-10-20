lazy val root = (project in file(".")).
  settings(
    name := "dealertrackCoding",
    libraryDependencies ++= Seq(
      "org.scalatest" %% "scalatest" % "2.2.4" % "test",
      "junit" % "junit" % "4.12"
    )
  )
