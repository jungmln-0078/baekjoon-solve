fun main() {
    val name = readln()
    val N = readln().toInt()
    val list = mutableListOf<String>()
    val chance = mutableListOf<Int>()
    for (i: Int in 1..N) {
        list.add(readln())
    }
    list.sort()
    val nl = name.count{ it == 'L' }
    val no = name.count{ it == 'O' }
    val nv = name.count{ it == 'V' }
    val ne = name.count{ it == 'E' }
    for (i: Int in list.indices) {
        var l = nl
        var o = no
        var v = nv
        var e = ne
        for (c: Char in list[i]) {
            when (c) {
                'L' -> l++
                'O' -> o++
                'V' -> v++
                'E' -> e++
            }
        }
        chance.add(((l + o) * (l + v) * (l + e) * (o + v) * (o + e) * (v + e)) % 100)
    }
    val max = chance.max()
    println(list[chance.indexOfFirst { it == max }])
}
