import org.json.JSONObject
import java.util.*
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine

/*

//I am happy to announce, that I am starting a new position as a Programmer at Tinkoff.
//(Russian's largest banking service)

//I am happy to announce, that I am starting a new position as a Programmer at Yandex.
//(Let's recreate Yandex Go :)

//I am happy to announce, that I am starting a new position as a mid-Level Software Engineer at Google, L-4 position in Germany.
//(I am very grateful for those who've supported me along the way, special thanks to my wife and parents)

 */

val dirs = arrayOf(
    intArrayOf(0, 1), intArrayOf(0, -1), intArrayOf(1, 0), intArrayOf(-1, 0)
)

val mod = Math.pow(10.0, 9.0).toInt() + 7

fun main(args: Array<String>) {


}

fun strConvertToChar(strs: Array<String>): CharArray {
    return strs.map { it[0] }.toCharArray()
}

fun solveSudoku(board: Array<CharArray>): Unit {

    val cols = Array(9) { getChars() }
    val rows = Array(9) { getChars() }
    val grid = Array(9) { getChars() }

    println(
        solveSudoku(
            arrayOf(
                strConvertToChar(arrayOf("5", "3", ".", ".", "7", ".", ".", ".", ".")),
                strConvertToChar(arrayOf("6", ".", ".", "1", "9", "5", ".", ".", ".")),
                strConvertToChar(arrayOf(".", "9", "8", ".", ".", ".", ".", "6", ".")),
                strConvertToChar(arrayOf("8", ".", ".", ".", "6", ".", ".", ".", "3")),
                strConvertToChar(arrayOf("4", ".", ".", "8", ".", "3", ".", ".", "1")),
                strConvertToChar(arrayOf("7", ".", ".", ".", "2", ".", ".", ".", "6")),
                strConvertToChar(arrayOf(".", "6", ".", ".", ".", ".", "2", "8", ".")),
                strConvertToChar(arrayOf(".", ".", ".", "4", "1", "9", ".", ".", "5")),
                strConvertToChar(arrayOf(".", ".", ".", ".", "8", ".", ".", "7", "9"))
            )
        )
    )


    for (i in 0 until board.size) {
        for (j in 0 until board[i].size) {
            if (board[i][j] != '.') {
                rows[i].remove(board[i][j])
                cols[j].remove(board[i][j])
                val pos = getGridPos(i, j)
                grid[pos].remove(board[i][j])
            }
        }
    }

    dfs(0, 0, board, cols, rows, grid)


}

var hasFound = false

fun dfs(
    i: Int,
    j: Int,
    board: Array<CharArray>,
    cols: Array<MutableList<Char>>,
    rows: Array<MutableList<Char>>,
    grid: Array<MutableList<Char>>
) {
    if (i == 9) {
        hasFound = true
        return
    }

    if (j == 9)
        return dfs(i + 1, 0, board, cols, rows, grid)

    if (board[i][j] != '.')
        return dfs(i, j + 1, board, cols, rows, grid)

    val freq = hashMapOf<Char, Int>()
    for (i in rows[i]) {
        freq[i] = freq.getOrDefault(i, 0) + 1
    }
    for (i in cols[j]) {
        freq[i] = freq.getOrDefault(i, 0) + 1
    }

    val pos = getGridPos(i, j)
    for (i in grid[pos]) {
        freq[i] = freq.getOrDefault(i, 0) + 1
    }

    for ((key, value) in freq) {
        if (value == 3) {
            rows[i].remove(key)
            cols[j].remove(key)
            board[i][j] = key
            dfs(i, j + 1, board, cols, rows, grid)
            if (!hasFound)
                board[i][j] = '.'
            rows[i].add(key)
            cols[j].add(key)
        }
    }

}

fun getChars(): MutableList<Char> {
    return "123456789".map { it }.toMutableList()
}

fun getGridPos(i: Int, j: Int): Int {
    return (i / 3) * 3 + (j / 3)
}

fun kInversePairs(n: Int, k: Int): Int {

    println(
        kInversePairs(
            3, 1
        )
    )

    return 0
}

fun maximumSum(nums: List<Int>): Long {


    println(
        maximumSum(
            listOf(
                8, 7, 3, 5, 7, 2, 4, 9
            )
        )
    )

    return 0
}

fun countPairs(coordinates: List<List<Int>>, k: Int): Int {

    println(
        countPairs(
            listOf(
                listOf(1, 2),
                listOf(4, 2),
                listOf(1, 3),
                listOf(5, 2)
            ),
            5
        )
    )

    return 0
}

