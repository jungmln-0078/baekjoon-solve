fun main() {
    val bowl = readln()
    var height = 0
    for (i: Int in bowl.indices) {
        if (i == 0) {
            height += 10
            continue
        }
        height += if (bowl[i] == bowl[i - 1]) 5 else 10
    }
    print(height)
}
