fun main() {
    val N = readln().toInt()
    val students = mutableListOf<String>()
    for (i: Int in 1..N) {
        students.add(readln())
    }
    val len = students[0].length
    var k = 0
    for (kIdx: Int in len - 1 downTo 0) {
        k++
        val temp = mutableListOf<String>()
        for (sIdx: Int in students.indices) {
            temp.add(students[sIdx].slice(kIdx until len))
        }
        if (temp.distinct().size == N) break
    }
    println(k)
}
