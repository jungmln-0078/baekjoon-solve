fun main() {
    val N = readln().toInt()
    var result = N
    for (i: Int in 1..N) {
        val input = readln()
        val group = mutableListOf<Char>()
        for (idx: Int in input.indices) {
            if (idx - 1 >= 0) {
                if (group.contains(input[idx]) && input[idx] != input[idx - 1]) {
                    result--
                    break
                }
            }
            group.add(input[idx])
        }
    }
    println(result)
}
