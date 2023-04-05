fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    val list = mutableListOf<Int>()
    fun prt(num: Int, depth: Int) {
        if (depth == m) {
            println(list.joinToString(" "))
            return
        }
        for (i: Int in num..n) {
            list.add(i)
            prt(i,depth + 1)
            list.removeLast()
        }
    }
    prt(1, 0)
}
