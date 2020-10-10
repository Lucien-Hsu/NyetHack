package com.bignerdranch.nyethack

import com.bignerdranch.nyethack.extensions.random as randomizer

//
//fun main(args: Array<String>){
//    val player = Player()   //宣告玩家類別
//    player.castFireball()   //使用類別函數
//}

//12 建立類別
//13 建構函數
//16 介面
class Player(
    _name: String,
    override var healthPoints: Int = 100,
    val isBlessed: Boolean,
    private val isImmortal: Boolean
) : Fightable{
    //16.2 實作介面成員
    override val diceCount = 3
    override val diceSides = 6

    override fun attack(opponent: Fightable): Int {
        val damageDealt = if (isBlessed){
            damageRoll * 2
        }else{
            damageRoll
        }
        opponent.healthPoints -= damageDealt
        return damageDealt
    }

    //12.5 建立類別屬性，需有初始值
    var name = _name
        get() = "${field.capitalize()} of $homeTown"  //getter
        private set(value) {        //setter，並設定其可見性為private
            field = value.trim()
        }

    val homeTown by lazy { "Tampa" } //13.5.2
    var currentPosition = Coordinate(0, 0)

    //13.1.3
    //定義次建構函數
    constructor(name: String) : this(
        name,
        isBlessed = true,   //此為具名引數，並提供預設參數
        isImmortal = false  //此為具名引數，並提供預設參數
    ) {
        //可定義初始化邏輯
        if (name.toLowerCase() == "kar") healthPoints = 40
    }

    init {
        require(healthPoints > 0, {"healthPoints must be greater than zero."})
        require(name.isNotBlank(), {"Player must have a name."})
    }

//    var healthPoints = _healthPoints
//    val isBlessed = _isBlessed    //是否走運
//    private val isImmortal = _isImmortal  //是否永生

    val rolledValue                 //12.5.3 此為"計算屬性"，可以不初始化，也不產生field
//        get() = (1..6).shuffled().first()
    get() = (1..6).randomizer()

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

