fun main() {
    var (A, B) = readln().split(" ").map { it.toInt() }
    var result = 0
    while (true) {
        if (A == B) break
        else if (B % 10 == 1) B /= 10
        else if (A > B || B % 2 == 1) {
            result = -2
            break
        } else B /= 2
        result++
    }
    println(result + 1)
}
