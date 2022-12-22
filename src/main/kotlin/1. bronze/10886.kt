fun main() {
    val lineCount = readln().toInt()
    var curLine = 1
    var cute = 0
    var notCute = 0
    while(curLine <= lineCount) {
        if (readln() == "1") cute++ else notCute++
        curLine++
    }
    if (cute > notCute) print("Junhee is cute!")
    else if (notCute > cute) print("Junhee is not cute!")
}
