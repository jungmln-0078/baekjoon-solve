fun main() {
    val input = readln().split(" ")
    val E = input[0].toInt()
    val S = input[1].toInt()
    val M = input[2].toInt()
    var e = 1
    var s = 1
    var m = 1
    var year = 1
    while (true) {
        if (e == E && s == S && m == M) {
            println(year)
            break
        }
        e++
        s++
        m++
        if (e > 15) e = 1
        if (s > 28) s = 1
        if (m > 19) m = 1
        year++
    }
}
