// Design
// Read each line and group by markers like AT, SCR, etc

object LiveFeed extends App {
  import TextRegex._ // regex compiled in another object
  import scala.io.Source
  import scala.util.matching.Regex

  val txt = "pmr,74542,057,649.txt"

  // Case 3
  /*
  // val input = Source.fromFile(txt, "UTF-8").mkString

  blockRE findAllIn input foreach (_ match {
    case blockRE(c) => println(c); println("\n******************************")
    case _         => println("NO MATCH")
  })  
  *
  */

  /*
  pmrinfoRE findAllIn input foreach (_ match {
    case pmrinfoRE(content) => println(content)
    case _                  => println("NO MATCH")
  })

  1.to(30).map(print _); println("\n\n")

  ctRE findAllIn input foreach (_ match {
    case ctRE(c) => println(c)
    case _       => println("NO MATCH")
  })

  1.to(30).map(print _); println("\n\n")

  mailRE findAllIn input foreach (_ match {
    case mailRE(c) => println(c)
    case _         => println("NO MATCH")
  })
  */

  // End of Case 3

  /* Case 2
  val source = Source.fromFile(txt, "UTF-8")
  for (s <- source.getLines()) {
    s match {
      case pmrRE(x) => { println(s) 
                         
      }
      case _                 => //println(s)
    }
  }

  source.close()
  * 
  */

  // Case 1
  // Word count in PMR 
  /*
  scala.io.Source.fromFile(txt)
    .getLines
    .flatMap(_.split("\\W+"))
    .foldLeft(Map.empty[String, Int]) {
      (count, word) => count + (word -> (count.getOrElse(word, 0) + 1))
    }.foreach(f => println(f._1 + " -> " + f._2)) 
   */

  // Case 2
  // Split by NLSText Page
  /*
   val map = scala.io.Source.fromFile(txt)
    .getLines
    .flatMap(_.split("\\W+"))
    .foldLeft(Map.empty[String, Int]) {
      (count, word) => count + (word -> (count.getOrElse(word, 0) + 1))
    } 

    val input2 = scala.io.Source.fromFile(txt).getLines().flatMap(_.split("""--NLSText Page:\s+\d+"""))
    input2.foreach(println(_))
    * 
    */

  // Case 3
  // Use regex and split by marker (e.g. +ECUREP PMRUPDATE R7 P -5765H3910 -L503/-----P2S2-17/08/15-18:34--AT)
  // This is not easy since the text includes almost all special characters.
  // Where does capturing group start and end?

  // regex
  // 1. (?<=L\d{2}[0-9A-Z])(?s).*?(?=L\d{2}[0-9A-Z])  // works great so far
  // 2. (?<=\+)(?s).*?(?=\+) // more promising. Now 
  // 3. (?<=\+)(?s).*?(?=\+[A-Z]+) // Looking a lot nicer!! 
  // 4. 
  
  // https://regex101.com/r/Yol8Mf/18 (online regex)
  // Adding an artificial marker to the beginning and end
  val input = """   +""" + Source.fromFile(txt, "UTF-8").mkString + """   +ECUREP"""

  val pmrblocks = upRE.findAllMatchIn(input).toList // Works!!!!!!!!! 
  pmrblocks.foreach(println(_))
  
  println("\n\n\nHere's last update from the PMR\n\n\n")
  // val lastblock = pmrblocks.drop(pmrblocks.length-1) 
  println(pmrblocks.drop(pmrblocks.length-1).mkString)
  println("\n\n\nCustomer Information\n\n\n")
  println(pmrblocks.head)
  
  // https://alvinalexander.com/scala/sbt-how-to-compile-run-package-scala-project
  // https://alvinalexander.com/scala/how-to-run-scala-sbt-packaged-jar-file-with-java-command
  
  
}