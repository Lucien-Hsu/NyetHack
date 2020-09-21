package com.bignerdranch.nyethack

//父類別
//使用open關鍵字開放繼承
open class Room(val name: String) {
    //以protected關鍵字表示可以被繼承
    protected open val dangerLevel = 5

    fun description() = "Room: $name" + "\nDanger Level: $dangerLevel"

    //函數也要使用open關鍵字開放繼承
    open fun load() = "Nothing much to see here..."
}

//子類別
class TownSquare : Room("Town Squere") {
    //以override覆寫成員變數
    override val dangerLevel = super.dangerLevel - 3
    //以private修飾子設為私有
    private var bellSound = "GWONG"

    //以override覆寫函數
    //以final關鍵字禁止子類別覆寫
    final override fun load() = "The villagers rally and cheer as you enter!\n${ringBell()}"

    private fun ringBell() = "The bell tower announces your arrival. $bellSound"
}


