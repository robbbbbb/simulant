package net._01001111.simulant.test

import net._01001111.simulant.Internet

import net._01001111.simulant.test.SimulantMatchers._

import org.specs2.mutable._

class InternetSpec extends Specification {
  
  "Internet" should {
    
    "return a random top-level domain" in {
      Internet.topLevelDomains must contain(Internet.topLevelDomain)
    }
    
    "return a random second-level domain" in {
      Internet.secondLevelDomains must contain(Internet.secondLevelDomain)
    }
    
    "return a random domain name" in {
      Internet.domain must be matching("[\\w]+[.][\\w]+")
    }
    
    "return a random email address" in {
      Internet.email must be matching("[\\w]+[.][\\w]+@[\\w]+[.][\\w]+")
    }
  }
}