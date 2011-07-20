package net._01001111.simulant.words

import net._01001111.simulant.test.SimulantMatchers._

import scala.util.Random
import org.specs2.mutable._

class LoremIpsumSpec extends Specification {
  
  val r = new Random
  def randomint:Int = r.nextInt(20) + 1

  "LoremIpsum" should {
    
    "return a random punctuation mark" in {
      LoremIpsum.punctuation must be matching("[.?]")
    }
  
    "return a random word" in {
      val w = LoremIpsum.word
      w must not be empty
      w must be matching("[a-z]+")
    }
    
    "generate a specified number of words" in {
      val n = randomint
      LoremIpsum.words(n) must haveWordCount(n)
    }
    
    "generate a segment fragment between 3 and 12 words in length" in {
      wordCount(LoremIpsum.sentenceFragment) must be_>=(3) and be_<=(12)
    }
    
    "generate a sentence" in {
      val s = LoremIpsum.sentence
      s.head.toString must be matching("[A-Z]")
      s.last.toString must be matching("[.?]")
      wordCount(s) must be_>=(3)
    }
    
    "generate a specified number of sentences" in {
      val n = randomint
      LoremIpsum.sentences(n) must haveSentenceCount(n)
    }
    
    "generate a paragraph between 2 and 5 sentences in length" in {
      sentenceCount(LoremIpsum.paragraph) must be_>=(2) and be_<=(5)
    }
    
    "generate a specified number of paragraphs" in {
      val n = randomint
      LoremIpsum.paragraphs(n) must haveParagraphCount(n)
    }
    
    "generate a specified number of paragraphs starting with the standard Lorem Ipsum paragraph" in {
      val n = randomint
      val p = LoremIpsum.paragraphs(n, true)
      p must haveParagraphCount(n)
      p must startWith(LoremIpsum.standard)
    }
  }
}