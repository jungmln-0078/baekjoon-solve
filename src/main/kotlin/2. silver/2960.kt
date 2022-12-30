import kotlin.math.sqrt
var list2960 = mutableListOf<Int>()
var delList2960 = mutableListOf<Int>()
fun main() {
    val input = readln().split(" ")
    val N = input[0].toInt()
    val K = input[1].toInt()
    list2960 = (2..N).toMutableList()
    for (i: Int in list2960) {
        if (isPrimeNumber(i)) {
            if (!delList2960.contains(i)) delList2960.add(i)
            for (j: Int in i * 2..N step i) {
                if (!delList2960.contains(j)) delList2960.add(j)
                else continue
            }
        }
    }
    println(delList2960[K - 1])
}

fun isPrimeNumber(n: Int): Boolean {
    when (n) {
        1 -> return false
        2 -> return true
        else -> {
            for (i: Int in 2..sqrt(n.toDouble()).toInt()) {
                if (n % i == 0) return false
            }
            return true
        }
    }
}
