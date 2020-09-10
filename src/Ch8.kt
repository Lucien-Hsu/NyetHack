import java.math.BigDecimal

fun main(args: Array<String>) {
    //8.4
    val str = "Test it."

    //將字串轉為各種數字類型
    val floatVar: Float = str.toFloat()
    val doubleVar: Double = str.toDouble()
    val doubleVar2: Double = str.toDouble()
    val intVar: Int = str.toIntOrNull() ?: 0
    val longVar: Long = str.toLong()
    val bigDecimalVar: BigDecimal = str.toBigDecimal()
}