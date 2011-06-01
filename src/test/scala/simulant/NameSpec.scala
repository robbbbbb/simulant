package net._01001111.simulant.test

import net._01001111.simulant.Name

import net._01001111.simulant.test.SimulantMatchers._

import org.specs2.mutable._

class NameSpec extends Specification {
  
  "Name" should {
    
    "return a random male first name" in {
      val n = Name.firstName(Name.Male)
      n must not be empty
      Name.maleFirstNames must contain(n)
    }
    
    "return a random female first name" in {
      val n = Name.firstName(Name.Female)
      n must not be empty
      Name.femaleFirstNames must contain(n)
    }
    
    "return a random first name" in {
      val n = Name.firstName
      n must not be empty
      (Name.maleFirstNames ++ Name.femaleFirstNames) must contain(n)
    }
    
    "return a random last name" in {
      val n = Name.lastName
      n must not be empty
      Name.lastNames must contain(n)
    }
  
    "return a random full name" in {
      val n = Name.fullName
      n must not be empty
      n must haveWordCount(2)
    }
  }
}