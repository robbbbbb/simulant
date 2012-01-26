package net._01001111.simulant.random

class WeightedSelector[T](val weightedChoices:Map[T,Double]) extends Randomizer {
  require(weightedChoices.values.sum == 1.0, "Sum of weights must equal 1.")
  
  def nextSelection:T = {
    val r = random.nextDouble()
    var sum = 0.0
    for ((k,v) <- weightedChoices) {
      sum += v
      if (r < sum)
        return k
    }
    return weightedChoices.last._1
  }
  
}