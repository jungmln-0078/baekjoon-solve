import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    var scoreSubjectScore = 0.0
    var score = 0.0
    val subjectScore = mapOf(
        "A+" to 4.5,
        "A0" to 4.0,
        "B+" to 3.5,
        "B0" to 3.0,
        "C+" to 2.5,
        "C0" to 2.0,
        "D+" to 1.5,
        "D0" to 1.0,
        "F" to 0.0
    )

    for (i in 1..20) {
        val input = br.readLine()
        val scores = input.split(" ")
        if (scores[2] == "P") continue
        scoreSubjectScore += scores[1].toDouble() * subjectScore[scores[2]]!!
        score += scores[1].toDouble()
    }

    println(scoreSubjectScore / score)
    br.close()
}
