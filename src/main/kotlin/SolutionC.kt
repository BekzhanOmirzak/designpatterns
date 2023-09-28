import sun.security.ec.point.ProjectivePoint.Mutable

private fun readInt() = readString().toInt()
private fun readString() = readLine().toString()
private fun readDouble() = readString().toDouble()
private fun readListString() = readString().split(" ")
private fun readListInt() = readString().split(" ").map { it.toLong() }

fun main() {

    println(getSumOfNums(1608737402))
    //1294018015101223503
    //923456789987654321
    println(isPossible(1608737403, 923456789987654321))
    repeat(readInt()) {
        val (a, max) = readListInt()
        println(solve(a, max))
    }

}

fun solve(a: Long, max: Long): Long {
    var i = 1L
    var j = (2L * a - 1L)
    println("J : $j")
    var ans = 1L
    while (i <= j) {
        val mid = (i + j) / 2L
        println("Mid : $mid")
        if (isPossible(mid, max)) {
            ans = Math.max(ans, mid)
            i = mid + 1
        } else
            j = mid - 1
    }
    return ans
}

fun isPossible(at: Long, max: Long): Boolean {
    return (getSumOfNums(at) - at) < max
}

fun getSumOfNums(at: Long): Long {
    return (at * (at + 1L)) / 2L
}


















