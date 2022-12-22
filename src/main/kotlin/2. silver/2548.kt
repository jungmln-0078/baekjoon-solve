import kotlin.math.absoluteValue

fun main() {
    readln()
    val nums = readln().split(" ").map { it.toInt() }.sorted()
    val results = mutableListOf<Pair<Int, Int>>()
    val daePwo = nums.distinct()
    for (j: Int in daePwo) {
        var sum = 0
        for (i: Int in nums) {
            sum += (i - j).absoluteValue
        }
        results.add(j to sum)
    }
    results.sortWith(compareBy ({ it.second }, { it.first }))
    println(results.first().first)
}
