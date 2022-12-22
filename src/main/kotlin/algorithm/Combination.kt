val numList = intArrayOf(1, 2, 3, 4, 5)
val pickedNum = mutableListOf<Int>()

fun main() {
    combination(0, 3, 0)
}

fun combination(count: Int, depth: Int, beginWith: Int) {
    if (count == depth) {
        pickedNum.forEach {
            print("$it")
        }
        println()
        return
    }
    for (index in beginWith until numList.size) {
        pickedNum.add(numList[index])
        combination(count + 1, depth, index + 1)
        pickedNum.removeAt(pickedNum.lastIndex)
    }
}
