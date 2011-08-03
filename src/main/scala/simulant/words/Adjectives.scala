package net._01001111.simulant.words

import net._01001111.simulant.random.Randomizer

object Adjectives extends Randomizer {
  lazy val all = List(
    Adjective("able"),
    Adjective("bad"),
    Adjective("big"),
    Adjective("dark"),
    Adjective("different"),
    Adjective("early"),
    Adjective("empty"),
    Adjective("few"),
    Adjective("first"),
    Adjective("good"),
    Adjective("great"),
    Adjective("high"),
    Adjective("important"),
    Adjective("large"),
    Adjective("last"),
    Adjective("light"),
    Adjective("little"),
    Adjective("long"),
    Adjective("new"),
    Adjective("next"),
    Adjective("old"),
    Adjective("other"),
    Adjective("own"),
    Adjective("public"),
    Adjective("right"),
    Adjective("same"),
    Adjective("small"),
    Adjective("young")
  )
  
  def one:Adjective = random.select(all)
  def apply(n:Int):List[Adjective] = random.select(all, n)
  
}