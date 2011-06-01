package net._01001111.simulant

case class GeoCoordinate(val latitude: Double, val longitude: Double)

object GeoCoordinates extends Randomizer {
    
    private lazy val MinLat =  -90
    private lazy val MaxLat =   90
    private lazy val MinLon = -180
    private lazy val MaxLon =  180
    
    def latitude = random.nextSignedDouble(MaxLat)
    def longitude = random.nextSignedDouble(MaxLon)
    
    private def isBetween(n:Double, min:Int, max:Int) = n >= min && n <= max
    def isValidLatitude(lat:Double) = isBetween(lat, MinLat, MaxLat)
    def isValidLongitude(lon:Double) = isBetween(lon, MinLon, MaxLon)
    
    // def latitude(near:Double) = TODO
    // def longitude(near:Double) = TODO
  
}
