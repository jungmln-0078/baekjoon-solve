fun main() {
    val lineCount = readln().toInt()
    val points: MutableList<Pair<Int, Int>> = mutableListOf()
    for (i: Int in 1..lineCount) {
        val point = readln().split(" ")
        points.add(point[0].toInt() to point[1].toInt())
    }
    points.sortWith(compareBy({ it.second }, { it.first }))
    println(points.joinToString("\n") { p -> "${p.first} ${p.second}" })
}
