package com.bignerdranch.nyethack

const val TAVERN_NAME = "Taernyl's Folly"

fun main(args: Array<String>) {
//    //6.4.1
//    //讀入引數並印出
//    print("請輸入飲料：")
//    //var beverage = readLine().capitalize()    //錯誤
//    var beverage = readLine()?.capitalize()     //正確，使用安全呼叫運算子
//    println(beverage)
//
//    //以 let 做進一步處理
//    print("請輸入飲料：")
//    var beverage2 = readLine()?.let{
//        if (it.isNotBlank()){
//            it.capitalize()
//        }else{
//            "Buttered Ale"
//        }
//    }
//    println(beverage2)
//
//    //6.4.2
//    print("請輸入飲料：")
//    var beverage3 = readLine()!!.capitalize()     //使用非空斷言
//    println(beverage3)
//
//    //6.4.3
//    print("請輸入飲料：")
//    var beverage4 = readLine()
//
//    beverage4 = null    //設定為 null
//    if(beverage4 != null){
//        beverage4 = beverage4.capitalize()
//        println(beverage4)
//    }else{
//        println("beverage was null!")   //輸出此行
//    }
//
//    //6.4.3_2
//    //空合併運算子
//    print("請輸入飲料：")
//    var beverage5 = readLine()
//    val beverageServed: String = beverage5 ?: "Buttered Ale"
//    println(beverageServed)
//
//    //空合併運算子搭配 let
//    print("請輸入飲料：")
//    var beverage6 = readLine()
//    beverage6?.let{
//        beverage6 = it.capitalize()
//    } ?: println("beverage was null!")

    //7.1.1
//    placeOrder()

    //7.1.2
//    placeOrder2("shandy,Dragon's Breath,5.91")

    //7.2
    placeOrder3("shandy,Dragon's Breath,5.91")
}

//7.1.1
private fun placeOrder() {
    ////以indexOf()取得"'"字元索引
    val indexOfApostrophe = TAVERN_NAME.indexOf('\'')
    //取得子字串，引數內為IntRange類型
    //until不包括上限值
    val tavernMaster = TAVERN_NAME.substring(0 until indexOfApostrophe)
    println("Madrigal speaks with Taernyl about their order.")
}

//7.1.2
private fun placeOrder2(menuData: String) {
    val indexOfApostrophe = TAVERN_NAME.indexOf('\'')
    val tavernMaster = TAVERN_NAME.substring(0 until indexOfApostrophe)
    println("Madrigal speaks with Taernyl about their order.")

    //split以指定字元分割字串
//    val data = menuData.split(',')
//    val type = data[0]
//    val name = data[1]
//    val price = data[2]

    //split以指定字元分割字串
    //解構(destructuring)寫法
    val (type, name, price) = menuData.split(',')

    val message = "Madrigal buys a $name ($type) for $price"
    println(message)
}

//7.2
private fun placeOrder3(menuData: String) {
    val indexOfApostrophe = TAVERN_NAME.indexOf('\'')
    val tavernMaster = TAVERN_NAME.substring(0 until indexOfApostrophe)
    println("Madrigal speaks with Taernyl about their order.")

    val (type, name, price) = menuData.split(',')

    val phrase = "Ah, delicious $name!"
    val message = "Madrigal exclaims:${toDragonSpeak(phrase)}"
    println(message)
}

//7.2
//replace有兩個參數
//第一個參數用的Regex包含要替換的字元，這裡包含五個字元，第二個參數以匿名函數指定要替換成什麼字元
private fun toDragonSpeak(phrase: String) =
    phrase.replace(Regex("[aeiou]")) {
        when (it.value) {
            "a" -> "4"
            "e" -> "3"
            "i" -> "1"
            "o" -> "0"
            "u" -> "|_|"
            else -> it.value
        }
}



