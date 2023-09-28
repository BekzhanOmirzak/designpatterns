import java.util.*

private fun readInt() = readLine().toString().toInt()
private fun readString() = readLine().toString()

private fun readListInt() = readString().split(" ").map { it.toInt() }

fun main() {

    val (scene, people) = readListInt()
    val treeMap = TreeMap<Int, MutableList<Int>>()
    repeat(people) {
        val (l, r, need) = readListInt()
        if (treeMap[l] == null)
            treeMap[l] = mutableListOf()
        if (treeMap[r + 1] == null)
            treeMap[r + 1] = mutableListOf()
        treeMap[l]!!.add(need)
        treeMap[r + 1]!!.add(-need)
    }

    var prev = -1
    val freq = TreeMap<Int, Int>()
    var ans = 0L

    for ((key, values) in treeMap) {
        if (freq.isNotEmpty() && freq.lastKey() != null) {
            val big = freq.lastKey()
            val dif = key - prev
            ans += (big * dif * 1L)
        }
        for (n in values) {
            if (n > 0)
                freq[n] = freq.getOrDefault(n, 0) + 1
            else {
                freq[n * (-1)] = freq.getOrDefault(n * (-1), 0) - 1
                if (freq[n * (-1)] == 0)
                    freq.remove(n * (-1))
            }
        }
        prev = key
    }

    println(ans)

}