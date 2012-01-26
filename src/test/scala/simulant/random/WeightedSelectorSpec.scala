package net._01001111.simulant.random

import net._01001111.simulant.test.SimulantMatchers._

import org.specs2.mutable._

class WeightedSelectorSpec extends Specification {
  
  val m = Map(  "a" -> .2, "b" -> .3, "c" -> .4, "d" -> .1 )
  val w = new WeightedSelector(m)
  
  val iterations = 10000
  val tolerance = .05
  
  "A WeightedSelector" should {
    
    "randomly select a single element from a sequence" in {
      val s = w.nextSelection
      m.keys must contain(s)
    }
    
    "distribute selections according to weights" in {
      val sampled = scala.collection.mutable.Map[String,Double]()
      for ((k,v) <- m)
        sampled(k) = 0.0
      
      // multiple random tests
      (1 to iterations).foreach { i => 
        val s = w.nextSelection
        sampled(s) = 1.0/iterations + sampled(s)
      }
      
      for ((k,v) <- m)
        math.abs(sampled(k) - v) must be_<=(tolerance)
      
      sampled.values must not contain(0.0)
    }
    
  }
}