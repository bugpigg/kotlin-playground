import java.io.File

fun main() {
    traverseMapExample()
    println("hi_oh_hi".toCamelCase())
    notNullExample()
}

// Create DTOs
data class Person(val name: String, val email: String) {
    var age: Int = 0
}

fun dataExample() {
    val person1 = Person("John", "e1")
    person1.age = 20
    val newPerson1 = person1.copy("Jack", "e2")
    // destructuring declarations
    val (name, email) = person1
}

// Travers a map or a list of pairs
fun traverseMapExample() {
    for ((k, v) in mapOf("One" to 1, "Two" to 2, "Three" to 3)) {
        println("$k -> $v")
    }
}

// Iterate over a range
fun iterateExample() {
    for (i in 1..100) {}
    for (i in 1 until 100) {} // does not include 100
    (1..100).forEach {
        println("$it")
    }
}

// Lazy property
// 나중에 값을 사용할 수 있게 되면, 그때 값을 입력해주고 싶을때가 있음
// 이럴 때 사용 가능한 방법 중에, 아래와 같이 null로 설정해 준 뒤 바꾸는 방법도 있지만, lazyinit도 있음
fun lazyExample() {
    lateinit var inputValue: String
    val p: String by lazy { "hi" } // 사용시에 어떤 값이 들어가는지를 정해준다.
}

// Extension functions!!!
val snakeRegex = "_[a-zA-Z]".toRegex()
fun String.toCamelCase(): String {
    return snakeRegex.replace(this) {
        it.value.replace("_","")
            .uppercase()
    }
}

// create a Singleton
object Resource {
    val name: String = "Name"
}

// if-not-null-else shorthand
// ?: 엘비스 오퍼레티어라고 부른다.
fun notNullExample() {
    val files = File("Test").listFiles()
    println(files?.size)

    println(files?.size ?: "empty")

    val filesSize  = files?.size ?: run {
        println("hi")
    }
}

// get first item
fun getFirstExample() {
    val hi = listOf(1,2,3).firstOrNull() ?: "nothing"
}

// execute if not null
fun executeNotNullExample() {
    val value = 1
    value?.let {

    }
}

// builder-style usage
fun arrayOfMinusOnes(size: Int): IntArray {
    return IntArray(size).apply { fill(-1) }
}

// list to set
fun list2set() {
    val sourceList = listOf(1, 2, 3, 1)
    val copySet = sourceList.toSet()
}
