package com.bignerdranch.nyethack

import java.lang.IllegalStateException
import kotlin.system.exitProcess

fun main(args: Array<String>) {


    //15.1.1
    Game.play()

    //4.16 醉酒狀態報告
//    val drunkRate = castFireball()
//    val drunkType = when(drunkRate){
//        in 1..10 -> "tipsy"
//        in 11..20 -> "sloshed"
//        in 21..30 -> "soused"
//        in 31..40 -> "stewed"
//        in 41..50 -> "..t0aSt3d"
//        else -> "null"
//    }
//    println("\nDrunk Rate：" + drunkType)

    //判斷種族
    val race = "gnome"
    val faction = when (race) {
        "dwarf" -> "Keep of the Mines"
        "gnome" -> "Keep of the Mines"
        "orc" -> "Free People of the Rolling Hills"
        "human" -> "Free People of the Rolling Hills"
        else -> ""
    }

    //4.10 返回 Nothing 類型
    fun shouldReturnAString(): String {
        TODO("尚待實作")    //TODO 的返回類型是 Nothing
        println("永遠不會執行此行")
    }

    //4.13 反引號中的函數名稱
    fun doStuff() {
        //從 Kotlin 調用 Java 的 is() 方法
//        `is`()
    }

    fun `單元測試一：測試這個和那個`() {
        //Do test
    }
    //呼叫此測試函數
    `單元測試一：測試這個和那個`()
}

//4.15 丟火球
//private fun castFireball(numFireballs: Int = 2): Int {
//    print("A glass of Fireball springs into existence. (x$numFireballs)")
//    val drunkRate: Int = (1..50).random()
//    return drunkRate
//}


//private fun auraColor(isBlessed: Boolean, healthPoints: Int, isImmortal: Boolean): String {
//    val auraVisible = isBlessed && healthPoints > 50 || isImmortal
//    val auraColor = if (auraVisible) "GREEN" else "NONE"
//    return auraColor
//}
//
//private fun formatHealthStatus(healthPoints: Int, isBlessed: Boolean) =
//    when (healthPoints) {
//        100 -> "is in excellent condition!"
//        in 90..99 ->
//            "has a few scratches."
//        in 75..89 ->
//            if (isBlessed) {
//                "has some minor wounds but is healing quite quickly!"
//            } else {
//                "has some minor wounds."
//            }
//        in 15..74 -> "looks pretty hurt."
//        else -> "is in awful condition!"
//    }

//14.4 類型轉換
fun printIsSourceOfBlessings(any: Any) {
    val isSourceOfBlessings = if (any is Player) {
        //智慧類型轉換，因為已經在if判斷式中確認了any是Player型態
        any.isBlessed
    } else {
        //類型轉換，將any的類型轉為Room
        (any as Room).name == "Fount of Blessings"
    }

    println("$any is a source of blessings: $isSourceOfBlessings")
}

//15.1.1建立單例物件，會自動建立實體
object Game {
    private val player = Player("Madrigal")   //12.2 宣告玩家類別
    private var currentRoom: Room = TownSquare()    //初始地圖



    //15.9 用來記錄遊戲是否終止
    var doExit = false

    //15.6
    private var worldMap = listOf(
        listOf(currentRoom, Room("Taverm"), Room("Black Room")),
        listOf(Room("Long Corridor"), Room("Generic Room"))
    )

    val name = "Madrigal"
    var healthPoints = 89
    val isBlessed = true    //是否走運
    val isImmortal = false  //是否永生

    //Aura 光環
    val auraColor = player.auraColor()

    //判定健康狀態
    val healStatus = player.formatHealthStatus()

    //初始化
    init {
        println("Welcome, adventurer.")
        player.castFireball()

        //18.10 利用帶接收者的擴充函數來設定地窖哥布林
        currentRoom.configurePitGoblin { goblin ->
            goblin.healthPoints = dangerLevel * 3
            goblin
        }
    }

    //15.2 巢狀類別
    private class GameInput(args: String?) {
        private val input = args ?: ""
        val command = input.split(" ")[0]

        //若分割出的字串陣列之第[1]個元素為空，則回傳空字串
        val argument = input.split(" ").getOrElse(1, { "" })

        fun processCommand() = when (command.toLowerCase()) {
            //16.5 戰鬥
            "fight" -> fight()
            //15.6
            "move" -> move(argument)
            "quit" -> doExit()
            "exit" -> doExit()
            "map" -> showMap(player)
            "ring" -> ringing()
            else -> commandNotFound()
        }

        private fun commandNotFound() = "I'm not quite sure what you're trying to do!"
    }

    fun play() {
        while (true) {
            //14.1
            println(currentRoom.description())
            println(currentRoom.load())
//            printIsSourceOfBlessings(player)

            //印出玩家狀態
            printPlayerStatus(player)

            println("> Enter your command: ")
//            println("Last command: ${readLine()}")
            println(GameInput(readLine()).processCommand())
            //15.9 跳出遊戲
            if(doExit)break
        }
    }

    private fun printPlayerStatus(
        player: Player
    ) {
        //印出光環與走運狀況
        println(
            "(Auro: ${player.auraColor()})" +
                    "(Blessed: ${if (player.isBlessed) "YES" else "NO"})"
        )
        //印出健康狀態
        println("${player.name} ${player.formatHealthStatus()}")
    }

    //15.6
    private fun move(directionInput: String) =
        try {
            val direction = Direction.valueOf(directionInput.toUpperCase())         //取得使用這輸入方向之列舉常數
            val newPosition = direction.updateCoordinate(player.currentPosition)    //取得移動後的位置
            if (!newPosition.isInBounds){
                throw IllegalStateException("$direction is out of bounds.")         //如果超出邊界則拋出異常
            }
            //實際更新當前位置與地圖
            val newRoom = worldMap[newPosition.y][newPosition.x]    //若找不到符合的元素則拋出異常
            player.currentPosition = newPosition
            currentRoom = newRoom
            "OK, you move $direction to the ${newRoom.name}.\n${newRoom.load()}"
        }catch (e: Exception){
            "Invalid direction: $directionInput"
        }

    private fun doExit(): String{
        doExit = true
        return "GAME OVER."
    }

    //15.4 印地圖
    private fun showMap(player: Player){
        val position = player.currentPosition
        var visualMap = worldMap

        visualMap.forEach(){
            it.forEach(){
                when(it){
                    currentRoom -> print("X")
                    else -> print("O")
                }
            }
            println()
        }
    }

    //15.11 搖鈴
    private fun ringing() =
        if(currentRoom.name == "Town Squere"){
            (currentRoom as TownSquare).ringBell()
        }else{""}

    //16.5 打怪
    private fun fight() = currentRoom.monster?.let{
        while(player.healthPoints > 0 && it.healthPoints > 0){
            slay(it)
            Thread.sleep(1000)
        }
        "Combat complete."
    } ?: "There's nothing here to fight."

    //16.5 開打
    private fun slay(monster: Monster){
        println("${monster.name} did ${monster.attack(player)} damage!")
        println("${player.name} did ${player.attack(monster)} damage!")

        if(player.healthPoints <= 0){
            println(">>>> You have been defeated! Thanks for giving. <<<<")
            //用來停止JVM執行實例
            exitProcess(0)
        }
        if(monster.healthPoints <= 0){
            println(">>>> ${monster.name} has been defeated! <<<<")
            currentRoom.monster = null
        }
    }
}