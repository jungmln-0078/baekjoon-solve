fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    val nums = readln().split(" ").map { it.toInt() }.sorted()
    val list = mutableListOf<Int>()
    fun prt(depth: Int) {
        if (depth == m) {
            println(list.joinToString(" "))
            return
        }
        for (i: Int in 0 until n) {
            if (!list.contains(nums[i])) {
                list.add(nums[i])
                prt(depth + 1)
                list.removeLast()
            }
        }
    }
    prt(0)
}
