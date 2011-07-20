package net._01001111.simulant

package object words {
  
  def compose(f:() => String, d:String, n:Int):String = {
    require(n >= 0) 
    n match {
      case 0 => ""
      case 1 => f()
      case _ => f() + d + compose(f, d, n - 1)
    }
  }

}