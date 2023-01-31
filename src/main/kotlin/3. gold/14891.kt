fun main() {
    val gear1 = readln()
    val gear2 = readln()
    val gear3 = readln()
    val gear4 = readln()
    val gear = mutableListOf("", gear1, gear2, gear3, gear4)
    val K = readln().toInt()
    val rot: MutableList<Pair<Int, Int>> = mutableListOf()
    for (i: Int in 1..K) {
        val input = readln().split(" ").map { it.toInt() }
        rot.add(input[0] to input[1])
    }
    for ((g: Int, dir: Int) in rot) {
        val rotations: MutableList<Pair<Int, Int>> = mutableListOf(g to dir)
        var d = dir
        for (i: Int in g downTo 2) {
            if (gear[i][6] != gear[i - 1][2]) {
                d *= -1
                rotations.add(i - 1 to d)
            } else {
                break
            }
        }
        d = dir
        for (i: Int in g until 4) {
            if (gear[i][2] != gear[i + 1][6]) {
                d *= -1
                rotations.add(i + 1 to d)
            } else {
                break
            }
        }
        for ((g1: Int, dir1: Int) in rotations) {
            if (dir1 == 1) {
                gear[g1] = gear[g1][7] + gear[g1].substring(0..6)
            } else {
                gear[g1] = gear[g1].substring(1..7) + gear[g1][0]
            }
        }
    }
    var result = 0
    if (gear[1][0] == '1') result += 1
    if (gear[2][0] == '1') result += 2
    if (gear[3][0] == '1') result += 4
    if (gear[4][0] == '1') result += 8
    println(result)
}
