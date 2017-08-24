
// http://blog.xebia.com/matching-strings-in-scala/
// https://kerflyn.wordpress.com/2011/02/14/playing-with-scalas-pattern-matching/
// A good explanation of lookahead and lookbehind
// http://www.rexegg.com/regex-lookarounds.html
object TextRegex {
  // regex
  val pmrRE = """(^PMR.*Age.*$)""".r  // PMR number
    val pmrinfoRE = """((?s)Number of PMRs found.*NLS TEXT)""".r
    val ctRE  = """(.*-CT|.*-SCT|.*-SCR)""".r
    val mailRE = """(\/ecurep\/pmr.*mail.*|Mail From:.*|Send to:.*|ECuRep Mail Gateway - mail from support.*)""".r
    val srRE = """((?s)Electronic submission by customer via SR tool.*FOR SR USE ONLY)""".r
    val ctRE2 = """(?=[^\+]\+)(.+L\d{2}[0-9A-Z].*(?<=CT))""".r
    
    // block begins with 
    // (.*L[0-9]{3}\/.*-P[0-9]S[0-9].*)
    // (.*(?=L\d{3}\/\w+\s+-P\dS\d).*[<>=*,.:;"'@\(\)\/\-\w\s]*)
    val markerRE = """(.*(?=L\d{3}\/).*)""".r
    
    //val blockRE = """(.*(?=L\d{2}[0-9A-Z]\/).*\s+)""".r
    val blockRE = """(.*(?=L\d{2}[0-9A-Z]\/)[\/\-:>=<.,();#*?"'@\w\s]+(?=))""".r
    
    // https://social.msdn.microsoft.com/Forums/en-US/521fecd0-5cab-428c-a490-7ddb9efbc73c/regular-expression-read-a-multi-line-paragraph?forum=regexp
    val upRE = """(?<=\+)(?s).*?(?=\+[A-Z]+)""".r
    
    // \x20-\x7E
    // (.*(?=L\d{3}\/)[\-_:>=<.@,"#\(\)\/\*\[\]\w\s]*(?!.*L\d{3}))
    // (?=[^\+]\+)(.+L\d{2}[0-9A-Z].*(?=[^\+]*\+))
    
    // https://regex101.com/r/Yol8Mf/9
    
    // Extract timestamp marker
    // \+\w+.*L\d{3}\/-*\w*\s*-*P\dS\d\-\d{2}\/\d{2}\/\d{2}\-\d{2}:\d{2}-{2}\w+  // Works
    
    // 8.19.2017
    // (.*(?=[0-9A-Z]{3}\/)[\/\-:>=<.,();#*?"'@\]\[\w\s]+)
    
    // Character subtraction
    // (?![aeiou])[a-z]
}