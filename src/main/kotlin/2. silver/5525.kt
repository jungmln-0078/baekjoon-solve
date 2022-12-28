fun main() {
    val N = readln().toInt()
    readln()
    val S = readln()
    val P = makeIOIOI(N)
    println(kmp5525(S, P).size)
}

fun makeIOIOI(n: Int): String {
    val result = StringBuilder()
    for (i: Int in 1..1 + n * 2) {
        if (i % 2 == 1) result.append("I")
        else result.append("O")
    }
    return result.toString()
}

fun kmp5525(str: String, p: String): MutableList<Int> {
    val result = mutableListOf<Int>()
    val pi = pi5525(p)
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

fun pi5525(p: String): MutableList<Int> {
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
