//T是泛型參數通常採用的名稱
class LootBox<T>(item: T){
    private var loot: T = item
}

class Fedora(val name: String, val value: Int)

class Coin(val value: Int)

fun main(args: Array<String>){
    //創造兩個同類型但不同泛型引數的物件
    val lootBoxOne: LootBox<Fedora> = LootBox(Fedora("a generic-looking fedora", 15))
    val lootBoxTwo: LootBox<Coin> = LootBox(Coin(15))
}


