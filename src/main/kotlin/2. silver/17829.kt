fun main() {
    val N = readln().toInt()
    val matrix = MutableList(N) { mutableListOf<Int>() }
    for (i: Int in 0 until N) {
        matrix[i] = readln().split(" ").map { it.toInt() }.toMutableList()
    }

    fun dq(xOffset: Int, yOffset: Int, n: Int): Int {
        val list = mutableListOf<Int>()
        for (x: Int in xOffset..xOffset + n / 2 step n / 2) {
            for (y: Int in yOffset..yOffset + n / 2 step n / 2) {
                if (n == 2) list.add(matrix[x][y]) else list.add(dq(x, y, n / 2))
            }
        }
        return list.sortedDescending()[1]
    }

    println(dq(0, 0, N))

}