fun maxNumberOfAlloys(
    n: Int,
    k: Int,
    budget: Int,
    composition: List<List<Int>>,
    stock: List<Int>,
    cost: List<Int>
): Int {

    var ans = 0
    for (i in 0 until composition.size) {
        val res = maxCreate(budget, composition[i].toIntArray(), stock.toIntArray(), cost.toIntArray())
        ans = Math.max(ans, res)
    }

    return ans
}

fun maxCreate(budget: Int, machine: IntArray, stock: IntArray, cost: IntArray): Int {

    var l = 0
    var r = Int.MAX_VALUE
    var ans = 0
    while (l <= r) {
        val mid = (l + r) / 2
        if (isPossible(mid, machine, stock, cost, budget)) {
            ans = Math.max(ans, mid)
            l = mid + 1
        } else {
            r = mid - 1
        }
    }

    return ans
}

fun isPossible(counter: Int, machine: IntArray, stock: IntArray, cost: IntArray, budget: Int): Boolean {

    val metals = LongArray(machine.size) { 0 }
    for (i in 0 until machine.size) {
        metals[i] = counter * machine[i].toLong()
    }
    var curCost = 0L
    for (i in 0 until stock.size) {
        val remain = metals[i] - stock[i]
        if (remain > 0) {
            curCost += (remain * cost[i].toLong())
        }
    }

    return curCost <= budget
}

fun rearrangeSticks(n: Int, k: Int): Int {

    println(
        rearrangeSticks(
            3,
            2
        )
    )

    return 0
}

fun secondGreaterElement(nums: IntArray): IntArray {

    println(
        secondGreaterElement(
            intArrayOf(
                2, 4, 0, 9, 6
            )
        )
    )

    return nums
}

fun sumImbalanceNumbers(nums: IntArray): Int {

    println(
        sumImbalanceNumbers(
            intArrayOf(

            )
        )
    )

    return 0
}

fun continuousSubarrays(nums: IntArray): Long {

    var l = 0
    var ans = 0L
    val minHeap = PriorityQueue<Int>()
    val maxHeap = PriorityQueue<Int>(Collections.reverseOrder())
    var r = 0
    while (r < nums.size) {
        while (r < nums.size && canBeAdded(minHeap, maxHeap, nums[r])) {
            minHeap.add(nums[r])
            maxHeap.add(nums[r])
            r++
        }
        if (r == nums.size) {
            break
        }
        ans += (r - l)
        minHeap.remove(nums[l])
        maxHeap.remove(nums[l])
        l++
    }
    ans += getSumOfNums(r - l)

    return ans
}

fun canBeAdded(min: PriorityQueue<Int>, max: PriorityQueue<Int>, cur: Int): Boolean {

    if (min.isEmpty() || max.isEmpty()) return true

    return Math.abs(min.peek() - cur) <= 2 && Math.abs(max.peek() - cur) <= 2
}

fun getSumOfNums(n: Int): Long {
    return (n * (n + 1L)) / 2L
}


fun countBlackBlocks(m: Int, n: Int, coordinates: Array<IntArray>): LongArray {

    println(
        countBlackBlocks(
            3, 3, arrayOf(
                intArrayOf(0, 0)
            )
        )
    )

    return longArrayOf()
}

fun minimumBeautifulSubstrings(s: String): Int {
    val memo = IntArray(s.length) { -1 }
    val res = dp(0, s, memo)
    if (res == Int.MAX_VALUE)
        return -1

    return res
}

fun dp(at: Int, s: String, memo: IntArray): Int {

    if (at == s.length) return 0
    if (memo[at] != -1)
        return memo[at]
    if (s[at] == '0')
        return Int.MAX_VALUE
    var cur = Int.MAX_VALUE
    var n = 0
    for (i in at until s.length) {
        n = n shl 1
        if (s[i] == '1') {
            n = n or 1
        }
        if ((n % 5 == 0 || n == 1) && isPowerOfFive(n)) {
            val res = dp(i + 1, s, memo)
            if (res != Int.MAX_VALUE) {
                cur = Math.min(cur, res + 1)
            }
        }
    }

    memo[at] = cur

    return cur
}

fun isPowerOfFive(cur: Int): Boolean {
    var power = 1
    while (power < cur) {
        power *= 5
    }
    return power == cur
}


fun minimumMoves(grid: Array<IntArray>): Int {
    dp(grid, 0)
    return minMoves
}

var minMoves = Int.MAX_VALUE

