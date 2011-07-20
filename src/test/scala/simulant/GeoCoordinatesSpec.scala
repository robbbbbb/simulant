package net._01001111.simulant

import net._01001111.simulant.test.SimulantMatchers._

import org.specs2.mutable._

class GeoCoordinatesSpec extends Specification {
  
  val lat = -0.7896173377761679
  val lon = -91.09451293945312
  val latlon = LatLon(lat,lon)
  val delta = 0.5
  
  "GeoCoordinates" should {
    import net._01001111.simulant.GeoCoordinates._
    
    "validate a latitude" in {
      isValidLatitude(0) must beTrue
      isValidLatitude(90) must beTrue
      isValidLatitude(-90) must beTrue
      isValidLatitude(45.54321) must beTrue
      
      isValidLatitude(100) must beFalse
      isValidLatitude(-100) must beFalse
    }
    
    "validate a longitude" in {
      isValidLongitude(0) must beTrue
      isValidLongitude(180) must beTrue
      isValidLongitude(-180) must beTrue
      isValidLongitude(45.54321) must beTrue
      
      isValidLongitude(200) must beFalse
      isValidLongitude(-200) must beFalse
    }
    
    "generate a valid latitude" in {
      isValidLatitude(latitude) must beTrue
    }
    
    "generate a valid longitude" in {
      isValidLongitude(longitude) must beTrue
    }
    
    "generate a valid location" in {
      isValidLocation(location) must beTrue
    }
    
    "generate a valid latitude near a specified latitude" in {
      // edge cases
      (1 to 100).foreach { i => 
        isValidLatitude(latitudeNear(MinLat, delta)) must beTrue
        isValidLatitude(latitudeNear(MaxLat, delta)) must beTrue
      }
      // known case
      val l = latitudeNear(lat, delta)
      l must be_>=(lat - delta) and be_<=(lat + delta)
      isValidLatitude(l) must beTrue
    }
    
    "generate a valid longitude near a specified longitude" in {
      // edge cases
      (1 to 100).foreach { i => 
        isValidLongitude(longitudeNear(MinLon, delta)) must beTrue
        isValidLongitude(longitudeNear(MaxLon, delta)) must beTrue
      }
      // known case
      val l = longitudeNear(lon, delta)
      l must be_>=(lon - delta) and be_<=(lon + delta)
      isValidLongitude(l) must beTrue
    }
    
    "generate a valid location near a specified location with a single delta value" in {
      val l = locationNear(latlon, delta)
      l.latitude must be_>=(lat - delta) and be_<=(lat + delta)
      l.longitude must be_>=(lon - delta) and be_<=(lon + delta)
      isValidLocation(l) must beTrue
    }
    
    "generate a valid location near a specified location with a tuple2 delta value" in {
      val d1 = .42
      val d2 = .24
      val l = locationNear(latlon, (d1,d2))
      l.latitude must be_>=(lat - d1) and be_<=(lat + d1)
      l.longitude must be_>=(lon - d2) and be_<=(lon + d2)
      isValidLocation(l) must beTrue
    }
    
    "generate a valid location near a specified location with default delta values" in {
      isValidLocation(locationNear(latlon)) must beTrue
    }
  }
}