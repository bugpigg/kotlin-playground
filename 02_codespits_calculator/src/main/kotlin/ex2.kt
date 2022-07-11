// 계산기 만들어보기 예제 V2 - 괄호가 포함되도 작동하도록 개선해보자
val number = """([+-]?[.\d]+)"""
val groupMD2 = """${number}([*/])${number}""".toRegex()
val plus = number.toRegex()
val trim2 = """[^.\d-+*/()]""".toRegex()
val bracket = """\(([^)]+)\)""".toRegex()
fun reduceBracket(v:String) :String {
    var str = v.replace(trim2, "") // 숫자, 기호, 괄호 아닌 char 모두 삭제
    while(bracket.containsMatchIn(str))
        str = str.replace(bracket) {
        "${calc2(it.groupValues[1])}"
    }
    return str
}

fun calc2(v:String): Double {
    var str = reduceBracket(v)
    while (groupMD2.containsMatchIn(str)) {
        str = str.replace(groupMD2) {
            val (_,left,op,right) = it.groupValues
            val leftValue = left.toDouble()
            val rightValue = right.toDouble()
            "${when(op) {
                "*" -> leftValue*rightValue
                "/" -> leftValue/rightValue
                else -> throw Throwable("invalid operator $op")
            }}"
        }
    }
    return plus.findAll(str).fold(0.0){ acc, curr ->
        acc+curr.groupValues[1].toDouble()
    }
}

fun main(args: Array<String>) {
    println(calc2("-2 * (-3 + 0.4) / -0.2"))
}

