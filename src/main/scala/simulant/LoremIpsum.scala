package net._01001111.simulant

object LoremIpsum extends Randomizer {
  lazy val newline = System.getProperty("line.separator")
  lazy val ¶ = newline + newline
  lazy val standard = "Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum."
  lazy private val lipsumwords = List(
	"a", "ac", "accumsan", "ad", "adipiscing", "aenean", "aliquam", "aliquet", 
	"amet", "ante", "aptent", "arcu", "at", "auctor", "augue", "bibendum", 
	"blandit", "class", "commodo", "condimentum", "congue", "consectetur", 
	"consequat", "conubia", "convallis", "cras", "cubilia", "cum", "curabitur", 
	"curae", "cursus", "dapibus", "diam", "dictum", "dictumst", "dignissim", 
	"dis", "dolor", "donec", "dui", "duis", "egestas", "eget", "eleifend", 
	"elementum", "elit", "enim", "erat", "eros", "est", "et", "etiam", "eu", 
	"euismod", "facilisi", "facilisis", "fames", "faucibus", "felis", 
	"fermentum", "feugiat", "fringilla", "fusce", "gravida", "habitant", 
	"habitasse", "hac", "hendrerit", "himenaeos", "iaculis", "id", "imperdiet", 
	"in", "inceptos", "integer", "interdum", "ipsum", "justo", "lacinia", 
	"lacus", "laoreet", "lectus", "leo", "libero", "ligula", "litora", 
	"lobortis", "lorem", "luctus", "maecenas", "magna", "magnis", "malesuada", 
	"massa", "mattis", "mauris", "metus", "mi", "molestie", "mollis", "montes", 
	"morbi", "mus", "nam", "nascetur", "natoque", "nec", "neque", "netus", 
	"nibh", "nisi", "nisl", "non", "nostra", "nulla", "nullam", "nunc", "odio", 
	"orci", "ornare", "parturient","pellentesque", "penatibus", "per", 
	"pharetra", "phasellus", "placerat", "platea", "porta", "porttitor", 
	"posuere", "potenti", "praesent", "pretium", "primis", "proin", "pulvinar", 
	"purus", "quam", "quis", "quisque", "rhoncus", "ridiculus", "risus", 
	"rutrum", "sagittis", "sapien", "scelerisque", "sed", "sem", "semper", 
	"senectus", "sit", "sociis", "sociosqu", "sodales", "sollicitudin", 
	"suscipit", "suspendisse", "taciti", "tellus", "tempor", "tempus", 
	"tincidunt", "torquent", "tortor", "tristique", "turpis", "ullamcorper", 
	"ultrices", "ultricies", "urna", "ut", "varius", "vehicula", "vel", "velit", 
	"venenatis", "vestibulum", "vitae", "vivamus", "viverra", "volutpat", 
	"vulputate")
  lazy private val punctuations = List(".", "?")
  
  def punctuation:String = random.select(punctuations)
  
  def word:String = random.select(lipsumwords)
  
  def words(count:Int):String = random.select(lipsumwords,count).mkString(" ")
  
  def sentenceFragment:String = words(random.nextInt(10) + 3)
  
  def sentence:String = {
    var s = new StringBuilder(word.capitalize).append(" ")
	  if (random.nextBoolean) {
        (0 to random.nextInt(3)).foreach({
      	  s.append(sentenceFragment).append(", ")
        })
  	}
  	s.append(sentenceFragment).append(punctuation).toString
  }
  
  def sentences(count:Int):String = compose(sentence _, "  ", count)
  
  def paragraph:String = sentences(random.nextInt(4) + 2)
    
  def paragraphs(count:Int, useStandard:Boolean = false):String =  count match {
    case 0 => ""
    case 1 => if (useStandard) standard else paragraph
    case _ => paragraphs(1, useStandard) + ¶ + compose(paragraph _, ¶, count - 1)
  }
  
}