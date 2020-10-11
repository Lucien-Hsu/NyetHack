fun main(args: Array<String>) {
    println("123".frame(5))
}

//原函數
//fun frame(name: String, padding: Int, formatChar: String = "*"): String{
//    val greeting = "$name!"
//    val middle = formatChar.padEnd(padding)
//        .plus(greeting)
//        .plus(formatChar.padStart(padding))
//    val end = (0 until middle.length).joinToString(""){formatChar}
//    return "$end\n$middle\n$end"
//}

//擴充函數
fun String.frame(padding: Int, formatChar: String = "*"): String{
    val greeting = "$this!"
    val middle = formatChar.padEnd(padding)
        .plus(greeting)
        .plus(formatChar.padStart(padding))
    val end = (0 until middle.length).joinToString(""){formatChar}
    return "$end\n$middle\n$end"
}