fun dp(grid: Array<IntArray>, moves: Int) {

    val fills = mutableListOf<IntArray>()
    for (i in 0 until grid.size) {
        for (j in 0 until grid.size) {
            if (grid[i][j] >= 2) fills.add(intArrayOf(i, j))
        }
    }
    if (fills.isEmpty()) {
        minMoves = Math.min(minMoves, moves)
    }

    for (i in 0 until grid.size) {
        for (j in 0 until grid.size) {
            if (grid[i][j] == 0) {
                for (fil in fills) {
                    val cur = dist(i, j, fil[0], fil[1])
                    val clone = grid.map { it.clone() }.toTypedArray()
                    clone[i][j] = 1
                    clone[fil[0]][fil[1]]--
                    dp(clone, moves + cur)
                }
            }
        }
    }

}

fun dist(x1: Int, y1: Int, x2: Int, y2: Int): Int {
    return Math.abs(x1 - x2) + Math.abs(y1 - y2)
}

fun bfs(grid: Array<IntArray>, i: Int, j: Int): Int {

    val queue = LinkedList<IntArray>()
    queue.add(intArrayOf(i, j))
    var level = 0
    val visited = Array(3) { BooleanArray(3) { false } }
    visited[i][j] = true
    while (queue.isNotEmpty()) {
        val size = queue.size
        level++
        for (i in 0 until size) {
            val poll = queue.poll()
            for (dir in dirs) {
                val nI = dir[0] + poll[0]
                val nJ = dir[1] + poll[1]
                if (nI in 0..2 && nJ in 0..2 && !visited[nI][nJ]) {
                    visited[nI][nJ] = true
                    queue.add(intArrayOf(nI, nJ))
                    if (grid[nI][nJ] >= 2) {
                        grid[nI][nJ]--
                        return level
                    }
                }
            }
        }
    }

    return 0
}

fun numberOfBeautifulIntegers(low: Int, high: Int, k: Int): Int {

    return 0
}

fun minOperationsQueries(n: Int, edges: Array<IntArray>, queries: Array<IntArray>): IntArray {


    println(
        minOperationsQueries(
            8, arrayOf(
                intArrayOf(1, 2, 6),
                intArrayOf(1, 3, 4),
                intArrayOf(2, 4, 6),
                intArrayOf(2, 5, 3),
                intArrayOf(3, 6, 6),
                intArrayOf(3, 0, 8),
                intArrayOf(7, 0, 2)
            ), arrayOf(
                intArrayOf(4, 6), intArrayOf(0, 4), intArrayOf(6, 5), intArrayOf(7, 4)
            )
        )
    )
    val distanceFromRoot = IntArray(n) { 0 }
    val parents = Array(n) { intArrayOf(0, 0) }
    //dest,w
    val adj = Array(n + 1) { mutableListOf<IntArray>() }

    for ((u, v, w) in edges) {
        adj[u].add(intArrayOf(v, w))
        adj[v].add(intArrayOf(u, w))
    }

    dfs(0, adj, parents, -1, distanceFromRoot, 0, intArrayOf())

    for (i in 0 until distanceFromRoot.size) {
        println("Node : $i Dist : ${distanceFromRoot[i]}")
    }
    for (i in 0 until parents.size) {
        println("Node : $i Parent : ${parents[i][0]} Weight : ${parents[i][1]}")
    }

    val binaryLifting = Array(n) { Array(15) { IntArray(28) { 0 } } }
    for (i in 0 until parents.size) {
        binaryLifting[i][0][27] = parents[i][0]
        binaryLifting[i][0][parents[i][1]]++
    }

    for (i in 1..15) {
        for (j in 1 until n) {
            val prev = binaryLifting[j][i - 1]
            if (prev[27] != -1) {
                binaryLifting[j][i] = prev
            }
        }
    }

    val ans = IntArray(queries.size) { 0 }
    for (i in 0 until queries.size) {
        val q = queries[i]
        val d1 = distanceFromRoot[q[0]]
        val d2 = distanceFromRoot[q[1]]

    }

    return ans
}

fun getFreq(dist: Int, node: IntArray, binaryLifting: Array<Array<IntArray>>): IntArray {

    val freq = IntArray(27) { 0 }
    var cur = node
    for (i in 0..15) {

    }

    return intArrayOf()
}

fun dfs(
    at: Int,
    adj: Array<MutableList<IntArray>>,
    parents: Array<IntArray>,
    parent: Int,
    distanceFromRoot: IntArray,
    dist: Int,
    edge: IntArray
) {
    distanceFromRoot[at] = dist
    if (parent != -1) {
        parents[at] = edge
    }
    for ((to, w) in adj[at]) {
        if (to != parent) {
            dfs(to, adj, parents, at, distanceFromRoot, dist + 1, intArrayOf(at, w))
        }
    }

}

class TreeAncestor(n: Int, parent: IntArray) {

    val sparseTable = Array(n) { IntArray(21) { -1 } }

