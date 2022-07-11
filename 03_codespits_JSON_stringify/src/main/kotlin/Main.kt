import kotlin.reflect.KProperty

// 임의의 Object 가 들어오면 String JSON 타입으로 반환하는 프로시저를 만들어보자
class Json0(val a: Int, val b: String)

fun stringify(value: Any) = StringBuilder().run {
    jsonValue(value)
    toString()
}

fun StringBuilder.jsonValue(value: Any?) {
    when (value) {
        null -> append("null")
        is String -> jsonString(value)
        is Boolean, is Number -> append("$value")
        is List<*> -> jsonList(value)
        else -> jsonObject(value)
    }
}

private fun StringBuilder.jsonList(value: List<*>) {
    wrap('[', ']') {
        value.joinTo({ append(',') }) {
            jsonValue(it)
        }
    }
}

fun <T> Iterable<T>.joinTo(sep: () -> Unit, transform: (T) -> Unit) {
    forEachIndexed { count, element ->
        if (count != 0) sep()
        transform(element)
    }
}

private fun StringBuilder.jsonObject(value: Any) {
    append("{")
    value::class.members.filterIsInstance<KProperty<*>>().joinTo({ append(',') }) {
        jsonValue(it.name)
        append(':')
        jsonValue(it.getter.call(value))
    }
    append("}")
}

private fun StringBuilder.jsonString(value: String) = append(""""${value.replace("\"", "\\\"")}"""")

fun StringBuilder.comma() {
    append(",")
}

fun StringBuilder.wrap(begin: Char, end: Char, block: StringBuilder.() -> Unit) {
    append(begin)
    block()
    append(end)
}

fun main() {
    val json0 = Json0(77, "Tom")
    println(stringify(json0))
}
