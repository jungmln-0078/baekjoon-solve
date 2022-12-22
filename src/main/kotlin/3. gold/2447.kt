var result: MutableList<MutableList<String>> = mutableListOf()
fun main() {
    val n = readln().toInt()
    result = MutableList(n) { MutableList(n) { "" } }
    star(n, 0, 0)
    println(result.joinToString("\n") { it.joinToString("") })
}

fun star(n: Int, x: Int, y: Int) {
    val offset = n / 3
    val yRange = (y..y + (2 * offset)) step offset
    val xRange = (x..x + (2 * offset)) step offset
    val offsetY = yRange.toList()[1]
    val offsetX = xRange.toList()[1]
    for (i: Int in yRange) {
        for (j: Int in xRange) {
            if (offset == 1) {
                result[i][j] = if (i == offsetY && j == offsetX) " " else "*"
            } else if (i == offsetY && j == offsetX) {
                for (yy: Int in offsetY until offsetY + (2 * offset)) {
                    for (xx: Int in offsetX until offsetX + (2 * offset)) {
                        result[yy][xx] = " "
                    }
                }
            } else {
                star(offset, j, i)
            }
        }
    }
}
