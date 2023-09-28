import java.math.BigInteger
import java.util.*
import kotlin.reflect.KClass


private val scanner = Scanner(System.`in`)

private fun readInt() = scanner.nextInt()
private fun readString() = scanner.nextLine()
private fun readDouble() = scanner.nextDouble()
private fun readListString() = scanner.nextLine().split(" ")
private fun readListInt() = scanner.nextLine().split(" ").map { it.toInt() }
private fun readListDouble() = scanner.nextLine().split(" ").map { it.toDouble() }

fun main() {




}

fun minLengthAfterRemovals(nums: List<Int>): Int {

    var mid = nums.size / 2
    var c = 0
    for (i in 0 until nums.size / 2) {
        val cur = nums[i]
        if (i == 2)
            println()
        if (mid < nums.size && cur < nums[mid]) {
            mid++
        } else {
            while (mid < nums.size && cur == nums[mid]) {
                c++
                mid++
            }
            if (mid == nums.size) {
                return c + ((nums.size / 2) - i)
            }
            mid++
        }
    }
    if (nums.size % 2 == 1)
        return 1
    return 0
}

fun minimumRightShifts(nums: List<Int>): Int {

    val num = nums.toIntArray()
    var at = 0
    while (at + 1 < nums.size && num[at] <= num[at + 1]) {
        at++
    }
    if (at == nums.size - 1)
        return 0
    at++
    var c = nums.size - at
    while (at + 1 < nums.size && num[at] <= num[at + 1]) {
        at++
    }
    if (nums[nums.size - 1] > nums[0])
        return -1
    if (at == nums.size - 1)
        return c

    return -1
}

var isHandled = false

fun handleOnce(event: String) {
    if (!isHandled) {
        isHandled = true
        println(event)
    }
}

enum class Laptop(name: String) {
    Samsung("OK"),
    HP("Samsung"),
    Dell("Computer")
}

inline fun <reified T> List<Any>.checkingReified() {
    this.filter { it is T }.forEach { println("It is $it of type : ${it.javaClass.name}") }
}

fun <T : Any> solve(value: T) {
    println("Type is : ${value::class.java.simpleName}")
}

inline fun callFunction(call: (Int) -> Unit) {
    for (i in 1..10) {
        if (i % 2 == 0)
            call(i)
    }
}

fun countRangeSum(nums: IntArray, lower: Int, upper: Int): Int {

    println(
        countRangeSum(
            intArrayOf(),
            3,
            3
        )
    )


    return 0
}


fun cutOffTree(forest: List<List<Int>>): Int {

    println(
        cutOffTree(
            listOf(
                listOf(2, 3, 4),
                listOf(0, 0, 3),
                listOf(8, 7, 6)
            )
        )
    )
    if (forest[0][0] == 0) return -1
    val board = forest.map { it.toMutableList() }
    //value,i,j
    val heights = mutableListOf<IntArray>()
    for (i in 0 until board.size) {
        for (j in 0 until board[i].size) {
            if (board[i][j] > 1) {
                heights.add(intArrayOf(board[i][j], i, j))
            }
        }
    }
    val sorted = heights.sortedWith(object : Comparator<IntArray> {
        override fun compare(o1: IntArray, o2: IntArray): Int {
            return o1[0] - o2[0]
        }
    })
    var prev = intArrayOf(0, 0)
    var ans = 0
    for ((value, i, j) in sorted) {
        val cur = findMinWalksWithDijkstra(board, prev, intArrayOf(i, j))
        if (cur == -1)
            return -1
        println("Value : $value Walks : $cur I : $i J : $j")
        ans += cur
        prev = intArrayOf(i, j)
    }

    return ans
}

//walks
fun findMinWalksWithDijkstra(board: List<MutableList<Int>>, start: IntArray, dest: IntArray): Int {

    //walks,i,j
    val queue = PriorityQueue(object : Comparator<IntArray> {
        override fun compare(o1: IntArray, o2: IntArray): Int {
            return o1[0] - o2[0]
        }
    })
    queue.add(intArrayOf(0, start[0], start[1]))
    val visited = Array(board.size) { BooleanArray(board[0].size) { false } }
    while (queue.isNotEmpty()) {
        val poll = queue.poll()
        if (poll[1] == dest[0] && poll[2] == dest[1])
            return poll[0]
        for (dir in dirs) {
            val i = dir[0] + poll[1]
            val j = dir[1] + poll[2]
            if (i in 0 until board.size && j in 0 until board[0].size && board[i][j] != 0 && !visited[i][j]) {
                queue.add(intArrayOf(poll[0] + 1, i, j))
                visited[i][j] = true
            }
        }
    }

    return -1
}

class Computer(val name: String, val surName: String)

class Communicator<R> {

    var setEvent: ((event: R) -> Unit)? = null

}

sealed interface Event {
    data class Success(val data: String) : Event
    data class Failed(val message: String) : Event
}

private fun calculateTibetCATXCH(str: String): Boolean {
    println(calculateTibetCATXCH("100000.333"))

    val amount = str.toDoubleOrNull() ?: return false
    val tokenAmount =
        ((amount * 1000L).toInt() * 528541571L) / 561252123L
//    var xch =
//        ((BigDecimal(str).multiply(BigDecimal("10000"))).multiply(BigDecimal("36107837193746"))).divide(BigDecimal("561252123"))
//            .toDouble()
    val xchTemp =
        BigInteger("${(36107837193746 * amount).toLong()}").multiply(BigInteger("1000")).divide(BigInteger("561252123"))
//    xch += (amount * 1000L).toLong()
    println((xchTemp.plus(BigInteger("${(amount * 1000L).toLong()}"))).toDouble() / PRECISION_XCH)
//    binding.apply {
//        edtAmountCatTibet.setText(formattedDoubleAmountWithPrecision(tokenAmount / 1000.0))
//        edtAmountXCH.setText(formattedDoubleAmountWithPrecision(xch / PRECISION_XCH))
//    }
//    vm.xchDeposit = xch / PRECISION_XCH
//    vm.liquidityAmount = amount
//    vm.catTibetAmount = tokenAmount / 1000.0
//    return xch != 0.0 && tokenAmount != 0L
    return false
}

const val PRECISION_XCH = 1_000_000_000_000.0

