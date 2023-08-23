fun main() {
    val N = readln().toInt()
    val nums = mutableListOf<List<Int>>()
    val maxdp = mutableMapOf<Pair<Int, Int>, Int>()
    val mindp = mutableMapOf<Pair<Int, Int>, Int>()
    for (i: Int in 1..N) {
        nums.add(readln().split(" ").map { it.toInt() })
    }
    maxdp[0 to 0] = nums[0][0]
    maxdp[0 to 1] = nums[0][1]
    maxdp[0 to 2] = nums[0][2]
    mindp[0 to 0] = nums[0][0]
    mindp[0 to 1] = nums[0][1]
    mindp[0 to 2] = nums[0][2]
    for (i: Int in 1 until N) {
        maxdp[i to 0] = nums[i][0] + maxOf(maxdp[i - 1 to 0]!!, maxdp[i - 1 to 1]!!)
        maxdp[i to 1] = nums[i][1] + maxOf(maxdp[i - 1 to 0]!!, maxdp[i - 1 to 1]!!, maxdp[i - 1 to 2]!!)
        maxdp[i to 2] = nums[i][2] + maxOf(maxdp[i - 1 to 1]!!, maxdp[i - 1 to 2]!!)
        mindp[i to 0] = nums[i][0] + minOf(mindp[i - 1 to 0]!!, mindp[i - 1 to 1]!!)
        mindp[i to 1] = nums[i][1] + minOf(mindp[i - 1 to 0]!!, mindp[i - 1 to 1]!!, mindp[i - 1 to 2]!!)
        mindp[i to 2] = nums[i][2] + minOf(mindp[i - 1 to 1]!!, mindp[i - 1 to 2]!!)
    }
    println(maxOf(maxdp[N - 1 to 0]!!, maxdp[N - 1 to 1]!!, maxdp[N - 1 to 2]!!).toString() + " " + minOf(mindp[N - 1 to 0]!!, mindp[N - 1 to 1]!!, mindp[N - 1 to 2]!!))
}
