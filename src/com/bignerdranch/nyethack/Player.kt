package com.bignerdranch.nyethack//
//
//fun main(args: Array<String>){
//    val player = Player()   //宣告玩家類別
//    player.castFireball()   //使用類別函數
//}


//12 建立類別
class Player {
    //12.5 建立類別屬性，需有初始值
    var name = "madrigal"
        get() = field.capitalize()  //getter
        private set(value) {        //setter，並設定其可見性為private
            field = value.trim()
        }

    var healthPoints = 89
    val isBlessed = true    //是否走運
    private val isImmortal = false  //是否永生

//    val rolledValue                 //12.5.3 此為"計算屬性"，可以不初始化，也不產生field
//        get() = (1..6).shuffled().first()

    //12.3建立類別函數
    fun castFireball(numFireballs: Int = 2) =
        println("A glass of Fireball springs into existence.(x$numFireballs)")

    fun auraColor(): String {
        val auraVisible = isBlessed && healthPoints > 50 || isImmortal
        val auraColor = if (auraVisible) "GREEN" else "NONE"
        return auraColor
    }

    fun formatHealthStatus() =
        when (healthPoints) {
            100 -> "is in excellent condition!"
            in 90..99 ->
                "has a few scratches."
            in 75..89 ->
                if (isBlessed) {
                    "has some minor wounds but is healing quite quickly!"
                } else {
                    "has some minor wounds."
                }
            in 15..74 -> "looks pretty hurt."
            else -> "is in awful condition!"
        }
}