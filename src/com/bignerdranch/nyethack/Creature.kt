package com.bignerdranch.nyethack

//介面宣告
interface Fightable {
    var healthPoints: Int
    val diceCount: Int
    val diceSides: Int
    val damageRoll: Int

    //介面可作為參數類型
    fun attack(opponent: Fightable): Int
}