//
//
//fun main(args: Array<String>){
//    val player = Player()   //宣告玩家類別
//    player.castFireball()   //使用類別函數
//}

//建立類別
class Player{
    //建立類別屬性，需有初始值
    val name = "Madrigal"

    //建立類別函數
    fun castFireball(numFireballs: Int = 2) =
        println("A glass of Fireball springs into existence.(x$numFireballs)")
}