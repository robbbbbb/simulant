package net._01001111.simulant.people

import net._01001111.simulant.test.SimulantMatchers._

import org.specs2.mutable._

class NameSpec extends Specification {
  
  "Name" should {
    
    "return a random male first name" in {
      val n = Name.firstName(Male)
      n must not be empty
      Name.firstNames(Male) must contain(n)
    }
    
    "return a random female first name" in {
      val n = Name.firstName(Female)
      n must not be empty
      Name.firstNames(Female) must contain(n)
    }
    
    "return a random first name" in {
      val n = Name.firstName
      n must not be empty
      Name.allFirstNames must contain(n)
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