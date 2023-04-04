fun main() {
    val line = readln()
    val stack = mutableListOf<Char>()
    for (c: Char in line) {
        if (c == ')') {
            if (stack.isEmpty() || stack.last() != '(') {
                stack.add(c)
            } else {
                stack.removeLast()
            }
        } else if (c == '(') {
            stack.add(c)
        }
    }
    println(stack.size)
}
