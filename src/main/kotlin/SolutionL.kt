import java.util.*


private fun readInt() = readString().toInt()
private fun readString() = readLine().toString()
private fun readDouble() = readString().toDouble()
private fun readListString() = readString().split(" ")
private fun readListInt() = readString().split(" ").map { it.toInt() }


fun main() {



}



fun maximalPathQuality(values: IntArray, edges: Array<IntArray>, maxTime: Int): Int {

    println(
        maximalPathQuality(
            intArrayOf(5, 10, 15, 20),
            arrayOf(
                intArrayOf(0, 1, 10),
                intArrayOf(1, 2, 10),
                intArrayOf(0, 3, 10)
            ),
            30
        )
    )
    val adj = Array(values.size) { mutableListOf<Dest1>() }
    for ((from, to, time) in edges) {
        adj[from].add(Dest1(to, time))
        adj[to].add(Dest1(from, time))
    }
    for (i in 0 until adj.size) {
        println("I : $i -> ${adj[i]}")
    }
    val visited = BooleanArray(values.size) { false }
    visited[0] = true
    backtracking(0, adj, maxTime, visited, values[0], values)

    return ansMax
}

var ansMax = 0

fun backtracking(
    at: Int,
    adj: Array<MutableList<Dest1>>,
    curTime: Int,
    visited: BooleanArray,
    score: Int,
    values: IntArray
) {

    if (at == 0) {
        ansMax = Math.max(ansMax, score)
    }

    for (dest in adj[at]) {
        val (to, time) = dest
        var nextScore = score
        if (!visited[to]) {
            nextScore += values[to]
            visited[to] = true
        }
        println("NextScore : $nextScore To : $to And Time : $time : Left : $curTime")
        if (curTime - time >= 0)
            backtracking(to, adj, curTime - time, visited, nextScore, values)
        visited[to] = false
    }

}

data class Dest1(val to: Int, val time: Int)




























