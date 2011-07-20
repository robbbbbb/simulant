package net._01001111.simulant

import net._01001111.simulant.random.Randomizer

object Internet extends Randomizer {
  
  // top level domains present in http://scala-tools.org/repo-releases/
  lazy val topLevelDomains = List("cc", "com", "de", "eu", "net", "org", "ru", "se", "sk")
  lazy val secondLevelDomains = List("example", "test", "invalid")
  
  def topLevelDomain = random.select(topLevelDomains)
  
  def secondLevelDomain = random.select(secondLevelDomains)
  
  def domain = secondLevelDomain + "." + topLevelDomain
  
  def makeInternetAddressComponent(s:String) = 
    s.trim().replaceAll("[^\\w\\s.]","").trim().replaceAll("[.\\s]+",".").toLowerCase
  
  def email = emailForName(Name.fullName)
  
  def emailForName(name:String) = makeInternetAddressComponent(name) + "@" + domain
  
}
