fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    val list = mutableListOf<Int>()
    fun prt(depth: Int) {
        if (depth == m) {
            println(list.joinToString(" "))
            return
        }
        for (i: Int in 1..n) {
            if (!list.contains(i)) {
                list.add(i)
                prt(depth + 1)
                list.removeLast()
            }

        }
    }
    prt(0)
}
