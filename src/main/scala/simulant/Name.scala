package net._01001111.simulant

object Name extends Randomizer {
  abstract class Gender
  case object Male extends Gender
  case object Female extends Gender
  case object AnyGender extends Gender
  lazy val genders = List(Male,Female)
    
  lazy val lastNames = List( "Smith", "Johnson", "Williams", "Jones", "Brown",
    "Davis", "Miller", "Wilson", "Moore", "Taylor", "Anderson", "Thomas",
    "Jackson", "White", "Harris", "Martin", "Thompson", "Garcia", "Martinez",
    "Robinson", "Clark", "Rodriguez", "Lewis", "Lee", "Walker", "Hall", "Allen",
    "Young", "Hernandez", "King", "Wright", "Lopez", "Hill", "Scott", "Green",
    "Adams", "Baker", "Gonzalez", "Nelson", "Carter", "Mitchell", "Perez",
    "Roberts", "Turner", "Phillips", "Campbell", "Parker", "Evans", "Edwards",
    "Collins", "Stewart", "Sanchez", "Morris", "Rogers", "Reed", "Cook",
    "Morgan", "Bell", "Murphy", "Bailey", "Rivera", "Cooper", "Richardson",
    "Cox", "Howard", "Ward", "Torres", "Peterson", "Gray", "Ramirez", "James",
    "Watson", "Brooks", "Kelly", "Sanders", "Price", "Bennett", "Wood",
    "Barnes", "Ross", "Henderson", "Coleman", "Jenkins", "Perry", "Powell",
    "Long", "Patterson", "Hughes", "Flores", "Washington", "Butler", "Simmons",
    "Foster", "Gonzales", "Bryant", "Alexander", "Russell", "Griffin", "Diaz",
    "Hayes" )

	lazy val maleFirstNames = List( "James", "John", "Robert", "Michael",
    "William", "David", "Richard", "Charles", "Joseph", "Thomas", "Christopher",
    "Daniel", "Paul", "Mark", "Donald", "George", "Kenneth", "Steven", "Edward",
    "Brian", "Ronald", "Anthony", "Kevin", "Jason", "Matthew", "Gary",
    "Timothy", "Jose", "Larry", "Jeffrey", "Frank", "Scott", "Eric", "Stephen",
    "Andrew", "Raymond", "Gregory", "Joshua", "Jerry", "Dennis", "Walter",
    "Patrick", "Peter", "Harold", "Douglas", "Henry", "Carl", "Arthur", "Ryan",
    "Roger", "Joe", "Juan", "Jack", "Albert", "Jonathan", "Justin", "Terry",
    "Gerald", "Keith", "Samuel", "Willie", "Ralph", "Lawrence", "Nicholas",
    "Roy", "Benjamin", "Bruce", "Brandon", "Adam", "Harry", "Fred", "Wayne",
    "Billy", "Steve", "Louis", "Jeremy", "Aaron", "Randy", "Howard", "Eugene",
    "Carlos", "Russell", "Bobby", "Victor", "Martin", "Ernest", "Phillip",
    "Todd", "Jesse", "Craig", "Alan", "Shawn", "Clarence", "Sean", "Philip",
    "Chris", "Johnny", "Earl", "Jimmy", "Antonio" )

	lazy val femaleFirstNames = List( "Mary", "Patricia", "Linda", "Barbara",
    "Elizabeth", "Jennifer", "Maria", "Susan", "Margaret", "Dorothy", "Lisa",
    "Nancy", "Karen", "Betty", "Helen", "Sandra", "Donna", "Carol", "Ruth",
    "Sharon", "Michelle", "Laura", "Sarah", "Kimberly", "Deborah", "Jessica",
    "Shirley", "Cynthia", "Angela", "Melissa", "Brenda", "Amy", "Anna",
    "Rebecca", "Virginia", "Kathleen", "Pamela", "Martha", "Debra", "Amanda",
    "Stephanie", "Carolyn", "Christine", "Marie", "Janet", "Catherine",
    "Frances", "Ann", "Joyce", "Diane", "Alice", "Julie", "Heather", "Teresa",
    "Doris", "Gloria", "Evelyn", "Jean", "Cheryl", "Mildred", "Katherine",
    "Joan", "Ashley", "Judith", "Rose", "Janice", "Kelly", "Nicole", "Judy",
    "Christina", "Kathy", "Theresa", "Beverly", "Denise", "Tammy", "Irene",
    "Jane", "Lori", "Rachel", "Marilyn", "Andrea", "Kathryn", "Louise", "Sara",
    "Anne", "Jacqueline", "Wanda", "Bonnie", "Julia", "Ruby", "Lois", "Tina",
    "Phyllis", "Norma", "Paula", "Diana", "Annie", "Lillian", "Emily", "Robin" )
  
  def lastName:String = random.select(lastNames)

  def firstName(gender:Gender):String = gender match {
    case Male => random.select(maleFirstNames)
    case Female => random.select(femaleFirstNames)
    case AnyGender => firstName(random.select(genders))
  }
  
  def firstName:String = firstName(AnyGender)
  
  def fullName(gender:Gender):String = firstName(gender) + " " + lastName
  
  def fullName:String = fullName(AnyGender)
    
}