    init {
        for (i in 0 until parent.size) {
            sparseTable[i][0] = parent[i]
        }
        for (i in 1 until sparseTable[0].size) {
            for (cur in 1 until n) {
                val prevParent = sparseTable[cur][i - 1]
                if (prevParent != -1) {
                    sparseTable[cur][i] = sparseTable[prevParent][i - 1]
                }
            }
        }
    }

    fun getKthAncestor(node: Int, k: Int): Int {
        var cur = node
        for (i in 0 until 21) {
            if (k and (1 shl i) != 0) {
                cur = sparseTable[cur][i]
                if (cur == -1) return -1
            }
        }
        return cur
    }

}

fun peopleAwareOfSecret(n: Int, delay: Int, forget: Int): Int {

    println(
        peopleAwareOfSecret(
            4, 1, 3
        )
    )
    val dp = IntArray(n) { 0 }
    dp[0] = 1
    var cur = 0L
    for (i in 0 until n) {
        var prev = dp[i]
        for (k in i + delay until i + forget) {
            if (k >= dp.size) break
            dp[k] += prev
            cur += prev
            cur %= mod
        }
    }

    return cur.toInt()
}

fun countInterestingSubarrays(nums: List<Int>, modulo: Int, k: Int): Long {

    println(
        countInterestingSubarrays(
            listOf(3, 2, 4), 2, 1
        )
    )
    var ans = 0L
    val prefix = IntArray(nums.size) { 0 }
    var c = 0
    for (i in 0 until nums.size) {
        if (nums[i] % modulo == k) prefix[i] = 1
    }
    println(prefix.toList())
    val map = hashMapOf<Int, Int>()
    c = 0
    map[0] = 1
    for (i in 0 until prefix.size) {
        c += prefix[i]
        val mod = c % modulo
        if (!map.containsKey(mod)) {
            map[mod] = 1
        } else {
            val prev = map[mod]!!
            ans += prev
            map[mod] = prev + 1
        }
    }

    return ans
}

fun minimumOperations(num: String): Int {

    var min = Int.MAX_VALUE
    val list = listOf("00", "25", "50", "75")
    for (l in list) {
        min = Math.min(min, deleteNum(num, l))
    }

    if (min == Int.MAX_VALUE) return num.length
    return min
}

fun deleteNum(s: String, delete: String): Int {

    var c = 0
    var at = 1
    for (i in s.length downTo 0) {
        if (delete[at] == s[i]) {
            at--
        } else c++
        if (at == -1) return c
    }
    if (s.contains("0")) return s.length - 1

    return Int.MAX_VALUE
}

fun maximumScore(nums: List<Int>, k: Int): Int {


    println(
        maximumScore(
            listOf(8, 3, 9, 3, 8), 2
        )
    )

    return 0
}

fun minOperations(nums: List<Int>, target: Int): Int {

    println(
        minOperations(
            listOf(1, 2, 8), 7
        )
    )

    var sum = 0
    for (n in nums) {
        sum += n
    }
    if (sum < target) return -1
    if (sum == target) return 0
    var cur = target
    var ans = 0
    val sorted = nums.sortedWith(Collections.reverseOrder())
    for (n in sorted) {
        var c = n
        while (c > cur) {
            ans++
            c /= 2
        }
        cur -= c
    }

    return ans
}


fun longestObstacleCourseAtEachPosition(obstacles: IntArray): IntArray {

    println(
        longestObstacleCourseAtEachPosition(
            intArrayOf(1, 2, 3, 2)
        )
    )

    var list = mutableListOf<Int>()
    val ans = IntArray(obstacles.size) { 0 }
    ans[0] = 1
    list.add(obstacles[0])
    for (i in 0 until obstacles.size) {
        val cur = obstacles[i]
        if (list[list.size - 1] <= cur) {
            ans[i] = list.size + 1
            list.add(cur)
        }
        val right = rightMostIndex(list, cur)

    }

    return obstacles
}

fun rightMostIndex(nums: List<Int>, num: Int): Int {

    var l = 0
    var r = nums.size - 1
    var ans = nums.size - 1
    while (l <= r) {
        val mid = (l + r) / 2
        if (nums[mid] >= num) {
            r = mid - 1
            ans = Math.min(ans, mid)
        } else {
            l = mid + 1
        }
    }

    return ans
}

fun parse(str: String) {

    val withBracket = str.trim()
    val s = withBracket.substring(1, withBracket.length - 1)
    var c = 0
    val builder = StringBuilder()
    var at = 0
    while (at < s.length) {
        if (s[at] == '{') {
            builder.append('{')
            c++
            at++
        } else if (s[at] == '}') {
            builder.append('}')
            c--
            at++
            if (c == 0) {
                val json = JSONObject(builder.toString())
                println(json["asset_id"].toString())
                println(json["pair_id"].toString())
                builder.clear()
                at++
            }
        } else {
            builder.append(s[at])
            at++
        }
    }
}

