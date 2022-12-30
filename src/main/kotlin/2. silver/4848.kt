fun main() {
    val N = readln().toInt()
    val dp = mutableMapOf<Int, String>()
    dp[0] = "{}"
    dp[1] = "{{}}"
    for (d: Int in 2..15) {
        dp[d] = "{${dp.entries.filter { it.key < d }.joinToString(",") { it.value }}}"
    }
    var a = ""
    var b: String
    for (i: Int in 1..N * 2) {
        if (i % 2 == 1) {
            a = readln()
        } else {
            b = readln()
            val aNum = dp.entries.find { it.value == a }!!.key
            val bNum = dp.entries.find { it.value == b }!!.key
            println(dp[aNum + bNum])
        }
    }
}
