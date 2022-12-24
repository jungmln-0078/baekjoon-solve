fun main() {
    val input = readln().split(" ")
    val N = input[0].toInt()
    val M = input[1].toInt()
    val nameToId = hashMapOf<String, Int>()
    val idToName = mutableListOf<String>()
    for (i: Int in 1..N) {
        val name = readln()
        nameToId[name] = i
        idToName.add(name)
    }
    for (i: Int in 1..M) {
        val search = readln()
        if (search.toIntOrNull() == null) {
            println(nameToId[search])
        } else {
            println(idToName[search.toInt() - 1])
        }
    }
}