fun countSubarrays(nums: IntArray, k: Long): Long {

    var r = 0
    var ans = 0L
    var sum = 0
    for (l in 0 until nums.size) {
        while (r < nums.size && (sum * (r - l + 1) < k)) {
            sum += nums[r]
            r++
        }
        ans += (r - l)
        sum -= nums[l]
    }

    return ans
}


class CountIntervals() {

    val obj = TreeRange(Math.pow(10.0, 9.0).toInt() + 1)

    fun add(left: Int, right: Int) {
        obj.update(left, right)
    }

    fun count() = obj.root.freq

}

class TreeRange(val size: Int) {

    var root = Node()

    fun update(l: Int, r: Int) {
        updateHelper(root, 0, size, l, r)
    }

    private fun updateHelper(at: Node, l: Int, r: Int, qL: Int, qR: Int): Int {
        if (r < qL || l > qR) return at.freq
        else if (l == r) {
            at.freq = 1
            return 1
        }
        val mid = (l + r) / 2
        at.init()
        val left = updateHelper(at.left!!, l, mid, qL, qR)
        val right = updateHelper(at.right!!, mid + 1, r, qL, qR)
        at.freq = left + right
        return at.freq
    }

    class Node {
        var freq: Int = 0
        var left: Node? = null
        var right: Node? = null

        fun init() {
            if (left == null) {
                left = Node()
                right = Node()
            }
        }
    }

    fun dfs() {
        dfsHelper(root, 0, size)
    }

    private fun dfsHelper(at: Node?, l: Int, r: Int) {
        if (at == null) return
        println("L : $l  R : $r  Node -> ${at.freq}")
        val mid = (l + r) / 2
        dfsHelper(at.left, l, mid)
        dfsHelper(at.right, mid + 1, r)
    }

}


fun findRightMostIndex(list: List<Int>, num: Int): Int {

    var l = 0
    var r = list.size - 1
    var max = 0
    while (l <= r) {
        val mid = (l + r) / 2
        if (list[mid] >= num) {
            max = Math.max(max, mid)
            l = mid + 1
        } else {
            r = mid - 1
        }
    }

    return max
}

fun maxNonDecreasingLength(nums1: IntArray, nums2: IntArray): Int {

    println(
        maxNonDecreasingLength(
            intArrayOf(2, 3, 1), intArrayOf(1, 2, 1)
        )
    )

    return 0
}

fun minimumOperations(nums: List<Int>): Int {
    val memo = Array(nums.size) { IntArray(4) { -1 } }
    return dpExplore(1, 0, nums.toIntArray(), memo)
}

fun dpExplore(group: Int, at: Int, nums: IntArray, memo: Array<IntArray>): Int {
    if (group == 3) {
        var cur = 0
        for (i in at until nums.size) {
            if (nums[i] <= 2) {
                cur++
            }
        }
        return cur
    }
    if (at == nums.size) return 0
    if (memo[at][group] != -1) return memo[at][group]
    val cur = nums[at]
    if (cur == group) {
        return dpExplore(group, at + 1, nums, memo)
    }
    var min = 100
    //stay at cur group
    val res = 1 + dpExplore(group, at + 1, nums, memo)
    min = Math.min(min, res)
    //increase
    if (cur > group) {
        val inc = dpExplore(cur, at + 1, nums, memo)
        min = Math.min(min, inc)
    } else {
        val skip = 1 + dpExplore(group, at + 1, nums, memo)
        min = Math.min(min, skip)
    }
    memo[at][group] = min

    return min
}

fun countSteppingNumbers(low: String, high: String): Int {


    return 0
}

fun longestEqualSubarray(nums: List<Int>, k: Int): Int {

    var ans = 0
    val freq = hashMapOf<Int, MutableList<Int>>()
    for (i in 0 until nums.size) {
        if (freq[nums[i]] == null) freq[nums[i]] = mutableListOf()
        freq[nums[i]]!!.add(i)
    }
    for ((key, value) in freq) {
        val cur = helper(value.toIntArray(), k)
        ans = Math.max(ans, cur)
    }

    return ans
}

fun helper(indices: IntArray, k: Int): Int {

    var frT = 1
    var frO = 0
    if (indices.size == 1) return 1
    var l = 0
    var ans = 0
    for (r in 1 until indices.size) {
        val dif = indices[r] - indices[r - 1]
        frT++
        if (dif > 1) {
            frO += (dif - 1)
        }
        while (frO > k) {
            frT--
            val dif = indices[l + 1] - indices[l]
            if (dif > 1) {
                frO -= (dif - 1)
            }
            l++
        }
        ans = Math.max(ans, frT)
    }

    return ans
}

