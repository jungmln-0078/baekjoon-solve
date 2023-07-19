fun main() {
    val (N, M, R) = readln().split(" ").map { it.toInt() }
    var arr = mutableListOf<MutableList<Int>>()
    for (i: Int in 1..N) {
        arr.add(readln().split(" ").map { it.toInt() }.toMutableList())
    }
    val cmd = readln().split(" ")
    for (c in cmd) {
        when (c) {
            "1" -> arr.reverse()
            "2" -> arr.forEach { it.reverse() }
            "3" -> {
                val curM = arr[0].size
                val curN = arr.size
                for (j: Int in 0 until curM) {
                    val newRow = mutableListOf<Int>()
                    for (i: Int in curN - 1 downTo 0) {
                        newRow.add(arr[i][j])
                    }
                    arr.add(newRow)
                }
                arr = arr.subList(curN, arr.size)
            }
            "4" -> {
                val curM = arr[0].size
                val curN = arr.size
                for (j: Int in curM - 1 downTo 0) {
                    val newRow = mutableListOf<Int>()
                    for (i: Int in 0 until curN) {
                        newRow.add(arr[i][j])
                    }
                    arr.add(newRow)
                }
                arr = arr.subList(curN, arr.size)
            }
            "5" -> {
                val curM = arr[0].size
                val curN = arr.size
                val offsetM = curM / 2
                val offsetN = curN / 2
                for (m: Int in 0..offsetM step offsetM) {
                    for (n: Int in 0 until offsetN) {
                        val newRow = mutableListOf<Int>()
                        newRow.addAll(arr[offsetN + n].subList(m, offsetM + m))
                        newRow.addAll(arr[n].subList(m, offsetM + m))
                        arr.add(newRow)
                    }
                }
                arr = arr.subList(curN, arr.size)
            }
            "6" -> {
                val curM = arr[0].size
                val curN = arr.size
                val offsetM = curM / 2
                val offsetN = curN / 2
                for (m: Int in offsetM downTo 0 step offsetM) {
                    for (n: Int in 0 until offsetN) {
                        val newRow = mutableListOf<Int>()
                        newRow.addAll(arr[n].subList(m, offsetM + m))
                        newRow.addAll(arr[offsetN + n].subList(m, offsetM + m))
                        arr.add(newRow)
                    }
                }
                arr = arr.subList(curN, arr.size)
            }
        }
    }
    println(arr.joinToString("\n") { it.joinToString(" ") })
}
