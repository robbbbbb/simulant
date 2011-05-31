package net._01001111.simulant.test

import org.specs2.matcher._

object SimulantMatchers {
  
  lazy private val newline = System.getProperty("line.separator")
  def splitCount(s:String,regex:String):Int = if (s == null) 0 else s.split(regex).length
  def wordCount(s:String):Int = splitCount(s, "[\\s]+")
  def sentenceCount(s:String):Int = splitCount(s, "[.?]+")
  def paragraphCount(s:String):Int = splitCount(s, newline+newline)
  
  protected class HaveTransformedCount(f:String => Int, chunkName:String, n: =>Int) extends Matcher[String] { 
    def apply[S <: String](s: Expectable[S]) = {
      val name = chunkName + (if (n == 1) "" else "s")
      result(f(s.value) == n,
             "\"" + s.value + "\" has " + n + " " + name,
             "\"" + s.value + "\" does not have " + n + " " + name,
             s)
    } 
  }
  
  def haveWordCount(n: =>Int) = new HaveTransformedCount(wordCount, "word", n)
  def haveSentenceCount(n: =>Int) = new HaveTransformedCount(sentenceCount, "sentence", n)
  def haveParagraphCount(n: =>Int) = new HaveTransformedCount(paragraphCount, "paragraph", n)
}
