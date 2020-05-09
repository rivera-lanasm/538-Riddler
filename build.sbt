
libraryDependencies += "cc.redberry" %% "rings.scaladsl" % "2.5.7"

libraryDependencies  ++= Seq(
  // Last stable release
  "org.scalanlp" %% "breeze" % "1.0",
  
  // Native libraries are not included by default. add this if you want them
  // Native libraries greatly improve performance, but increase jar sizes. 
  // It also packages various blas implementations, which have licenses that may or may not
  // be compatible with the Apache License. No GPL code, as best I know.
  "org.scalanlp" %% "breeze-natives" % "1.0",
  
  // The visualization library is distributed separately as well.
  // It depends on LGPL code
  "org.scalanlp" %% "breeze-viz" % "1.0"
)

