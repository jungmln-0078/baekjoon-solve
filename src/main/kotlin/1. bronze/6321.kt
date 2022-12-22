fun main() {
    val lineCount = readln().toInt()
    val result: MutableList<String> = mutableListOf();
    for (i: Int in 1..lineCount) {
        result.add("String #${i}");
        var comName = readln()
        comName = comName.map { c -> (if (c.code + 1 > 90) 65 else c.code + 1).toChar() }.joinToString("")
        if (i != lineCount) comName += "\n"
        result.add(comName)
    }
    print(result.joinToString("\n"))
}
