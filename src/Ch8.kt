fun main(args: Array<String>) {
//    //8.4
//    val str = "123"
//
//    //將字串轉為各種數字類型
//    val floatVar: Float = str.toFloat()
//    val doubleVar: Double = str.toDouble()
//    val doubleVar2: Double = str.toDouble()
//    val intVar: Int = str.toIntOrNull() ?: 0
//    val longVar: Long = str.toLong()
//    val bigDecimalVar: BigDecimal = str.toBigDecimal()  //高精度浮點數
//
//    //8.6
//    val floatV = 5/3.0
//    println("5/3.0之原始數值：$floatV")
//    println("轉換後(小數點第2位)：${"%.2f".format(floatV)}")
//    println("轉換後(小數點第5位)：${"%.5f".format(floatV)}")

    //8.7
    val paperMoney: Int;
    val coin: Int;

    print("請輸入三人用餐金額：")
    val bill: Double = readLine()?.toDouble() ?: 0.0
    val billPerGuys: Double = bill / 3.0
    println("一人" + billPerGuys + "元")

    paperMoney = (billPerGuys / 100).toInt()
    coin = (billPerGuys % 100).toInt()

    println("共有鈔票：$paperMoney 張")
    println("共有硬幣：$coin 個")
}