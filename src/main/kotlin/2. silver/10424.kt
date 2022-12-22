fun main() {
    val N = readln().toInt()
    val gimal = readln().split(" ").map { it.toInt() }
    for (i: Int in gimal.indices) {
        val B = gimal.filterIndexed{ index, rank -> rank < gimal[i] && index > i}.size
        val C = gimal.filterIndexed{ index, rank -> rank > gimal[i] && index < i}.size
        println(B - C)
    }
}
