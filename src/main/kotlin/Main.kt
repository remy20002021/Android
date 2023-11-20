fun main() {
    print("Enter a number: ")
    val n = readLine()?.toIntOrNull()

    if (n != null) {
        val words = convertNumberToWords(n)
        println("In words: $words")
    } else {
        println("INVALID Number.")
    }
}

fun convertNumberToWords(n: Int): String {
    val units = arrayOf("", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine")
    val teens = arrayOf("", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen")
    val tens = arrayOf("", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety")

    return when {
        n == 0 -> "Zero"
        n < 0 -> "Minus " + convertNumberToWords(-n)
        n < 10 -> units[n]
        n in 11..19 -> teens[n - 10]
        n < 100 -> tens[n / 10] + if (n % 10 != 0) " " + units[n % 10] else ""
        n < 1000 -> units[n / 100] + " Hundred" + if (n % 100 != 0) " and " + convertNumberToWords(n % 100) else ""
        n < 1000000 -> convertNumberToWords(n / 1000) + " Thousand" + if (n % 1000 != 0) " " + convertNumberToWords(n % 1000) else ""
        else -> "Number out of The range (1-999999) this is INVALID!!!"
    }
}