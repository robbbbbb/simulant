package net._01001111.simulant.test

import net._01001111.simulant.Random

import net._01001111.simulant.test.SimulantMatchers._

import org.specs2.mutable._

class RandomSpec extends Specification {
  
  val r = new Random
  val seq = Seq("a","b","c","d","e")
  
  "A Random" should {
    
    "randomly select a single element from a sequence" in {
      val s = r.select(seq)
      seq must contain(s)
    }
    
    "randomly select a specified elements from a sequence" in {
      val s = r.select(seq, 3)
      s must have size(3)
      s.forall(seq must contain(_))
    }
    
    "randomly select a specified elements from a sequence, even when the specified value is greater than the sequence size" in {
      val s = r.select(seq, 10)
      s must have size(10)
      s.forall(seq must contain(_))
    }
    
    "return Nil when 0 is passed to select" in {
      r.select(seq, 0) must_==(Nil)
    }
    
    "throw an exception when a negative is passed to select" in {
      r.select(seq, -1) must throwA[IllegalArgumentException]
    }
    
    "return a pseudorandom, double value between 0 (inclusive) and a specified value (exclusive)" in {
      r.nextDouble(1) must be_>=(0D) and be_<=(1D)
      r.nextDouble(10) must be_>=(0D) and be_<=(10D)
    }

    
    "return a pseudorandom, double value between -N and N (exclusive)" in {
      r.nextSignedDouble(1) must be_>=(-1D) and be_<=(1D)
      r.nextSignedDouble(10) must be_>=(-10D) and be_<=(10D)
    }
  }
}