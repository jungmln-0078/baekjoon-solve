val N24460 = readln().toInt()
val numbers = mutableListOf<List<Int>>()
fun main() {
    for (i: Int in 1..N24460) {
        numbers.add(readln().split(" ").map { it.toInt() })
    }
    println(dq24460(N24460, 0, 0))
}

fun dq24460(size: Int, xOffset: Int, yOffset: Int): Int {
    return if (size == 1) {
        numbers[xOffset][yOffset]
    } else {
        listOf(
            dq24460(size / 2, xOffset, yOffset),
            dq24460(size / 2, xOffset + size / 2, yOffset),
            dq24460(size / 2, xOffset, yOffset + size / 2),
            dq24460(size / 2, xOffset + size / 2, yOffset + size / 2)
        ).sorted()[1]
    }
}
