package algorithm

import kotlin.math.max

// https://velog.io/@emplam27/%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98-%EA%B7%B8%EB%A6%BC%EC%9C%BC%EB%A1%9C-%EC%95%8C%EC%95%84%EB%B3%B4%EB%8A%94-LCS-%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98-Longest-Common-Substring%EC%99%80-Longest-Common-Subsequence
/* 최장 공통 문자열(Longest Common Substring)
문자열들 중에서 연속된 공통 문자열
ABCDEF .BCD..
GBCDFE .BCD..
최장 공통 문자열 = BCD
1. str1 = "ABCDEF", str2 = "GBCDFE", i = 1..str2.length, j = 1..str1.length 라고 할때,
    LCS[str2.length + 1][str1.length + 1]의 이차원 배열을 생성
    LCS[0][?] 인 부분과 LCS[?][0] 인 부분을 0으로 설정
2. for (i) {
        for (j) {
            str2[i - 1]를 str1[j - 1]와 비교
            다른 경우 -> LCS[i][j] = 0
            같은 경우 -> LCS[i][j] = LCS[i - 1][j - 1] + 1
        }
    }
3. 루프 종료 후 배열에서 최대값이 나오면 str2[i - 최대값] ~ str2[i - 1] (str1[j - 최대값] ~ str1[j - 1]) 이 최장 공통 문자열이 됨
 */

fun main() {
    println(longestCommonSubstring("CDEF", "GBCDFE"))
    println(longestCommonSubsequence("CDEF", "GBCDFE"))
}

fun longestCommonSubstring(str1: String, str2: String): String {
    val LCS = MutableList(str2.length + 1) { MutableList<Int?>(str1.length + 1) { null } }
    var max = Int.MIN_VALUE
    var maxI: Int? = null
    var maxJ: Int? = null
    for (i: Int in 0..str2.length) {
        LCS[i][0] = 0
    }
    for (j: Int in 0..str1.length) {
        LCS[0][j] = 0
    }
    for (i: Int in 1..str2.length) {
        for (j: Int in 1..str1.length) {
            if (str2[i - 1] != str1[j - 1]) LCS[i][j] = 0
            else LCS[i][j] = LCS[i - 1][j - 1]!! + 1
            if (LCS[i][j]!! > max) {
                max = LCS[i][j]!!
                maxI = i
                maxJ = j
            }
        }
    }
    return if (maxI != null && maxJ != null) str1.slice(maxJ - max until maxJ) else ""
}

/* 최장 공통 부분수열(Longest Common Subsequence)
최장 공통 문자열과 같으나, 중간에 다른 문자가 끼어도 됨
ABCDEF .BCD.F
GBCDFE .BCDF.
최장 공통 부분수열 = BCDF
1. str1 = "ABCDEF", str2 = "GBCDFE", i = 1..str2.length, j = 1..str1.length 라고 할때,
    LCS[str2.length + 1][str1.length + 1]의 이차원 배열을 생성
    LCS[0][?] 인 부분과 LCS[?][0] 인 부분을 0으로 설정
2. for (i) {
        for (j) {
            str2[i - 1]를 str1[j - 1]와 비교
            다른 경우 -> LCS[i][j] = max(LCS[i - 1][j], LCS[i][j - 1])
            같은 경우 -> LCS[i][j] = LCS[i - 1][j - 1] + 1
        }
    }
3. 루프 종료 후 LCS[str2,length][str1.length] 부터 시작하여 LCS[i - 1][j] 와 LCS[i][j - 1] 중 현재 값과 같은 값 찾음
    현재와 같은 값이 없을 경우 결과 배열에 str1[i] 또는 str2[j]의 값을 추가하고 LCS[i - 1][j - 1]로 이동
    0으로 이동할 때까지 반복하고 결과 배열을 뒤집은 것이 최장 공통 부분수열이 됨
 */
fun longestCommonSubsequence(str1: String, str2: String): String {
    val LCS = MutableList(str2.length + 1) { MutableList<Int?>(str1.length + 1) { null } }
    val result = StringBuilder("")
    for (i: Int in 0..str2.length) {
        LCS[i][0] = 0
    }
    for (j: Int in 0..str1.length) {
        LCS[0][j] = 0
    }
    for (i: Int in 1..str2.length) {
        for (j: Int in 1..str1.length) {
            if (str2[i - 1] != str1[j - 1]) LCS[i][j] = max(LCS[i - 1][j]!!, LCS[i][j - 1]!!)
            else LCS[i][j] = LCS[i - 1][j - 1]!! + 1
        }
    }
    var i = str2.length
    var j = str1.length
    while (true) {
        val v = LCS[i][j]
        if (v == 0) break
        when (v) {
            LCS[i - 1][j] -> i--
            LCS[i][j - 1] -> j--
            else -> {
                result.append(str2[i - 1])
                i--
                j--
            }
        }
    }
    return result.reversed().toString()
}
