class Main {
}

fun main() {
    println("Hello World!")
}

fun sum(a: Int, b: Int): Int {
    return a + b
}

// Unit 은 자바의 Void 로 생각하면 된다
fun sum2(a: Int, b: Int): Unit {
    println("sum of $a and $b ")
}

fun sum3(a: Int, b: Int) = a + b

fun variable() {
    val a: Int = 1
    val b = 2
    val c: Int
    c = 3
}

fun string() {
    var a = 1
    var s2 = "a is $a"
}

fun conditionalExpression() {
    fun maxOf(a: Int, b: Int) = if (a<b) a  else b
}

fun forLoop() {
    val items = listOf("apple", "banana", "kiwi")
    for (item in items) {
        println(item)
    }
}

fun whenExpression() {
    fun describe(obj: Any): String =
        when (obj) {
            1 -> "One"
            "Hello" -> "Greeting"
            is Long -> "Long"
            !is String -> "Not a String"
            else -> "Unknown"
        }
}

fun rangeExpression() {
    val x = 10
    val y = 9
    if (x in 1..y + 1) {
        println("fits in range")
    }
}

fun rangeWithForLoop() {
    for (x in 1..10 step 2) {
        print(x)
    }

    for (y in 9 downTo 0 step 3) {
        print(y)
    }
}

// Collections
fun collection() {
    // lambda expression
    val fruits = listOf("banana", "avocado", "apple", "kiwifruit")
    fruits
        .filter { it.startsWith("a") }
        .sortedBy { it }
        .map { it.uppercase() }
        .forEach { println(it) }
}

// null check
fun parseInt(str: String): Int? {
    // ...
    return null
}

