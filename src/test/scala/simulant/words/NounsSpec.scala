package net._01001111.simulant.words

import net._01001111.simulant.test.SimulantMatchers._

import org.specs2.mutable._

class NounsSpec extends Specification {
  
  "Nouns" should {
    
    "return one random noun" in {
      val n = Nouns.one
      n.singular must be matching("[a-z]+")
      n.plural must be matching("[a-z]+")
    }
  
    "return multiple random nouns" in {
      val i = 42
      val nouns = Nouns(i)
      for (n <- nouns) {
        n.singular must be matching("[a-z]+")
        n.plural must be matching("[a-z]+")
      }
      nouns must have size(i)
    }
  }
}