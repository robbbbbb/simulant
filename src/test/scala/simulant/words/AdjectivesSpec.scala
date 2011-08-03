package net._01001111.simulant.words

import net._01001111.simulant.test.SimulantMatchers._

import org.specs2.mutable._

class AdjectivesSpec extends Specification {
  
  "Adjectives" should {
    
    "return one random adjective" in {
      val a = Adjectives.one
      a.toString must be matching("[a-z]+")
    }
  
    "return multiple random adjectives" in {
      val i = 42
      val adjectives = Adjectives(i)
      for (a <- adjectives) {
        a.toString must be matching("[a-z]+")
      }
      adjectives must have size(i)
    }
  }
}