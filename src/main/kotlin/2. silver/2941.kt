fun main() {
    var word = readln()
    var result = 0
    for (i: Int in word.indices) {
        if (i < word.lastIndex - 1) {
            if (word[i] == 'd' && word[i + 1] == 'z' && word[i + 2] == '=') {
                word = word.removeRange(i + 1, i + 3)
                result++
                continue
            }
        }
        if (i < word.lastIndex) {
            if (word[i] == 'c' && word[i + 1] == '='
                || word[i] == 'c' && word[i + 1] == '-'
                || word[i] == 'd' && word[i + 1] == '-'
                || word[i] == 'l' && word[i + 1] == 'j'
                || word[i] == 'n' && word[i + 1] == 'j'
                || word[i] == 's' && word[i + 1] == '='
                || word[i] == 'z' && word[i + 1] == '='
            ) {
                word = word.removeRange(i + 1, i + 2)
            }
        }
        if (i <= word.lastIndex) {
            result++
        }
    }
    println(result)
}
