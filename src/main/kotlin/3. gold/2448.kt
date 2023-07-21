fun main() {
    val N = readln().toInt()
    val M = 5 * (N / 3) + ((N / 3) - 1)
    val stars = MutableList(N) { MutableList(M) { " " } }
    fun star(n: Int, xOffset: Int, yOffset: Int) {
        if (n > 3) {
            star(n / 2, xOffset, yOffset)
            star(n / 2, xOffset - (n / 2), yOffset + (n / 2))
            star(n / 2, xOffset + (n / 2), yOffset + (n / 2))
        } else {
            for (y: Int in yOffset..yOffset + 2) {
                for (x: Int in xOffset - (y - yOffset)..xOffset + (y - yOffset)) {
                    if (y == yOffset + 1 && x == xOffset) continue
                    stars[y][x] = "*"
                }
            }
        }
    }
    star(N, (M - 1) / 2, 0)
    println(stars.joinToString("\n") { it.joinToString("") })
}