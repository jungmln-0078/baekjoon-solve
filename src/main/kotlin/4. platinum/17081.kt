import kotlin.math.ceil
import kotlin.math.floor
import kotlin.math.max
import kotlin.system.exitProcess

fun main() {
    data class Monster(
        var name: String,
        var att: Int,
        var def: Int,
        var hp: Int,
        var exp: Int
    )

    data class Item(
        var type: String,
        var value: Any
    )

    class Player {
        var lv = 1
        var hp = 20
        var curHp = 20
        var att = 2
        var def = 2
        var exp = 5
        var curExp = 0
        var wepAtt = 0 // 무기공격력
        var amrDef = 0 // 방어구방어력
        var acc = mutableListOf<String>() // 악세서리 리스트

        fun gainExp(amount: Int) {
            this.curExp += amount
            if (curExp >= exp) {
                curExp = 0
                lv++
                exp = lv * 5
                hp += 5
                curHp = hp
                att += 2
                def += 2
            }
        }

        fun heal(amount: Int) {
            this.curHp += amount
            if (this.curHp > this.hp) this.curHp = this.hp
        }

        fun equip(item: Item) {
            val v = item.value.toString()
            when (item.type) {
                "W" -> wepAtt = v.toInt()
                "A" -> amrDef = v.toInt()
                "O" -> if (acc.size < 4 && !acc.contains(item.value)) acc.add(v)
            }
        }
    }

    val (N, M) = readln().split(" ").map { it.toInt() }
    val map = mutableListOf<MutableList<Char>>()
    var K = 0 // 몬스터의 수
    var L = 0 // 아이템의 수
    var playerPosX = 0 // 플레이어 위치 map[y][x]
    var playerPosY = 0 // 플레이어 위치 map[y][x]
    var startPosX = 0 // 플레이어 시작 위치
    var startPosY = 0 // 플레이어 시작 위치
    for (i: Int in 0 until N) {
        val maprow = readln().toMutableList()
        map.add(maprow)
        K += maprow.count { it == '&' || it == 'M' }
        L += maprow.count { it == 'B' }
        if (maprow.contains('@')) {
            playerPosY = i
            playerPosX = maprow.indexOf('@')
            startPosY = playerPosY
            startPosX = playerPosX
        }
    }
    val moves = readln().toMutableList()
    val mobs = mutableMapOf<Pair<Int, Int>, Monster>()
    val items = mutableMapOf<Pair<Int, Int>, Item>()
    for (i: Int in 1..K) {
        val input = readln().split(" ")
        mobs[input[0].toInt() - 1 to input[1].toInt() - 1] = Monster(input[2], input[3].toInt(), input[4].toInt(), input[5].toInt(), input[6].toInt())
    }
    for (i: Int in 1..L) {
        val input = readln().split(" ")
        items[input[0].toInt()  -1 to input[1].toInt() - 1] = Item(input[2], input[3])
    }
    val player = Player()
    var passedTurns = 0
    var isOnSpike = false

    fun gameEnded(msg: String) {
        if (player.curHp == 0) map[playerPosY][playerPosX] = if (isOnSpike) '^' else '.'
        println(map.joinToString("\n") { it.joinToString("") })
        println("Passed Turns : $passedTurns")
        println("LV : ${player.lv}")
        println("HP : ${player.curHp}/${player.hp}")
        println("ATT : ${player.att}+${player.wepAtt}")
        println("DEF : ${player.def}+${player.amrDef}")
        println("EXP : ${player.curExp}/${player.exp}")
        println(msg)
        exitProcess(0)
    }

    fun spikeDamage() {
        if (player.acc.contains("DX")) {
            player.curHp -= 1
        } else {
            player.curHp -= 5
        }
        if (player.curHp <= 0) {
            map[playerPosY][playerPosX] = '^'
            if (player.acc.contains("RE")) {
                isOnSpike = false
                player.curHp = player.hp
                playerPosY = startPosY
                playerPosX = startPosX
                map[startPosY][startPosX] = '@'
                player.acc.remove("RE")
            } else {
                gameEnded("YOU HAVE BEEN KILLED BY SPIKE TRAP..")
            }
        }
    }

    fun validateMove(y: Int, x: Int) {
        val movingPos = map[y][x]
        when (movingPos) {
            '.' -> {
                map[y][x] = '@'
                map[playerPosY][playerPosX] = if (isOnSpike) '^' else '.'
                playerPosY = y
                playerPosX = x
                isOnSpike = false
            }
            '#' -> if (isOnSpike) spikeDamage()
            '^' -> {
                map[y][x] = '@'
                map[playerPosY][playerPosX] = if (isOnSpike) '^' else '.'
                playerPosY = y
                playerPosX = x
                isOnSpike = true
                spikeDamage()
            }
            '&', 'M' -> {
                val mob = mobs[y to x]!!
                val firstAttackDamage =
                    if (player.acc.contains("CO"))
                        if (player.acc.contains("DX")) max(1, (player.att + player.wepAtt) * 3 - mob.def)
                        else max(1, (player.att + player.wepAtt) * 2 - mob.def)
                    else max(1, (player.att + player.wepAtt) - mob.def)
                val huContains = player.acc.contains("HU") && movingPos == 'M'
                if (huContains) player.curHp = player.hp
                val playerAttackCount = ceil(max(0, mob.hp - firstAttackDamage) / max(1, (player.att + player.wepAtt) - mob.def).toDouble()).toInt() // 플레이어가 이기기 위한 공격 횟수
                var mobAttackCount = ceil(player.curHp / max(1, mob.att - (player.def + player.amrDef)).toDouble()).toInt() // 몬스터가 이기기 위한 공격 횟수
                if (huContains) mobAttackCount++
                if (playerAttackCount < mobAttackCount) {
                    mobs.remove(y to x)
                    map[y][x] = '@'
                    map[playerPosY][playerPosX] = if (isOnSpike) '^' else '.'
                    isOnSpike = false
                    playerPosY = y
                    playerPosX = x
                    player.curHp -= max(0, max(1, mob.att - (player.def + player.amrDef)) * (if (huContains) playerAttackCount - 1 else playerAttackCount))
                    if (player.acc.contains("EX")) {
                        player.gainExp(floor(mob.exp * 1.2).toInt())
                    } else {
                        player.gainExp(mob.exp)
                    }
                    if (player.acc.contains("HR")) player.heal(3)
                    if (movingPos == 'M') gameEnded("YOU WIN!")
                } else {
                    if (player.acc.contains("RE")) {
                        player.curHp = player.hp
                        map[playerPosY][playerPosX] = if (isOnSpike) '^' else '.'
                        isOnSpike = false
                        playerPosY = startPosY
                        playerPosX = startPosX
                        map[startPosY][startPosX] = '@'
                        player.acc.remove("RE")
                    } else {
                        player.curHp = 0
                        gameEnded("YOU HAVE BEEN KILLED BY ${mob.name}..")
                    }
                }
            }
            'B' -> {
                val item = items[y to x]!!
                player.equip(item)
                items.remove(y to x)
                map[y][x] = '@'
                map[playerPosY][playerPosX] = if (isOnSpike) '^' else '.'
                playerPosY = y
                playerPosX = x
                isOnSpike = false
            }
        }
    }

    for (move in moves) {
        passedTurns++
        when (move) {
            'L' -> if (playerPosX - 1 >= 0) validateMove(playerPosY, playerPosX - 1) else if (isOnSpike) spikeDamage()
            'R' -> if (playerPosX + 1 < M) validateMove(playerPosY, playerPosX + 1) else if (isOnSpike) spikeDamage()
            'U' -> if (playerPosY - 1 >= 0) validateMove(playerPosY - 1, playerPosX) else if (isOnSpike) spikeDamage()
            'D' -> if (playerPosY + 1 < N) validateMove(playerPosY + 1, playerPosX) else if (isOnSpike) spikeDamage()
        }
    }
    gameEnded("Press any key to continue.")
}
