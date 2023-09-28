import java.util.*


private fun readInt() = readString().toInt()
private fun readString() = readLine().toString()
private fun readDouble() = readString().toDouble()
private fun readListString() = readString().split(" ")
private fun readListInt() = readString().split(" ").map { it.toInt() }


fun main() {

    repeat(readInt()) {
        val (act, place) = readListInt()
        val nums = readString()
        println(solve(act, place, nums))
    }

}

fun solve(act: Int, place: Int, nums: String): Long {
    if (!nums.contains('1'))
        return 0

    var facedMines = false
    var at = 0
    while (at < nums.length && (!facedMines || nums[at] == '1')) {
        at++
        if (at < nums.length && nums[at] == '1')
            facedMines = true
    }

    var coins = act.toLong()
    while (at < nums.length) {
        var space = 0
        while (at < nums.length && nums[at] == '0') {
            space++
            at++
        }
        var foundMine = false
        while (at < nums.length && nums[at] == '1') {
            at++
            foundMine = true
        }
        if (!foundMine)
            break
        if (space * place <= act) {
            coins += (space * place)
        } else {
            coins += act
        }
    }

    return coins
}


