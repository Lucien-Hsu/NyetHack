package com.bignerdranch.nyethack

//18.10 帶接收者的擴充函數
//透過Room接收者，直接設定Room內部的哥布林
fun Room.configurePitGoblin(block: Room.(Goblin) -> Goblin): Room{
    val goblin = block(Goblin("Pit Goblin", description = "An Evil Pit Goblin"))
    monster = goblin
    return this
}

