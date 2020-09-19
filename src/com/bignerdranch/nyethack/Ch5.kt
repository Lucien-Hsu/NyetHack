package com.bignerdranch.nyethack

fun main(args: Array<String>){
    //5.1
    //這裡的 .count() 是匿名函數
    val numLetters = "Mississippi".count()
    println(numLetters)   //印出 11

    //在 println 中使用匿名函數
    //在大括號中定義函數，而大括號後的小括號表示呼叫此函數
    println({
       val currentYear = 2018
        "Welcome~ (copyright $currentYear)"
    }())

    //5.1.1
    //使用 function type 變數
    val greeting: () -> String = {
        val currentYear = 2018
        "Welcome~ (copyright $currentYear)"
    }
    println(greeting())

    //5.1.4
    //在只有一個參數的匿名函數中使用 it 關鍵字
    val greeting2: (String) -> String = {
        val currentYear = 2018
        "Welcome, $it! (copyright $currentYear)"
    }
    //使用匿名函數並印出
    println(greeting2("Jack"))



}