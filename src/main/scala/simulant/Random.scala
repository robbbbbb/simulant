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
    require(n >= 0)
    n match {
      case 0 => Nil
      case _ => select(a) :: select(a, n - 1)
    }
  }
  
}