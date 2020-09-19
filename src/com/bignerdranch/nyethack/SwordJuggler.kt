package com.bignerdranch.nyethack

import java.lang.Exception
import java.lang.IllegalStateException

fun main(args: Array<String>) {
    var swordsJuggling: Int? = null
    //只有三分之一機會不為空
    val isJugglingProficient = (1..3).shuffled().last() == 3
    if(isJugglingProficient){
        swordsJuggling = 2
    }
    //以try-catch抓取例外
    try {
        //proficiencyCheck函數會檢查引數，若為null則"主動"拋出例外
        proficiencyCheck(swordsJuggling)
        //若swordsJuggling為空則系統會拋出例外
        swordsJuggling = swordsJuggling!!.plus(1)

    }catch (e: Exception){
        //try{}中的程式碼若有catch()中的例外，則會運行此區塊程式碼
        println(e)
    }

    //印出結果
    println("You juggle $swordsJuggling swords!")
}

fun proficiencyCheck(swordsJuggling: Int?) {
    //若為空則拋出IllegalStateException例外
    //1.例外之括號內可包含說明
    swordsJuggling ?: throw IllegalStateException("Player cannot juggle swords")

    //2.也可拋出自訂例外
    swordsJuggling ?: throw UnskilledSwordJugglerException()

    //3.先決條件函數
    checkNotNull(swordsJuggling, {"Player cannot juggle swords"})
}

//自訂例外
class UnskilledSwordJugglerException() :
    IllegalStateException("Player cannot juggle swords")