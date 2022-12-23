fun main() {
    val N = readln().toInt()
    val question = mutableListOf<Int>()
    val popStack = mutableListOf<Int>()
    val stack = mutableListOf<Int>()
    var result = StringBuilder("")
    for (i: Int in 1..N) {
        question.add(readln().toInt())
    }
    var quesPointer = 0
    var num = 0
    while (true) {
        if (quesPointer == N) break
        if (question[quesPointer] <= num) {
            popStack.add(stack.last())
            stack.removeLast()
            result.append("-\n")
            if (question[quesPointer] == popStack[quesPointer]) {
                quesPointer++
                continue
            } else {
                result = StringBuilder("NO")
                break
            }
        } else {
            num++
            stack.add(num)
            result.append("+\n")
        }
    }
    println(result.toString())
}
