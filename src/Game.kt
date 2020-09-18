fun main(args: Array<String>) {
//    val name = "Madrigal"
    var healthPoints = 89
    val isBlessed = true    //是否走運
    val isImmortal = false  //是否永生

    val player = Player()   //12.2 宣告玩家類別
    player.castFireball()

    //Aura 光環
    val auraColor = auraColor(isBlessed, healthPoints, isImmortal)
    //判定健康狀態
    val healStatus = formatHealthStatus(healthPoints, isBlessed)
    //印出玩家狀態
    printPlayerStatus(auraColor, isBlessed, player.name, healStatus)

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

private fun printPlayerStatus(
    auraColor: String,
    isBlessed: Boolean,
    name: String,
    healStatus: String
) {
    //印出光環與走運狀況
    println(
        "(Auro: $auraColor)" +
                "(Blessed: ${if (isBlessed) "YES" else "NO"})"
    )
    //印出健康狀態
    println("$name $healStatus")
}

private fun auraColor(isBlessed: Boolean, healthPoints: Int, isImmortal: Boolean): String {
    val auraVisible = isBlessed && healthPoints > 50 || isImmortal
    val auraColor = if (auraVisible) "GREEN" else "NONE"
    return auraColor
}

private fun formatHealthStatus(healthPoints: Int, isBlessed: Boolean) =
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
