package net._01001111.simulant.words

case class Noun(val singular:String, val plural:String) {
  override def toString() = singular
}