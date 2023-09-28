import com.sun.org.apache.xpath.internal.operations.Bool

private fun readInt() = readString().toInt()
private fun readString() = readLine().toString()
private fun readDouble() = readString().toDouble()
private fun readListString() = readString().split(" ")
private fun readListInt() = readString().split(" ").map { it.toInt() }


fun main() {


}

fun countEleven(str: String): Boolean {
    val str = readString()
    if (str.length >= 11 && countEleven(str) && check7Or8(str) && checkBracket(str) && checkBracket(str)) {

    }
    var c = 0
    for (s in str) {
        if (s.isDigit())
            c++
    }
    return c == 11
}

fun check7Or8(str: String): Boolean {
    if (str.isEmpty()) return false
    val trim = str.trim()
    if (trim[0] == '8' || trim[0] == '+') {
        if (trim[0] == '8')
            return true
        else if (trim[0] == '+' && trim[1] == '7')
            return true
    }
    return false
}

fun checkBracket(str: String): Boolean {
    if (str.contains('(') || str.contains(')')) {
        val s = if (str[0] == '+') 2 else 1
        val e = if (str[0] == '+') 6 else 5
        return str[s] == '(' && str[e] == ')'
    }
    return true
}

fun finaChecking(str: String): Boolean {

    if (str[0] == '-' || str[str.length - 1] == '-')
        return false
    for (i in 0 until str.length - 1) {
        if (str[i] == '-' && str[i + 1] == '-')
            return false
    }
    if (str.indexOf('(') != -1) {
        val end = str.indexOf(')')
        val sub = str.substring(str.indexOf('('), end)
        if (sub.contains('-'))
            return false
        var s = str.indexOf('(') - 1

    }

    return false
}


