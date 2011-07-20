package net._01001111.simulant.random

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
    
    "return a pseudorandom, double value between 0 (inclusive) and a specified Int value (exclusive)" in {
      // multiple tests
      (1 to 100).foreach { i => r.nextDouble(i) must be_>=(0D) and be_<=(i.toDouble) }
      // illegal argument
      r.nextDouble(0) must throwA[IllegalArgumentException]
    }
    
    "return a pseudorandom, double value between 0 (inclusive) and a specified double value (exclusive)" in {
      // concrete tests
      List(1D, 1.5, 2D, 0.1, 0.0001, 10.01).foreach { d => 
        r.nextDouble(d) must be_>=(0D) and be_<=(d)
      }
      // multiple random tests
      (1 to 100).foreach { i => 
        val d1 = r.nextDouble()
        val d2 = r.nextInt(i) + r.nextDouble()
        r.nextDouble(d1) must be_>=(0D) and be_<=(d1)
        r.nextDouble(d2) must be_>=(0D) and be_<=(d2)
      }
      // illegal argument
      r.nextDouble(0D) must throwA[IllegalArgumentException]
    }
    
    "return a pseudorandom, double value between integers -N and N (exclusive)" in {
      // multiple tests
      (1 to 100).foreach { i => r.nextSignedDouble(i) must be_>=(-i.toDouble) and be_<=(i.toDouble) }
      // illegal argument
      r.nextSignedDouble(0) must throwA[IllegalArgumentException]
    }
    
    "return a pseudorandom, double value between doubles -N and N (exclusive)" in {
      // multiple random tests
      (1 to 100).foreach { i => 
        val d1 = r.nextDouble()
        val d2 = r.nextInt(i) + r.nextDouble()
        r.nextSignedDouble(d1) must be_>=(-d1) and be_<=(d1)
        r.nextSignedDouble(d2) must be_>=(-d2) and be_<=(d2)
      }
      // illegal argument
      r.nextSignedDouble(0D) must throwA[IllegalArgumentException]
    }
  }
}