fun main() {
    val word = readln()
    var result = 0
    for (c: Char in word) {
        when (c) {
            in 'A'..'C' -> result += 3
            in 'D'..'F' -> result += 4
            in 'G'..'I' -> result += 5
            in 'J'..'L' -> result += 6
            in 'M'..'O' -> result += 7
            in 'P'..'S' -> result += 8
            in 'T'..'V' -> result += 9
            in 'W'..'Z' -> result += 10
        }
    }
    println(result)
}
