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

//16.4 抽象類別
//怪物
abstract class Monster(
    val name: String,
    val description: String,
    override var healthPoints: Int
) : Fightable {

    override fun attack(opponent: Fightable): Int {
        val damageDealt = damageRoll
        opponent.healthPoints -= damageDealt
        return damageDealt
    }
}

//16.4
//哥布林
//抽象類別之子類別需實作所有介面的成員，可繼承也可自己實作
class Goblin(
    name: String = "Goblin",
    description: String = "A nasty-looking goblin",
    healthPoints: Int = 30
) : Monster(name, description, healthPoints) {
    override val diceCount: Int = 2
    override val diceSides: Int = 8
}