fun helper(num: Int, nums: IntArray, k: Int): Int {

    var frT = 0
    var frO = 0
    var l = 0
    var ans = 0
    for (r in 0 until nums.size) {
        if (nums[r] == num) {
            frT++
        } else frO++
        while (frO > k) {
            if (nums[l] == num) {
                frT--
            } else {
                frO--
            }
            l++
        }
        val dist = r - l + 1 - frO
        ans = Math.max(ans, dist)
    }

    return ans
}

fun minimumSum(n: Int, target: Int): Int {

    val set = mutableSetOf<Int>()
    var cur = 1
    var size = 0
    var ans = 0
    while (size != n) {
        if (cur >= target) {
            ans += cur
            size++
        } else {
            if (!set.contains(cur)) {
                val right = target - cur
                set.add(right)
                size++
                ans += cur
            }
        }
        cur++
    }
    return ans
}


fun dp(sum: Int, at: Int, nums: IntArray): Int {

    if (sum == 0) return 0
    if (sum < 0 || at == nums.size) return Int.MAX_VALUE
    var ans = dp(sum, at + 1, nums)
    if (sum - nums[at] >= 0) {
        val cur = dp(sum - nums[at], at + 1, nums)
        if (cur != Int.MAX_VALUE) {
            ans = Math.min(ans, cur)
        }
    }
    if (nums[at] > 1) {
        val cur = dp(sum - (nums[at] / 2), at + 1, nums)
        if (cur != Int.MAX_VALUE) {
            ans = Math.min(ans, cur + 1)
        }
    }

    return ans
}

fun unSetRightMostBit(n: Int): Int {
    return n and (n - 1)
}

fun closestRoom(rooms: Array<IntArray>, queries: Array<IntArray>): IntArray {

    //roomID,size
    val answer = IntArray(queries.size) { -1 }
    val queryList = Array(queries.size) { Query(0, 0, 0) }
    for (i in 0 until queries.size) {
        queryList[i] = Query(i, queries[i][1], queries[i][0])
    }
    val sortedQuery = queryList.sortedWith(object : Comparator<Query> {
        override fun compare(o1: Query, o2: Query): Int {
            return o2.atLeastSize - o1.atLeastSize
        }
    })
    rooms.sortWith(object : Comparator<IntArray> {
        override fun compare(o1: IntArray, o2: IntArray): Int {
            return o2[1] - o2[0]
        }
    })
    var at = 0
    val treeSet = TreeSet<Int>()
    for (i in 0 until sortedQuery.size) {
        val (loc, atLeastSize, prefID) = sortedQuery[i]
        while (at < rooms.size && rooms[at][1] >= atLeastSize) {
            treeSet.add(rooms[at][0])
            at++
        }
        val floor = treeSet.floor(prefID)
        val ceil = treeSet.ceiling(prefID)
        var min = Int.MAX_VALUE
        if (floor != null) {
            min = prefID - floor
            answer[loc] = floor
        }
        if (ceil != null) {
            if (ceil - prefID <= min) {
                answer[loc] = ceil
            }
        }
    }

    return answer
}

data class Query(val at: Int, val atLeastSize: Int, val prefID: Int)

fun maximizeTheProfit(n: Int, offers: List<List<Int>>): Int {


    println(
        maximizeTheProfit(
            5, listOf(
                listOf(0, 0, 1), listOf(0, 2, 2), listOf(1, 3, 2)
            )
        )
    )


    val ends = Array(n) { mutableListOf<List<Int>>() }
    for (o in offers) {
        ends[o[1]].add(o)
    }
    val dp = IntArray(n + 1) { 0 }
    for (i in 1..n) {
        dp[i] = dp[i - 1]
        for (off in ends[i - 1]) {
            dp[i] = Math.max(dp[i], dp[off[0]] + off[2])
        }
    }

    return dp[n]
}

fun backtrackingHelper(cur: Int, size: Int, sum: Int, used: MutableSet<Int>, k: Int, max: Int, list: MutableList<Int>) {
    if (size == 0) {
        ans = Math.min(ans, sum)
        return
    }
    if (cur > max) return
    if (used.contains(cur)) {
        return backtrackingHelper(cur + 1, size, sum, used, k, max, list)
    }
    used.add(k - cur)
    backtrackingHelper(cur + 1, size - 1, sum + cur, used, k, max, list)
    used.remove(k - cur)
    backtrackingHelper(cur + 1, size, sum, used, k, max, list)
}

