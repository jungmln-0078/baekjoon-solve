fun main() {
    val ipv6 = readln().split(":").toMutableList()
    if (ipv6.count { it == "" } == 2) ipv6.removeAt(ipv6.indexOf(""))
    var idx = -1
    for (i in ipv6.indices) {
        if (ipv6[i].isEmpty()) idx = i
        if (ipv6[i].length < 4) {
            ipv6[i] = "0".repeat(4 - ipv6[i].length) + ipv6[i]
        }
    }
    if (ipv6.size < 8) {
        for (i: Int in 1..8 - ipv6.size) {
            ipv6.add(idx, "0000")
        }
    }
    println(ipv6.joinToString(":"))
}
