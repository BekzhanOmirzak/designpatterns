import java.util.*
import kotlin.collections.HashMap


private fun readInt() = readString().toInt()
private fun readString() = readLine().toString()
private fun readDouble() = readString().toDouble()
private fun readListString() = readString().split(" ")
private fun readListInt() = readString().split(" ").map { it.toInt() }


fun main() {



}



fun maximumSumOfHeights(maxHeights: List<Int>): Long {

    println(
        maximumSumOfHeights(
            listOf(
                1, 5, 2, 5, 6, 4, 6, 3, 4, 5
            )
        )
    )

    val dpLeft = LongArray(maxHeights.size)
    val stack = Stack<Int>()
    dpLeft[0] = maxHeights[0] + 0L
    stack.add(0)
    for (i in 1 until maxHeights.size) {
        if (maxHeights[i - 1] <= maxHeights[i]) {
            dpLeft[i] = dpLeft[i - 1] + maxHeights[i]
        } else {
            var l = 0
            while (stack.isNotEmpty() && maxHeights[stack.peek()] > maxHeights[i]) {
                l = stack.pop()
            }
            if (stack.isEmpty()) {
                dpLeft[i] = maxHeights[i] * (i + 1L)
            } else {
                val rightSide = i - stack.peek()
                dpLeft[i] = dpLeft[l - 1] + (rightSide * maxHeights[i])
            }
        }
        stack.push(i)
    }

    val dpRight = LongArray(maxHeights.size)
    stack.clear()
    stack.add(maxHeights.size - 1)
    dpRight[dpRight.size - 1] = maxHeights[maxHeights.size - 1] + 0L
    for (i in maxHeights.size - 2 downTo 0) {
        if (maxHeights[i] >= maxHeights[i + 1]) {
            dpRight[i] = dpRight[i + 1] + maxHeights[i]
        } else {
            var r = 0
            while (stack.isNotEmpty() && maxHeights[i] < maxHeights[stack.peek()]) {
                r = stack.pop()
            }
            if (stack.isEmpty()) {
                dpRight[i] = maxHeights[i] * (maxHeights.size - i.toLong())
            } else {
                val leftSide = stack.peek() - i
                dpRight[i] = dpRight[r + 1] + (leftSide * maxHeights[i])
            }
        }
        stack.push(i)
    }

    var ans = 0L
    for (i in 0 until maxHeights.size) {
        val cur = dpLeft[i] + dpRight[i] - maxHeights[i]
        ans = Math.max(ans, cur)
    }

    println("Left : ${dpLeft.toList()}")
    println("Right : ${dpRight.toList()}")

    return ans
}

fun countPaths(n: Int, edges: Array<IntArray>): Long {

    val adj = Array(n + 1) { mutableListOf<Int>() }
    for ((from, to) in edges) {
        adj[from].add(to)
        adj[to].add(from)
    }

    val isPrime = Array<Boolean?>(n + 1) { null }

    var ans = 0L
    val memo = hashMapOf<String, Int>()

    for (i in 2 until isPrime.size) {
        if (isPrime[i] != null)
            continue
        isPrime[i] = true
        for (j in i + i until isPrime.size step i) {
            isPrime[j] = false
        }
    }

    for (prime in 2 until isPrime.size) {
        if (isPrime[prime] == true) {
            val list = mutableListOf<Int>()
            for (n in adj[prime]) {
                val cur = dfs(n, prime, isPrime, adj, memo)
                list.add(cur)
            }
            var sum = 0L
            for (l in list) {
                sum += l
                ans += l
            }
            for (i in 0 until list.size - 1) {
                sum -= list[i]
                ans += (list[i] * sum)
            }
        }
    }

    return ans
}

fun dfs(
    at: Int,
    parent: Int,
    isPrimes: Array<Boolean?>,
    adj: Array<MutableList<Int>>,
    memo: HashMap<String, Int>
): Int {
    if (isPrimes[at] == true) return 0
    val key = "$at$parent"
    if (memo.containsKey(key))
        return memo[key]!!
    var cur = 1
    for (n in adj[at]) {
        if (n != parent) cur += dfs(n, at, isPrimes, adj, memo)
    }
    memo[key] = cur

    return cur
}