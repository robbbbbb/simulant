package net._01001111.simulant.test

import net._01001111.simulant.GeoCoordinates

import net._01001111.simulant.test.SimulantMatchers._

import org.specs2.mutable._

class GeoCoordinatesSpec extends Specification {
  
  "GeoCoordinates" should {
    
    "validate a latitude" in {
      GeoCoordinates.isValidLatitude(0) must beTrue
      GeoCoordinates.isValidLatitude(90) must beTrue
      GeoCoordinates.isValidLatitude(-90) must beTrue
      GeoCoordinates.isValidLatitude(45.54321) must beTrue
      
      GeoCoordinates.isValidLatitude(100) must beFalse
      GeoCoordinates.isValidLatitude(-100) must beFalse
    }
    
    "validate a longitude" in {
      GeoCoordinates.isValidLongitude(0) must beTrue
      GeoCoordinates.isValidLongitude(180) must beTrue
      GeoCoordinates.isValidLongitude(-180) must beTrue
      GeoCoordinates.isValidLongitude(45.54321) must beTrue
      
      GeoCoordinates.isValidLongitude(200) must beFalse
      GeoCoordinates.isValidLongitude(-200) must beFalse
    }
    
    "generate a valid latitude" in {
      val l = GeoCoordinates.latitude
      GeoCoordinates.isValidLatitude(l) must beTrue
    }
    
    "generate a valid longitude" in {
      val l = GeoCoordinates.longitude
      GeoCoordinates.isValidLongitude(l) must beTrue
    }
  }
}