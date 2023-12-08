import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {
    val sb = BufferedReader(InputStreamReader(System.`in`))
    val result = BufferedWriter(OutputStreamWriter(System.out))
    val input = sb.readLine().toList().map { it.toString() } // 입력한 중위표기식
    val stack = mutableListOf<String>() // 연산자가 저장될 스택
    val operators = listOf("*", "/", "-", "+") // 연산자
    val prior = mapOf("*" to 3, "/" to 3, "-" to 2, "+" to 2, "(" to 1) // 연산자별 우선순위

    for (i: String in input) {
        if (i == "(") {
            stack.add(i)
        } else if (i == ")") { // 닫는 괄호인 경우
            while(stack.isNotEmpty()) { // 여는 괄호를 만날 때까지 pop하여 result에 더한다.
                if (stack.last() == "(") break
                result.append(stack.last())
                stack.removeLast()
            }
            if (stack.isNotEmpty() && stack.last() == "(") stack.removeLast() // 괄호가 닫혔으므로 여는 괄호도 없앤다.
        } else if (operators.contains(i)) { // 연산자인 경우
            if (stack.isEmpty()) { // 스택이 비어있으면 스택에 추가한다.
                stack.add(i)
            } else if (prior[stack.last()]!! > prior[i]!!) { // 스택의 앞 연산자가 우선순위가 더 높으면
                while(stack.isNotEmpty()) { // 여는 괄호를 만날 때까지 pop하여 result에 더한다.
                    if (stack.last() == "(") break
                    result.append(stack.last())
                    stack.removeLast()
                }
                stack.add(i) // 아직 괄호가 닫히지 않았으므로 현재 연산자를 스택에 추가한다.
            } else if (prior[stack.last()]!! < prior[i]!!) { // 스택의 앞 연산자가 우선순위가 더 낮으면
                stack.add(i) // 현재 연산자를 스택에 추가한다.
            } else { // 우선순위가 같으면
                result.append(stack.last()) // 스택에서 pop하여 result에 더한다.
                stack.removeLast()
                stack.add(i)
            }
        } else {
            result.append(i) // 문자인 경우 result에 더한다.
        }
    }
    while(stack.isNotEmpty()) { // 입력 수식을 모두 순회한 경우 연산자를 모두 pop하여 result에 더한다.
        result.append(stack.last())
        stack.removeLast()
    }
    result.flush()
    result.close()
}
