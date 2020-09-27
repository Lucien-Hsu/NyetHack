//12.9 競態條件
class Weapon2(val name: String)
class Player2{
    var weapon: Weapon2? = Weapon2("Sword")

    fun printWeaponName(){
        //此寫法會產生競態條件
        //因為if判斷完後，在println之前，weapon有可能被其他程式改為null
//        if(weapon != null){
//            println(weapon.name)
//        }

        //此寫法相當於把判斷完非null的值傳給it，it是唯讀的，因此確保了值不更動
        weapon?.also{
            println(it.name)
        }
    }
}

fun main(args: Array<String>) {
    Player2().printWeaponName()
}