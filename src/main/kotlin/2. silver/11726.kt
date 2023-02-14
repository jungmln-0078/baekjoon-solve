val dp11726 = mutableMapOf<Int, Long>()

fun main() {
    dp11726[0] = 1
    dp11726[1] = 1
    dp11726[2] = 2
    println(d11726(readln().toInt()) % 10007)
}

fun d11726(i: Int): Long {
    if (dp11726[i] != null) return dp11726[i]!!
    dp11726[i] = (d11726(i - 1) + d11726(i - 2)) % 10007
    return dp11726[i]!!
}
