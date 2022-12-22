fun main() {
    val inputCount = readln().split(" ")
    val deutdoCount = inputCount[0].toInt()
    val bodoCount = inputCount[1].toInt()
    val deutdo = mutableListOf<String>()
    val bodo = mutableListOf<String>()
    for (i: Int in 1..deutdoCount) {
        deutdo.add(readln())
    }
    for (i: Int in 1..bodoCount) {
        bodo.add(readln())
    }
    val result = (deutdo + bodo).groupBy { it }.filter { it.value.size > 1 }.flatMap { it.value }.distinct()
    println(result.size)
    println(result.sorted().joinToString("\n"))
}
