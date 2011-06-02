package net._01001111.simulant

class Random extends scala.util.Random {
  
  /**
   * Randomly select a single element from the sequence
   */
  def select[T](a:Seq[T]):T = a(nextInt(a.length))
  
  /**
   * Randomly select multiple elements as a List from the sequence
   */
  def select[T](a:Seq[T], n:Int = 1):List[T] = {
    require(n >= 0, "n must be greater than or equal to 0")
    n match {
      case 0 => Nil
      case _ => select(a) :: select(a, n - 1)
    }
  }
  
  /**
   * Returns a pseudorandom, double value between 0 (inclusive) and the 
   * specified Int value (exclusive)
   */
  def nextDouble(n:Int):Double = nextDouble() + nextInt(n)
  
  /**
   * Returns a pseudorandom, double value between 0 (inclusive) and the 
   * specified Double value (exclusive)
   */
  def nextDouble(n:Double):Double = {
    require(n > 0, "n must be positive")
    if (n > 1) {
      val i = n.toInt
      nextInt(i) + (if (i == n) 0 else nextDouble(n - i))
    }
    else {
      val d = nextDouble()
      if (d > n) d * n else d
    }
  }
  
  /**
   * Returns a pseudorandom, double value within the specified distance of the 
   * provided double value
   */
  def nextDoubleNear(d:Double, distance:Double):Double = d + nextSignedDouble(distance)
  
  /**
   * Returns a pseudorandom, double value between integers -N and N (exclusive)
   */
  def nextSignedDouble(n:Int):Double = if(nextBoolean) nextDouble(n) else -nextDouble(n)
  
  /**
   * Returns a pseudorandom, double value between doubles -N and N (exclusive)
   */
  def nextSignedDouble(n:Double):Double = if(nextBoolean) nextDouble(n) else -nextDouble(n)
  
}