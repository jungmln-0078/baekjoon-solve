fun main() {
    val (n, q) = readln().split(" ").map { it.toInt() }
    val arr = readln().split(" ").map { it.toInt() }.toMutableList()
    for (i: Int in 1..q) {
        val cmd = readln().split(" ").map { it.toInt() }
        if (cmd[0] == 1) {
            println(sum14648(arr, cmd[1] - 1, cmd[2] - 1))
            val temp = arr[cmd[1] - 1]
            arr[cmd[1] - 1] = arr[cmd[2] - 1]
            arr[cmd[2] - 1] = temp
        } else if (cmd[0] == 2) {
            println(sum14648(arr, cmd[1] - 1, cmd[2] - 1) - sum14648(arr, cmd[3] - 1, cmd[4] - 1))
        }
    }
}

fun sum14648(list: MutableList<Int>, start: Int, end: Int): Long {
    var sum: Long = 0
    for (i: Int in start..end) {
        sum += list[i]
    }
    return sum
}
