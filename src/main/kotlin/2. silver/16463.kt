fun main() {
    val N = readln().toInt()
    var year = 2019
    var month = 1
    var day = 4
    val monthDay = intArrayOf(0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31)
    var cnt = 0
    while (true) {
        day += 7
        if ((year % 400 == 0 || year % 100 != 0 && year % 4 == 0) && (month == 2)) {
            if (day > 29) {
                day -= 29
                month++
            }
        } else if (day > monthDay[month]) {
            day -= monthDay[month]
            month++
        }
        if (month > 12) {
            year++
            month = 1
        }
        if (year > N) break
        if (day == 13) cnt++
    }
    println(cnt)
}
