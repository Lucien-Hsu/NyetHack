package com.bignerdranch.nyethack

import kotlin.random.Random

//介面宣告
interface Fightable {
    var healthPoints: Int
    val diceCount: Int
    val diceSides: Int
    val damageRoll: Int
        //預設實作
        get() = (0 until diceCount).map {
            Random.nextInt(diceSides) + 1
        }.sum()

    //介面可作為參數類型
    fun attack(opponent: Fightable): Int
}