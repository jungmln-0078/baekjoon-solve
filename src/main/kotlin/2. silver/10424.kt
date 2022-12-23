fun main() {
    readln()
    val score = readln().split(" ").map { it.toInt() }
    val answer = MutableList(score.size) {0}
    for (i: Int in score.indices) {
        answer[score[i] - 1] = score[i] - (i + 1)
    }
    println(answer.joinToString("\n"))
}
