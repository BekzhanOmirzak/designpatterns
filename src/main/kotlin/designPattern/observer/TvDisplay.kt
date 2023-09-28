import java.util.*

private fun readInt() = readLine().toString().toInt()
private fun readString() = readLine().toString()

private fun readListInt() = readString().split(" ").map { it.toInt() }

fun main() {


    val (r, c) = readListInt()
    val board = Array(r) { CharArray(c) { ' ' } }
    repeat(r) { i ->
        val cur = readString().toCharArray()
        board[i] = cur
    }

    for (b in board)
        println(b.toList())

    var max = 0
    val dirs = arrayOf(
        intArrayOf(1, 0),
        intArrayOf(0, 1),
        intArrayOf(-1, 0),
        intArrayOf(0, -1)
    )

    var ans = intArrayOf(-1, -1)
    for (i in 0 until board.size) {
        for (j in 0 until board[i].size) {
            if (board[i][j] == '.') {
                val queue = LinkedList<IntArray>()
                queue.add(intArrayOf(i, j))
                var cur = 0
                while (queue.isNotEmpty()) {
                    val size = queue.size
                    for (k in 0 until size) {
                        val p = queue.poll()
                        if (board[p[0]][p[1]] == 'B') {
                            cur++
                        }
                        board[p[0]][p[1]] = 'W'
                        for (dir in dirs) {
                            val nI = dir[0] + p[0]
                            val nJ = dir[1] + p[1]
                            if (nI in 0 until r && nJ in 0 until c && board[nI][nJ] != 'W') {
                                queue.add(intArrayOf(nI, nJ))
                            }
                        }
                    }
                }

                if (cur >= max) {
                    max = cur
                    ans = intArrayOf(i + 1, j + 1)
                }

            }
        }
    }

    println(ans.toList())

}