package algorithm
/* 이분 탐색(Binary Search)
이미 정렬되있는 리스트에서 사용 가능한 탐색 알고리즘
1. 리스트의 중간값을 정함. 리스트의 길이 / 2 (소수점 버림) 인덱스 값
2. 찾으려는 값이 중간값과 같으면 -> 탐색 완료!!
    찾으려는 값이 중간값보다 작으면 -> [0 ~ 중간값 인덱스 - 1] 까지 탐색 범위를 재설정
    찾으려는 값이 중간값보다 크면 -> [중간값 인덱스 + 1 ~ 마지막 인덱스] 까지 탐색 범위를 재설정
3. 재설정된 탐색 범위에서 찾을때까지 1 ~ 2 반복
시간복잡도는 0(logN)
 */
fun main() {
    val list = listOf(1, 3, 5, 7, 8, 11, 12)
    val find = readln().toInt()
    var first = 0
    var last = list.lastIndex

    while (first <= last) {
        val midIdx = (first + last) / 2
        val mid = list[midIdx]
        if (find == mid) { // 찾음
            println("found $find")
            break
        } else if (find > mid) { // 찾으려는 값이 중간값보다 크므로
            first = midIdx + 1 // 중간값 이후로 탐색 범위를 재설정
        } else if (find < mid) { // 찾으려는 값이 중간값보다 작으므로
            last = midIdx - 1 // 중간값 이전으로 탐색 범위를 재설정
        }
    }
}
