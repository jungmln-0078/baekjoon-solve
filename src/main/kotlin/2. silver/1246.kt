fun main() {
    val input = readln().split(" ")
    val N = input[0].toInt()
    val M = input[1].toInt()
    val customers = mutableListOf<Int>()
    for (i: Int in 1..M) {
        customers.add(readln().toInt())
    }
    customers.sort()
    val suggestedPrices = mutableMapOf<Int, Int>()
    for (suggestedPrice: Int in customers) {
        val customerCount = if (customers.filter { it >= suggestedPrice }.size > N) N else customers.filter { it >= suggestedPrice }.size
        suggestedPrices[suggestedPrice] = customerCount * suggestedPrice
    }
    val max = suggestedPrices.maxWith(compareBy { it.value })
    println("${max.key} ${max.value}")
}
