import kotlin.math.ceil

fun main() {
    val input1 = readln().split(" ").map { it.toLong() }
    val input2 = readln().split(" ").map { it.toLong() }
    val heroHP = input1[0]
    val heroATK = input1[1]
    val demonHP = input1[2]
    val demonATK = input1[3]
    val demonSkillRequireHP = input2[0]
    val demonSkillAmount = input2[1]
    val h = ceil(heroHP / demonATK.toDouble()).toLong() // 용사가 처치되는데 필요한 마왕 평타 수
    val dBeforeSkill = ceil((demonHP - demonSkillRequireHP) / heroATK.toDouble()).toLong() // 마왕이 용사의 평타를 몇대 맞으면 스킬 사용하는지
    val d = if (demonHP - (heroATK * dBeforeSkill) > 0) { // 마왕이 스킬 사용조건 HP 이하가 되도록 용사의 평타를 맞았는데 처치되지 않았으면
        ceil((demonHP + demonSkillAmount) / heroATK.toDouble()).toLong() // 증가된 HP 기준으로 마왕이 용사의 평타를 몇대 맞으면 죽는지 계산
    } else {
        ceil(demonHP / heroATK.toDouble()).toLong() // 마왕이 용사의 평타를 몇대 맞으면 죽는지 계산
    }
    if (h >= d) println("Victory!") else println("gg") // 용사가 먼저 때리므로 마왕의 필요 평타수 >= 용사의 필요 평타수 이면 승리
}
