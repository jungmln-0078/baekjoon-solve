fun main() {
    val N = readln().toInt()
    var count = 0
    var i = 666
    var iTemp: Int
    while (true) {
        iTemp = i
        while(i / 10 > 0) {
            if (i % 1000 == 666) {
                count++
                break
            } else {
                i /= 10
            }
        }
        i = iTemp
        if (count == N) {
            println(i)
            break
        }
        i++
    }
}
