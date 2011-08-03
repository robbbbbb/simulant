package net._01001111.simulant.people

import net._01001111.simulant.random.Randomizer

abstract class Gender
case object Male extends Gender
case object Female extends Gender
case object AnyGender extends Gender

object Genders extends Randomizer {
  lazy val all = List(Male,Female)
  def select = random.select(all)
}