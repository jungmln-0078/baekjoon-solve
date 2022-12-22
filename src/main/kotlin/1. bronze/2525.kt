fun main() {
    val time = readln().split(" ").map { it.toInt() }.toMutableList()
    val duration = readln().toInt()

    time[1] += duration

    if (time[1] >= 60) {
        time[0] += time[1] / 60
        time[1] %= 60
    }
    if (time[0] >= 24) {
        time[0] -= 24
    }
    println(time.joinToString(" "))
}
