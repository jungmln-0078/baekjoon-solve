fun main() {
    while (true) {
        val line = readln()
        val stack = mutableListOf<Char>()
        if (line == ".") return
        for (c: Char in line) {
            if (c == ')') {
                if (stack.isEmpty() || stack.last() != '(') {
                    stack.add(c)
                    break
                }
                stack.removeLast()
            } else if (c == ']') {
                if (stack.isEmpty() || stack.last() != '[') {
                    stack.add(c)
                    break
                }
                stack.removeLast()
            } else if (c == '(' || c == '[') {
                stack.add(c)
            }
        }
        if (stack.isEmpty()) println("yes") else println("no")
    }
}
