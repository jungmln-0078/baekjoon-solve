import kotlin.math.round

fun main() {
    val N = readln().toInt()
    val nums = mutableListOf<Int>()
    for (i: Int in 1..N) {
        nums.add(readln().toInt())
    }
    nums.sort()
    println(round(nums.average()).toInt())
    println(nums[nums.size / 2])
    val sorted = nums.groupBy { it }.toList().sortedWith(compareBy({ it.second.size }, { it.first }))
    val choiBin = sorted.filter { c -> c.second.size == sorted.maxOf { it.second.size } }
    println(if (choiBin.size > 1) choiBin[1].first else choiBin[0].first)
    println(nums.max() - nums.min())
}
