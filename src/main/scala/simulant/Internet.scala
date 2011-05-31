package net._01001111.simulant

object Internet {
  
  lazy private val random = new Random
  
  // top level domains present in http://scala-tools.org/repo-releases/
  lazy val topLevelDomains = List("cc", "com", "de", "eu", "net", "org", "ru",
    "se", "sk")
  
  lazy val secondLevelDomains = List("example", "test", "invalid")
  
  def topLevelDomain = random.select(topLevelDomains)
  
  def secondLevelDomain = random.select(secondLevelDomains)
  
  def domain = secondLevelDomain + "." + topLevelDomain
  
  def email = List(Name.firstName, ".", Name.lastName, "@", domain).map(_.toLowerCase).mkString
  
  
}
