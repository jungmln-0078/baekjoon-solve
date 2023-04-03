import kotlin.math.abs

fun main() {
    val (p, m) = readln().split(" ").map { it.toInt() }
    val rooms: MutableList<MutableList<Pair<Int, String>>> = mutableListOf()
    for (i: Int in 1..p) {
        val input = readln().split(" ")
        val newPlayer = input[0].toInt() to input[1]
        val joinableRoom = rooms.indexOfFirst { it.size == 0 || it.size < m && abs(it.first().first - newPlayer.first) <= 10 }
        if (joinableRoom == -1) {
            rooms.add(mutableListOf(newPlayer))
        } else {
            rooms[joinableRoom].add(newPlayer)
        }
    }

    for (i: Int in rooms.indices) {
        rooms[i].sortWith(compareBy { it.second })
        if (rooms[i].size < m) {
            println("Waiting!")
        } else {
            println("Started!")
        }
        println(rooms[i].joinToString("\n") { "${it.first} ${it.second}" })
    }
}
