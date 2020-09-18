fun main(args: Array<String>) {
    //11.1
//    //利用to函數宣告
//    val m: Map<String, Double> = mapOf("A" to 10.5, "B" to 3.2, "C" to 9.8)
//    println(m)
//
//    //利用Pair宣告
//    var m2 = mapOf(Pair("AA", 1.2), Pair("BB", 2.3), Pair("CC", 3.4))
//    println(m2)
//    //指定已有的鍵則會取代之前的鍵值
//    m2 += "AA" to 99.9
//    println(m2)

    //11.2~11.3
    var m3 = mutableMapOf("A" to 10, "B" to 20)
    //讀取指定鍵的值
    println(m3["A"])
    m3.put("C", 30)     //增加鍵值對
    println(m3)
    m3.putAll(listOf("D" to 40, "E" to 50)) //增加多個鍵值對
    println(m3)
    m3.remove("A")  //移除指定鍵值對
    println(m3)
    m3.clear()          //清空
    println(m3)

}