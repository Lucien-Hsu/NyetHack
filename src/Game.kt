fun main(args: Array<String>) {
    val name = "Madrigal"
    var healthPoints = 89
    val isBlessed = true    //是否走運
    val isImmortal = false  //是否永生

    //Aura 光環
    val auraColor = auraColor(isBlessed, healthPoints, isImmortal)

    //判定健康狀態
    val healStatus = formatHealthStatus(healthPoints, isBlessed)

    //印出玩家狀態
    printPlayerStatus(auraColor, isBlessed, name, healStatus)

    castFireball()



    TODO("123")


    //判斷種族
    val race = "gnome"
    val faction = when(race){
        "dwarf" -> "Keep of the Mines"
        "gnome" -> "Keep of the Mines"
        "orc" -> "Free People of the Rolling Hills"
        "human" -> "Free People of the Rolling Hills"
        else -> ""
    }

}


//丟火球
private fun castFireball(numFireballs: Int = 2) =
    print("A glass of Fireball springs into existence. (x$numFireballs)")

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
