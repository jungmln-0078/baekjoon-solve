val options = mutableListOf<String>()
val hotkeys = mutableListOf<String?>()
fun main() {
    val N = readln().toInt()
    for (i: Int in 1..N) {
        val option = readln()
        options.add(option)
        makeHotkey(i -  1)
    }
    println(options.joinToString("\n"))
}

fun makeHotkey(idx: Int) {
    val option = options[idx]
    val splited = option.split(" ").toMutableList()
    for (i: Int in splited.indices) {
        val c = splited[i][0]
        if (!hotkeys.contains(c.lowercase()) && c != ' ') {
            hotkeys.add(c.lowercase())
            splited[i] = splited[i].replaceFirst(c.toString(), "[$c]")
            options[idx] = splited.joinToString(" ")
            return
        }
    }
    for (i: Int in option.indices) {
        val c = option[i]
        if (!hotkeys.contains(c.lowercase()) && c != ' ') {
            hotkeys.add(c.lowercase())
            options[idx] = option.slice(0 until i) + ("[" + option[i] + "]") + option.slice(i + 1..option.lastIndex)
            return
        }
    }
}
