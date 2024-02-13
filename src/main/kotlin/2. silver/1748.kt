fun main() {
    var n = readln().toInt()
    var result = 0
    if (n == 100_000_000) {
        result += 9
        n--
    }
    if (n >= 10_000_000) {
        result += (n - 10_000_000 + 1) * 8
        n = 9_999_999
    }
    if (n >= 1_000_000) {
        result += (n - 1_000_000 + 1) * 7
        n = 999_999
    }
    if (n >= 100_000) {
        result += (n - 100_000 + 1) * 6
        n = 99_999
    }
    if (n >= 10_000) {
        result += (n - 10_000 + 1) * 5
        n = 9_999
    }
    if (n >= 1_000) {
        result += (n - 1_000 + 1) * 4
        n = 999
    }
    if (n >= 100) {
        result += (n - 100 + 1) * 3
        n = 99
    }
    if (n >= 10) {
        result += (n - 10 + 1) * 2
        n = 9
    }
    result += n
    println(result)
}
