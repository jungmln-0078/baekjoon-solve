import kotlin.math.log2
// https://blog.naver.com/tyui623/222919687784
fun main() {
    readln()
    val input = readln().split(" ").map { i -> i.toInt() }.toMutableList()
    var result = 0
    // 0이 나올 때까지 루프돌면서 정렬, 연산을 하면 느림
    // 최종적으로 수가 1, 1, 1, 1 이 됨
    // 1, 1, 1, 1 이 되면 정렬할 필요가 없으니 사실 답은 모든 수가 1이 되는 횟수 + 1임
    // [1 ~ (n + 1) / 2] 번째 값들의 최댓값은 [1 ~ n] 번째 값들의 중간값과 같음
    // 결국 답은 [1 ~ (n + 1) / 2] 번째 값들을 2로 몇번 나눠서 다 1이 되는 횟수 + 1
    input.sort()
    val idx = ((input.size + 1) / 2) - 1
    val toMiddle = input.slice(0..idx)
    for (i: Int in 0..idx) {
        // 2로 몇번 나눴을때 0이 되는지 구하려면 log2를 하면 된다.
        result += log2(toMiddle[i].toDouble()).toInt()
    }
    println(result + 1)
}
