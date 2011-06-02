package net._01001111.simulant

case class LatLon(val latitude: Double, val longitude: Double)

object GeoCoordinates extends Randomizer {
    
    lazy val MinLat =  -90
    lazy val MaxLat =   90
    lazy val MinLon = -180
    lazy val MaxLon =  180
    
    def latitude = random.nextSignedDouble(MaxLat)
    def longitude = random.nextSignedDouble(MaxLon)
    def location = LatLon(latitude, longitude)
    
    private def isBetween(n:Double, min:Int, max:Int) = n >= min && n <= max
    def isValidLatitude(lat:Double) = isBetween(lat, MinLat, MaxLat)
    def isValidLongitude(lon:Double) = isBetween(lon, MinLon, MaxLon)
    def isValidLocation(l:LatLon) = isValidLatitude(l.latitude) && isValidLongitude(l.longitude)
    
    private def coordinateNear(d:Double,delta:Double,min:Int,max:Int) = {
      val c = random.nextDoubleNear(d,delta)
      if (c > max) (c - max + min) else if (c < min) (c + max - min) else c
    }
    def latitudeNear(d:Double, within:Double = 0.03) = coordinateNear(d,within,MinLat,MaxLat)
    def longitudeNear(d:Double, within:Double = 0.02) = coordinateNear(d,within,MinLon,MaxLon)
    
    def locationNear(l:LatLon,within:Tuple2[Double,Double]):LatLon = 
      LatLon(latitudeNear(l.latitude,within._1), longitudeNear(l.longitude,within._2))
    def locationNear(l:LatLon,within:Double):LatLon = locationNear(l,(within,within))
    def locationNear(l:LatLon):LatLon = LatLon(latitudeNear(l.latitude), longitudeNear(l.longitude))
      
}
