fun main() {
    val (N, M) = readln().split(" ").map { it.toInt() }
    val list = readln().split(" ").map { it.toInt() }.toSet().sorted()
    val stack = mutableListOf<Int>()

    fun solution(idx: Int, digit: Int) {
        if (digit == M) {
            println(stack.joinToString(" "))
            return
        }

        for (i: Int in idx .. list.lastIndex) {
            stack.add(list[i])
            solution(i, digit + 1)
            stack.removeLast()
        }
    }
    solution(0, 0)
}
