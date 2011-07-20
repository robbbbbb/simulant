package net._01001111.simulant

import net._01001111.simulant.test.SimulantMatchers._

import org.specs2.mutable._

class InternetSpec extends Specification {
  
  val s = "test.address.component"
  
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
    
    "standardize a string 1" in {
      Internet.makeInternetAddressComponent("Test Address Component") must be_==(s)
    }
    "standardize a string 2" in {
      Internet.makeInternetAddressComponent("Te'st Addr$ess Comp#onent!") must be_==(s)
    }
    "standardize a string 3" in {
      Internet.makeInternetAddressComponent("Test.Address.Component") must be_==(s)
    }
    "standardize a string 4" in {
      Internet.makeInternetAddressComponent("   Test Address Component   ") must be_==(s)
    }
    "standardize a string 5" in {
      Internet.makeInternetAddressComponent("  ¿  Test Address Component  ?  ") must be_==(s)
    }
    "standardize a string 6" in {
      Internet.makeInternetAddressComponent("Test . Address . Component") must be_==(s)
    }
    "standardize a string 7" in {
      Internet.makeInternetAddressComponent("Test ... Address...Component") must be_==(s)
    }
    
    "return a random email address" in {
      Internet.email must be matching("[\\w]+[.][\\w]+@[\\w]+[.][\\w]+")
    }
  }
}