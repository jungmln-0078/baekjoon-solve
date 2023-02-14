fun main() {
    val T = readln()
    val P = readln()
    val kmp = kmp1786(T, P)
    println(kmp.size)
    println(kmp.map { it + 1 }.joinToString(" "))
}

fun kmp1786(str: String, p: String): MutableList<Int> {
    val result = mutableListOf<Int>()
    val pi = pi1786(p)
    var j = 0
    for (i: Int in 0 ..str.lastIndex) {
        while (j > 0 && str[i] != p[j]) {
            j = pi[j - 1]
        }
        if (str[i] == p[j]) {
            if (j == p.lastIndex) {
                result.add(i - p.length + 1)
                j = pi[j]
            } else {
                j++
            }
        }
    }
    return result
}

fun pi1786(p: String): MutableList<Int> {
    var j = 0
    val result = MutableList(p.length) { 0 }
    for (i: Int in 1..p.lastIndex) {
        while (j > 0 && p[i] != p[j]) {
            j = result[j - 1]
        }
        if (p[i] == p[j]) {
            result[i] = ++j
        }
    }
    return result
}
