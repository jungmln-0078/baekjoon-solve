fun main() {
    val input = readln().split(" ")
    val N = input[0].toInt()
    val jimin = input[1].toInt()
    val hansu = input[2].toInt()

    println(solution(N, jimin, hansu))
}

fun solution(N: Int, jimin: Int, hansu: Int): Int {
    var list = (1..N).toMutableList()
    var round = 1
    while (list.size > 1) {
        val newList = mutableListOf<Int>()
        for (i: Int in list.indices step 2) {
            if (i + 1 > list.lastIndex) {
                newList.add(list[i])
                break
            } else {
                val chk1jimin = list[i] == jimin
                val chk2jimin = list[i + 1] == jimin
                val chk1hansu = list[i] == hansu
                val chk2hansu = list[i + 1] == hansu
                if ((chk1jimin || chk1hansu) && (chk2jimin || chk2hansu)) return round
                else if (chk1jimin || chk1hansu) newList.add(list[i])
                else if (chk2jimin || chk2hansu) newList.add(list[i + 1])
                else newList.add(list[i])
            }
        }
        list = newList
        round++
    }
    return if(list.size < 2) -1 else round
}
