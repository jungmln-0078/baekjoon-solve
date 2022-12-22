fun main() {
    val lineCount = readln().toInt()
    val members = mutableListOf<Triple<Int, String, Int>>()
    for (line: Int in 1..lineCount) {
        val member = readln().split(" ")
        members.add(Triple(member[0].toInt(), member[1], members.size + 1))
    }
    members.sortWith(compareBy({ it.first }, { it.third }))
    println(members.joinToString("\n") { "${it.first} ${it.second}" })
}