var ans = Int.MAX_VALUE

fun dp(prevGroup: Int, at: Int, nums: List<Int>): Int {

    if (prevGroup == 3) {
        var c = 0
        for (i in at until nums.size) {
            if (nums[i] <= 2) c++
        }
        return c
    }
    if (at == nums.size) return 0
    if (nums[at] == prevGroup) return dp(prevGroup, at + 1, nums)
    var min = 1000
    if (nums[at] > prevGroup) {
        val nothing = 1 + dp(prevGroup, at + 1, nums)
        min = Math.min(min, nothing)
    }
    if (nums[at] < prevGroup) {
        val res = dp(nums[at], at + 1, nums)
        min = Math.min(min, res)
    }
    var inc = dp(prevGroup + 1, at + 1, nums)
    if (nums[at] < prevGroup) inc++
    min = Math.min(min, inc)

    return min
}

suspend fun call() {
    suspendCoroutine { continuation ->
        continuation.resume("Hello")
    }
}

fun <T, R, D> findElement(hello: T): T {
    println(hello)
    return hello
}

data class Hello(
    val name: String, val surName: String
)

fun putMarbles(weights: IntArray, k: Int): Long {

    return 0L
}

fun countQuadruplets(nums: IntArray): Long {

    println(
        countQuadruplets(
            intArrayOf(1, 3, 2, 4, 5)
        )
    )

    return 0L
}

fun findMaximumElegance(items: Array<IntArray>, k: Int): Long {

    println(
        findMaximumElegance(
            arrayOf(
                intArrayOf(3, 1), intArrayOf(3, 1), intArrayOf(2, 2), intArrayOf(5, 3)
            ), 3
        )
    )


    return 0L
}

fun minSumSquareDiff(nums1: IntArray, nums2: IntArray, k1: Int, k2: Int): Long {
    val diff = IntArray(nums1.size)
    for (i in 0 until nums1.size) {
        diff[i] = Math.abs(nums1[i] - nums2[i])
    }
    val max = diff.max()
    val arr = IntArray(max + 1) { 0 }
    for (d in diff) {
        arr[d]++
    }
    var minus = k1 + k2
    for (i in max downTo 1) {
        val cur = Math.min(arr[i], minus)
        arr[i] -= cur
        arr[i - 1] += cur
        minus -= cur
        if (cur == 0) break
    }
    var ans = 0L
    for (i in 1 until arr.size) {
        ans += (i * i) * arr[i]
    }
    return ans
}

fun minimumMoney(transactions: Array<IntArray>): Long {

    println(
        minimumMoney(
            arrayOf(
                intArrayOf(2, 1), intArrayOf(5, 0), intArrayOf(4, 2)
            )
        )
    )

    //cost,cashBack
    val sorted = transactions.sortedWith(object : Comparator<IntArray> {
        override fun compare(o1: IntArray, o2: IntArray): Int {
            val (cost1, cash1) = o1
            val (cost2, cash2) = o2
            val d1 = cost1 - cash1
            //3,0 -> 0
            //0,3 -> -3
            val d2 = cost2 - cash2
            if (d1 == d2) {
                return cost2 - cost1
            }
            return d2 - d1
        }
    }).toTypedArray()
    sorted.forEach {
        println(it.toList())
    }
    var l = 1L
    var r = Long.MAX_VALUE - 10
    var ans = Long.MAX_VALUE
    while (l <= r) {
        val mid = (r + l) / 2
        if (isEnough(mid, sorted)) {
            ans = Math.min(ans, mid)
            r = mid - 1
        } else l = mid + 1
    }
    return ans
}

fun isEnough(mid: Long, sorted: Array<IntArray>): Boolean {
    var cur = mid
    for ((cost, cash) in sorted) {
        if (cost > cur) return false
        cur -= cost
        cur += cash
    }
    return true
}

fun minAbsoluteDifference(nums: List<Int>, x: Int): Int {

    val treeMap = TreeMap<Int, Int>()
    //(i-j)>=x
    for (i in x until nums.size) {
        treeMap[nums[i]] = treeMap.getOrDefault(nums[i], 0) + 1
    }
    var ans = Int.MAX_VALUE
    for (i in 0 until nums.size) {
        val cur = nums[i]
        if (treeMap.floorKey(cur) != null) {
            val dif = treeMap.floorKey(cur)
            ans = Math.min(ans, dif)
        }
        if (treeMap.ceilingKey(cur) != null) {
            val dif = treeMap.ceilingKey(cur)
            ans = Math.min(ans, dif)
        }
        if (i + x < nums.size) {
            val delete = nums[i + x]
            treeMap[delete] = treeMap.getOrDefault(delete, 0) - 1
            if (treeMap[delete] == 0) treeMap.remove(delete)
        }
    }
    if (ans == Int.MAX_VALUE) return -1

    return ans
}

