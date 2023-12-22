fun main() {
    val tcCount = readln().toInt()

    for (tc: Int in 1..tcCount) {
        val n = readln().toInt()
        val roll = readln().split(" ")
        val U = MutableList(3) { MutableList(3) { "w" } } // 위
        val D = MutableList(3) { MutableList(3) { "y" } } // 아래
        val F = MutableList(3) { MutableList(3) { "r" } } // 앞
        val B = MutableList(3) { MutableList(3) { "o" } } // 뒤
        val L = MutableList(3) { MutableList(3) { "g" } } // 왼
        val R = MutableList(3) { MutableList(3) { "b" } } // 오

        println("    -U-    ")
        println("    ${U[0].joinToString("")}    ")
        println("    ${U[1].joinToString("")}    ")
        println("    ${U[2].joinToString("")}    ")
        println("-L- -F- -R-")
        println("${L[0].joinToString("")} ${F[0].joinToString("")} ${R[0].joinToString("")}")
        println("${L[1].joinToString("")} ${F[1].joinToString("")} ${R[1].joinToString("")}")
        println("${L[2].joinToString("")} ${F[2].joinToString("")} ${R[2].joinToString("")}")
        println("    -D-    ")
        println("    ${D[0].joinToString("")}    ")
        println("    ${D[1].joinToString("")}    ")
        println("    ${D[2].joinToString("")}    ")
        println("    -B-    ")
        println("    ${B[0].joinToString("")}    ")
        println("    ${B[1].joinToString("")}    ")
        println("    ${B[2].joinToString("")}    ")
        println("----------------------------------------")
        for (rol: String in roll) {
            when (rol) {
                "U+" -> {
                    var temp = U[0][2]
                    var temp2 = U[2][2]
                    U[0][2] = U[0][0]
                    U[2][2] = temp
                    temp = U[2][0]
                    U[2][0] = temp2
                    U[0][0] = temp

                    temp = U[1][2]
                    temp2 = U[2][1]
                    U[1][2] = U[0][1]
                    U[2][1] = temp
                    temp = U[1][0]
                    U[1][0] = temp2
                    U[0][1] = temp

                    val b = B[2].toMutableList()
                    val r = mutableListOf(R[2][0], R[1][0], R[0][0])
                    val f = F[0].toMutableList()
                    val l = L[0].toMutableList()

                    B[2] = mutableListOf(l[2], l[1], l[0])
                    R[0] = mutableListOf(b[2], b[1], b[0])
                    F[0] = mutableListOf(r[2], r[1], r[0])
                    L[0] = f
                }
                "U-" -> {
                    var temp = U[0][0]
                    var temp2 = U[2][0]
                    U[0][0] = U[0][2]
                    U[2][0] = temp
                    temp = U[2][2]
                    U[2][2] = temp2
                    U[0][2] = temp

                    temp = U[0][1]
                    temp2 = U[1][0]
                    U[0][1] = U[1][2]
                    U[1][0] = temp
                    temp = U[2][1]
                    U[2][1] = temp2
                    U[1][2] = temp

                    val b = B[2].toMutableList()
                    val r = mutableListOf(R[2][0], R[1][0], R[0][0])
                    val f = F[0].toMutableList()
                    val l = L[0].toMutableList()

                    B[2] = mutableListOf(r[0], r[1], r[2])
                    R[0] = f
                    F[0] = l
                    L[0] = mutableListOf(b[2], b[1], b[0])
                }
                "D+" -> {
                    var temp = D[0][2]
                    var temp2 = D[2][2]
                    D[0][2] = D[0][0]
                    D[2][2] = temp
                    temp = D[2][0]
                    D[2][0] = temp2
                    D[0][0] = temp

                    temp = D[1][2]
                    temp2 = D[2][1]
                    D[1][2] = D[0][1]
                    D[2][1] = temp
                    temp = D[1][0]
                    D[1][0] = temp2
                    D[0][1] = temp

                    var t = F[2].toMutableList()
                    val t2 = R[2].toMutableList()

                    F[2] = L[2].toMutableList()
                    R[2] = t
                    t = B[0].toMutableList()
                    B[0] = mutableListOf(t2[2], t2[1], t2[0])
                    L[2] = mutableListOf(t[2], t[1], t[0])
                }
                "D-" -> {
                    var temp = D[0][0]
                    var temp2 = D[2][0]
                    D[0][0] = D[0][2]
                    D[2][0] = temp
                    temp = D[2][2]
                    D[2][2] = temp2
                    D[0][2] = temp

                    temp = D[0][1]
                    temp2 = D[1][0]
                    D[0][1] = D[1][2]
                    D[1][0] = temp
                    temp = D[2][1]
                    D[2][1] = temp2
                    D[1][2] = temp

                    var t = F[2].toMutableList()
                    val t2 = L[2].toMutableList()

                    F[2] = R[2].toMutableList()
                    L[2] = t
                    t = B[0]
                    B[0] = mutableListOf(t2[2], t2[1], t2[0])
                    R[2] = mutableListOf(t[2], t[1], t[0])
                }
                "F+" -> {
                    var temp = F[0][2]
                    var temp2 = F[2][2]
                    F[0][2] = F[0][0]
                    F[2][2] = temp
                    temp = F[2][0]
                    F[2][0] = temp2
                    F[0][0] = temp

                    temp = F[1][2]
                    temp2 = F[2][1]
                    F[1][2] = F[0][1]
                    F[2][1] = temp
                    temp = F[1][0]
                    F[1][0] = temp2
                    F[0][1] = temp

                    val u = U[2].toMutableList()
                    val l = mutableListOf(L[0][2], L[1][2], L[2][2])
                    val r = mutableListOf(R[0][0], R[1][0], R[2][0])
                    val d = D[0].toMutableList()

                    U[2] = mutableListOf(l[2], l[1], l[0])
                    L[0][2] = d[0]
                    L[1][2] = d[1]
                    L[2][2] = d[2]
                    D[0] = mutableListOf(r[2], r[1], r[0])
                    R[0][0] = u[0]
                    R[1][0] = u[1]
                    R[2][0] = u[2]
                }
                "F-" -> {
                    var temp = D[0][0]
                    var temp2 = D[2][0]
                    D[0][0] = D[0][2]
                    D[2][0] = temp
                    temp = D[2][2]
                    D[2][2] = temp2
                    D[0][2] = temp

                    temp = D[0][1]
                    temp2 = D[1][0]
                    D[0][1] = D[1][2]
                    D[1][0] = temp
                    temp = D[2][1]
                    D[2][1] = temp2
                    D[1][2] = temp

                    val u = U[2].toMutableList()
                    val l = mutableListOf(L[0][2], L[1][2], L[2][2])
                    val r = mutableListOf(R[0][0], R[1][0], R[2][0])
                    val d = D[0].toMutableList()

                    U[2] = r.toMutableList()
                    L[0][2] = u[2]
                    L[1][2] = u[1]
                    L[2][2] = u[0]
                    D[0] = l.toMutableList()
                    R[0][0] = d[2]
                    R[1][0] = d[1]
                    R[2][0] = d[0]
                }
                "B+" -> {
                    var temp = B[0][2]
                    var temp2 = B[2][2]
                    B[0][2] = B[0][0]
                    B[2][2] = temp
                    temp = B[2][0]
                    B[2][0] = temp2
                    B[0][0] = temp

                    temp = B[1][2]
                    temp2 = B[2][1]
                    B[1][2] = B[0][1]
                    B[2][1] = temp
                    temp = B[1][0]
                    B[1][0] = temp2
                    B[0][1] = temp

                    val u = U[0].toMutableList()
                    val l = mutableListOf(L[2][0], L[1][0], L[0][0])
                    val r = mutableListOf(R[2][2], R[1][2], R[0][2])
                    val d = D[2].toMutableList()

                    D[2] = mutableListOf(l[2], l[1], l[0])
                    R[2][2] = d[0]
                    R[1][2] = d[1]
                    R[0][2] = d[2]
                    U[0] = mutableListOf(r[2], r[1], r[0])
                    L[2][0] = u[0]
                    L[1][0] = u[1]
                    L[0][0] = u[2]
                }
                "B-" -> {
                    var temp = B[0][0]
                    var temp2 = B[2][0]
                    B[0][0] = B[0][2]
                    B[2][0] = temp
                    temp = B[2][2]
                    B[2][2] = temp2
                    B[0][2] = temp

                    temp = B[0][1]
                    temp2 = B[1][0]
                    B[0][1] = B[1][2]
                    B[1][0] = temp
                    temp = B[2][1]
                    B[2][1] = temp2
                    B[1][2] = temp

                    val u = U[0].toMutableList()
                    val l = mutableListOf(L[2][0], L[1][0], L[0][0])
                    val r = mutableListOf(R[2][2], R[1][2], R[0][2])
                    val d = D[2].toMutableList()

                    D[2] = r.toMutableList()
                    R[2][2] = u[2]
                    R[1][2] = u[1]
                    R[0][2] = u[0]
                    U[0] = l.toMutableList()
                    L[2][0] = d[2]
                    L[1][0] = d[1]
                    L[0][0] = d[0]
                }
                "L+" -> {
                    var temp = L[0][2]
                    var temp2 = L[2][2]
                    L[0][2] = L[0][0]
                    L[2][2] = temp
                    temp = L[2][0]
                    L[2][0] = temp2
                    L[0][0] = temp

                    temp = L[1][2]
                    temp2 = L[2][1]
                    L[1][2] = L[0][1]
                    L[2][1] = temp
                    temp = L[1][0]
                    L[1][0] = temp2
                    L[0][1] = temp

                    val u = mutableListOf(U[0][0], U[1][0], U[2][0])
                    val f = mutableListOf(F[0][0], F[1][0], F[2][0])
                    val b = mutableListOf(B[2][0], B[1][0], B[0][0])
                    val d = mutableListOf(D[2][0], D[1][0], D[0][0])

                    U[0][0] = b[2]
                    U[1][0] = b[1]
                    U[2][0] = b[0]
                    F[0][0] = u[0]
                    F[1][0] = u[1]
                    F[2][0] = u[2]
                    D[0][0] = f[0]
                    D[1][0] = f[1]
                    D[2][0] = f[2]
                    B[0][0] = d[0]
                    B[1][0] = d[1]
                    B[2][0] = d[2]
                }
                "L-" -> {
                    var temp = L[0][0]
                    var temp2 = L[2][0]
                    L[0][0] = L[0][2]
                    L[2][0] = temp
                    temp = L[2][2]
                    L[2][2] = temp2
                    L[0][2] = temp

                    temp = L[0][1]
                    temp2 = L[1][0]
                    L[0][1] = L[1][2]
                    L[1][0] = temp
                    temp = L[2][1]
                    L[2][1] = temp2
                    L[1][2] = temp

                    val u = mutableListOf(U[0][0], U[1][0], U[2][0])
                    val f = mutableListOf(F[0][0], F[1][0], F[2][0])
                    val b = mutableListOf(B[2][0], B[1][0], B[0][0])
                    val d = mutableListOf(D[2][0], D[1][0], D[0][0])

                    U[0][0] = f[0]
                    U[1][0] = f[1]
                    U[2][0] = f[2]
                    F[0][0] = d[2]
                    F[1][0] = d[1]
                    F[2][0] = d[0]
                    D[0][0] = b[2]
                    D[1][0] = b[1]
                    D[2][0] = b[0]
                    B[0][0] = u[0]
                    B[1][0] = u[1]
                    B[2][0] = u[2]
                }
                "R+" -> {
                    var temp = R[0][2]
                    var temp2 = R[2][2]
                    R[0][2] = R[0][0]
                    R[2][2] = temp
                    temp = R[2][0]
                    R[2][0] = temp2
                    R[0][0] = temp

                    temp = R[1][2]
                    temp2 = R[2][1]
                    R[1][2] = R[0][1]
                    R[2][1] = temp
                    temp = R[1][0]
                    R[1][0] = temp2
                    R[0][1] = temp

                    val u = mutableListOf(U[2][2], U[1][2], U[0][2])
                    val f = mutableListOf(F[0][2], F[1][2], F[2][2])
                    val b = mutableListOf(B[2][2], B[1][2], B[0][2])
                    val d = mutableListOf(D[0][2], D[1][2], D[2][2])

                    U[2][2] = f[2]
                    U[1][2] = f[1]
                    U[0][2] = f[0]
                    B[0][2] = u[2]
                    B[1][2] = u[1]
                    B[2][2] = u[0]
                    D[0][2] = b[2]
                    D[1][2] = b[1]
                    D[2][2] = b[0]
                    F[0][2] = d[0]
                    F[1][2] = d[1]
                    F[2][2] = d[2]
                }
                "R-" -> {
                    var temp = R[0][0]
                    var temp2 = R[2][0]
                    R[0][0] = R[0][2]
                    R[2][0] = temp
                    temp = R[2][2]
                    R[2][2] = temp2
                    R[0][2] = temp

                    temp = R[0][1]
                    temp2 = R[1][0]
                    R[0][1] = R[1][2]
                    R[1][0] = temp
                    temp = R[2][1]
                    R[2][1] = temp2
                    R[1][2] = temp

                    val u = mutableListOf(U[2][2], U[1][2], U[0][2])
                    val f = mutableListOf(F[0][2], F[1][2], F[2][2])
                    val b = mutableListOf(B[2][2], B[1][2], B[0][2])
                    val d = mutableListOf(D[0][2], D[1][2], D[2][2])

                    U[0][2] = b[2]
                    U[1][2] = b[1]
                    U[2][2] = b[0]
                    B[0][2] = d[0]
                    B[1][2] = d[1]
                    B[2][2] = d[2]
                    D[0][2] = f[0]
                    D[1][2] = f[1]
                    D[2][2] = f[2]
                    F[0][2] = u[2]
                    F[1][2] = u[1]
                    F[2][2] = u[0]
                }
            }
            println(rol)
            println("    -U-    ")
            println("    ${U[0].joinToString("")}    ")
            println("    ${U[1].joinToString("")}    ")
            println("    ${U[2].joinToString("")}    ")
            println("-L- -F- -R-")
            println("${L[0].joinToString("")} ${F[0].joinToString("")} ${R[0].joinToString("")}")
            println("${L[1].joinToString("")} ${F[1].joinToString("")} ${R[1].joinToString("")}")
            println("${L[2].joinToString("")} ${F[2].joinToString("")} ${R[2].joinToString("")}")
            println("    -D-    ")
            println("    ${D[0].joinToString("")}    ")
            println("    ${D[1].joinToString("")}    ")
            println("    ${D[2].joinToString("")}    ")
            println("    -B-    ")
            println("    ${B[0].joinToString("")}    ")
            println("    ${B[1].joinToString("")}    ")
            println("    ${B[2].joinToString("")}    ")
            println("----------------------------------------")
        }
        println(U.joinToString("\n") { it.joinToString("") })
    }
}

/**
    U

        -B-
        123
        456
        789
    -L- -U- -R-
    741 123 369
    852 456 258
    963 789 147
        -F-
        123
        456
        789

    F
        -U-
        123
        456
        789
    -L- -F- -R-
    123 123 123
    456 456 456
    789 789 789
        -D-
        123
        456
        789

    D
        -F-
        123
        456
        789
    -L- -D- -R-
    369 123 741
    258 456 852
    147 789 963
        -B-
        123
        456
        789

    B

        -D-
        123
        456
        789
    -L- -B- -R-
    987 123 987
    654 456 654
    321 789 321
        -U-
        123
        456
        789

    R
        -U-
        741
        852
        963
    -F- -R- -B-
    123 123 987
    456 456 654
    789 789 321
        -D-
        369
        258
        147

    L
        -U-
        369
        258
        147
    -B- -L- -F-
    987 123 123
    654 456 456
    321 789 789
        -D-
        741
        852
        963
 */
