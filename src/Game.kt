fun main(args: Array<String>) {
    val name = "Madrigal"
    var healthPoints = 76
    val isBlessed = true
    val isImmortal = false

    //Auro
    val auroVisible = isBlessed && healthPoints >50 || isImmortal
    if (auroVisible) {
        println("GREEN")
    } else{
        println("NONE")
    }


    if (healthPoints == 100){
        println(name + " is in excellent condition!")
    } else if (healthPoints in 90..99) {
        println(name + " has a few scratches.")
    } else if (healthPoints in 75..89) {
        if (isBlessed) {
            println(name + " has some minor wounds but is healing quite quickly!")
        } else {
            println(name + " has some minor wounds.")
        }

    } else if (healthPoints in 15..74) {
        println(name + " looks pretty hurt.")
    } else {
        println(name + " is in awful condition!")
    }

}

