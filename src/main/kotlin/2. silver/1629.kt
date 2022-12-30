fun main() {
    val input = readln().split(" ")
    var n = input[0].toLong()
    var r = input[1].toLong()
    val c = input[2].toLong()
    var result = 1.toLong()
    while (r > 0) {
        if (r % 2.toLong() == 1.toLong()) {
            result = (result * n) % c
        }
        n = ((n % c) * (n % c)) % c
        r /= 2
    }
    println(result)
}
