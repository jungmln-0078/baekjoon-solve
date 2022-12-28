package algorithm
/* KMP(Knuth, Morris, Prett) 알고리즘
https://bowbowbow.tistory.com/6
문자열 탐색 알고리즘
시간 복잡도는 O(n+m)
브루트포스로 문자열을 탐색하려면 원본 문자열의 모든 인덱스를 탐색할 문자열의 길이만큼 탐색해야함 O(nm)
1. 탐색 문자열의 부분 문자열들의 접두사, 접미사를 구한다.
2. 접두사, 접미사가 같은 것이 있으면 그 길이를 배열에 저장한다(없으면 0). 이를 pi 배열이라고 한다.
3. s = 원본 문자열, p = 탐색 문자열, i = 0.., j = 탐색 문자열 인덱스 라 할때,
    for (i) {
        while(j가 0보다 크고 원본 문자열[i] != 탐색 문자열[j] 이면) { // 앞의 일부 문자열이 같아 j를 증가시켰는데, 중간 문자열이 다른 경우
            j = pi[j - 1] // j를 pi 배열의 이전 값으로 설정하여 앞으로 최대한 당김 (이미 원본 문자열[i] != 탐색 문자열[j] 이므로 비교할 필요 없는 중간 단계를 스킵)
        }
        if (j가 탐색 문자열의 마지막 인덱스이면) {
            if (원본 문자열[i] == 탐색 문자열[j]) {
                결과 배열에 탐색 문자열이 시작하는 원본 문자열의 인덱스를 저장 (i - 탐색 문자열 + 1)
                j = pi[j] (j를 되돌려 다시 탐색)
            } else {
                j++
            }
        }
    }
4. 탐색 문자열이 시작하는 원본 문자열의 인덱스가 저장된 배열이 결과로 리턴됨
 */
fun main() {
    val str = "OOOIOIOIIOIOIIIIOI"
    val p = "IOIOI"
    println(pi("2 5 2 5 2 5 2 8 2 5 2"))
    println(kmp(str, p))
}

fun kmp(str: String, p: String): MutableList<Int> {
    val result = mutableListOf<Int>()
    val pi = pi(p)
    var j = 0
    for (i: Int in 0 ..str.lastIndex) {
        while (j > 0 && str[i] != p[j]) {
            j = pi[j - 1] // j를 pi 배열의 이전 값으로 설정하여 앞으로 최대한 당김 (이미 str[i] != p[j] 이므로 굳이 비교할 필요 없는 중간 단계를 스킵)
        }
        if (str[i] == p[j]) {
            if (j == p.lastIndex) { // 마지막 인덱스면 (모두 같은 부분을 찾았다면)
                result.add(i - p.length + 1) // 결과 배열에 탐색 문자열이 시작하는 원본 문자열의 인덱스를 저장
                j = pi[j]
            } else {
                j++
            }
        }
    }
    return result
}

// 탐색 문자열의 각 부분 문자열마다, 접두, 접미가 같을 때 그 길이를 저장하는 배열을 만듬
fun pi(p: String): MutableList<Int> {
    var j = 0
    val result = MutableList(p.length) { 0 }
    for (i: Int in 1..p.lastIndex) {
        while (j > 0 && p[i] != p[j]) {
            j = result[j - 1] // j를 pi 배열의 이전 값으로 설정하여 앞으로 최대한 당김 (이미 str[i] != p[j] 이므로 굳이 비교할 필요 없는 중간 단계를 스킵)
        }
        if (p[i] == p[j]) {
            result[i] = ++j // j 증가, pi 배열에 저장
        }
    }
    return result
}