fun reverse(head: ListNode?): ListNode? {
    var prev: ListNode? = null
    var cur = head
    while (cur != null) {
        val next_node = cur.next
        cur.next = prev
        prev = cur
        cur = next_node
    }
    return prev
}

fun doubleIt(head: ListNode?): ListNode? {
    val rev1 = reverse(head)
    val ans = doubleItHelper(rev1)
    val rev2 = reverse(ans)
    return rev2
}

fun doubleItHelper(head: ListNode?): ListNode? {
    val ans = ListNode(-1)
    var a = ans
    var cur = head
    var remain = 0
    while (cur != null) {
        val value = cur.value + cur.value + remain
        var next: ListNode
        if (value >= 10) {
            next = ListNode("$value"[1] - '0')
        } else next = ListNode(value)
        if (value >= 10) remain = 1
        a.next = next
        a = a.next!!
        cur = cur.next
    }
    if (remain == 1) {
        a.next = ListNode(1)
    }
    return ans.next
}

class ListNode(val value: Int) {
    var next: ListNode? = null
}

fun show(node: ListNode?) {
    var cur = node
    while (cur != null) {
        print(cur.value.toString() + "  ")
        cur = cur.next
    }
}

fun makeListNode(arr: IntArray): ListNode {
    val head = ListNode(-1)
    var cur = head
    for (i in 0 until arr.size) {
        val next = ListNode(arr[i])
        cur.next = next
        cur = cur.next!!
    }
    return head.next!!
}

fun maximumSafenessFactor(grid: List<List<Int>>): Int {

    val board = Array(grid.size) { IntArray(grid.size) { Int.MAX_VALUE } }
    val queue = LinkedList<State>()
    for (i in 0 until grid.size) {
        for (j in 0 until grid[i].size) {
            if (grid[i][j] == 1) {
                queue.add(State(i, j, i, j))
                board[i][j] = 0
            }
        }
    }
    val dirs = arrayOf(
        intArrayOf(0, 1), intArrayOf(1, 0), intArrayOf(0, -1), intArrayOf(-1, 0)
    )
    while (queue.isNotEmpty()) {
        val size = queue.size
        for (i in 0 until size) {
            val poll = queue.poll()
            for (dir in dirs) {
                val nI = dir[0] + poll.curI
                val nJ = dir[1] + poll.curJ
                if (nI < 0 || nJ < 0 || nI == grid.size || nJ == grid.size) continue
                val dist = calDist(poll.i, poll.j, nI, nJ)
                if (dist < board[nI][nJ]) {
                    board[nI][nJ] = dist
                    queue.add(State(poll.i, poll.j, nI, nJ))
                }
            }
        }
    }
    val visited = Array(grid.size) { BooleanArray(grid.size) { false } }
    //score,i, j
    var ans = board[0][0]
    val maxQueue = PriorityQueue(object : Comparator<IntArray> {
        override fun compare(o1: IntArray, o2: IntArray): Int {
            return o2[0] - o1[0]
        }
    })
    maxQueue.add(intArrayOf(ans, 0, 0))
    while (maxQueue.isNotEmpty()) {
        val poll = maxQueue.poll()
        visited[poll[1]][poll[2]] = true
        ans = Math.min(ans, poll[0])
        if (poll[1] == grid.size - 1 && poll[2] == grid.size - 1) break
        for (dir in dirs) {
            val nI = poll[1] + dir[0]
            val nJ = poll[2] + dir[1]
            if (nI < 0 || nJ < 0 || nI == grid.size || nJ == grid.size || visited[nI][nJ]) continue
            maxQueue.add(intArrayOf(board[nI][nJ], nI, nJ))
            visited[nI][nJ] = true
        }
    }

    return ans
}

fun calDist(x: Int, y: Int, i: Int, j: Int): Int {
    return Math.abs(x - i) + Math.abs(y - j)
}

class State(val i: Int, val j: Int, val curI: Int, val curJ: Int)

fun bestTeamScore(scores: IntArray, ages: IntArray): Int {


    return 0
}

sealed interface Stage {

    data object FirstStage : Stage

    data object SecondStage : Stage

    data object ThirdStage : Stage

    data object FourthStage : Stage

}

sealed class HttpError(val code: Int)

object UnAuthorized : HttpError(2)
object NotFound : HttpError(1)

enum class HttpErrorEnum(val code: Int) {
    Authorized(3), NotFound(3)
}



