fun main () {
    readln()
    val A = readln().split(" ").associateWith { false }
    val B = readln().split(" ").associateWith { false }
    var result = 0
    for (a: Map.Entry<String, Boolean> in A) {
        if (B[a.key] == null) result++
    }
    for (b: Map.Entry<String, Boolean> in B) {
        if (A[b.key] == null) result++
    }
    println(result)
}
