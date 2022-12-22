fun main() {
    val n = readln().toInt()
    val cards = ArrayDeque<Int>()
    cards.addAll(n downTo 1)
    while(cards.size != 1) {
        cards.removeLast()

        cards.addFirst(cards.last())
        cards.removeLast()
    }
    print(cards[0])
}
