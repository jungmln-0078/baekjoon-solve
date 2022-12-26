import kotlin.math.max

fun main() {
    val str1 = readln()
    val str2 = readln()
    println(longestCommonSubsequence17218(str1, str2))
}

fun longestCommonSubsequence17218(str1: String, str2: String): String {
    val LCS = MutableList(str2.length + 1) { MutableList<Int?>(str1.length + 1) { null } }
    val result = StringBuilder("")
    for (i: Int in 0..str2.length) {
        LCS[i][0] = 0
    }
    for (j: Int in 0..str1.length) {
        LCS[0][j] = 0
    }
    for (i: Int in 1..str2.length) {
        for (j: Int in 1..str1.length) {
            if (str2[i - 1] != str1[j - 1]) LCS[i][j] = max(LCS[i - 1][j]!!, LCS[i][j - 1]!!)
            else LCS[i][j] = LCS[i - 1][j - 1]!! + 1
        }
    }
    var i = str2.length
    var j = str1.length
    while (true) {
        val v = LCS[i][j]
        if (v == 0) break
        when (v) {
            LCS[i - 1][j] -> i--
            LCS[i][j - 1] -> j--
            else -> {
                result.append(str2[i - 1])
                i--
                j--
            }
        }
    }
    return result.reversed().toString()
}
