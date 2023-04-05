fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    val nums = readln().split(" ").map { it.toInt() }.sorted()
    val list = mutableListOf<Int>()
    fun prt(idx: Int, depth: Int) {
        if (depth == m) {
            println(list.joinToString(" "))
            return
        }
        for (i: Int in idx until n) {
            list.add(nums[i])
            prt(i, depth + 1)
            list.removeLast()
        }
    }
    prt(0, 0)
}
