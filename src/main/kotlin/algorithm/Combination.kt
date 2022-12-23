package algorithm
/* 조합 (Combination)
n개 중에서 순서 상관없이 m개를 뽑는 경우의 수
nCm으로 나타냄
이항 계수 라고도 한다.
nCm = n! / ((n-m)! * m!)
 */
val numList = intArrayOf(1, 2, 3, 4, 5)
val pickedNum = mutableListOf<Int>()

fun main() {
    combination(0, 3, 0) // 5개 중에 3개를 뽑는 경우들을 출력
    println(nCm(5, 3))
}

fun combination(count: Int, depth: Int, beginWith: Int) {
    if (count == depth) {
        pickedNum.forEach {
            print("$it") // 뽑는 경우를 모두 출력
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

fun nCm(n: Int, m: Int): Int {
    return factorial(n) / (factorial(n - m) * factorial(m))
}

fun factorial(n: Int): Int {
    var result = 1
    (1..n).forEach { result *= it }
    return result
}
