//T是泛型參數通常採用的名稱
class LootBox<T>(item: T){
    var open = false
    private var loot: T = item

    //17.2 定義泛型函數
    fun fetch(): T?{
        return loot.takeIf { open }
    }

    //17.3 多泛型參數
    fun <R> fetch(lootModFunction: (T) -> R): R?{
        return lootModFunction(loot).takeIf { open }
    }
}

class Fedora(val name: String, val value: Int)

class Coin(val value: Int)


fun main(args: Array<String>){
    //創造兩個同類型但不同泛型引數的物件
    val lootBoxOne: LootBox<Fedora> = LootBox(Fedora("a generic-looking fedora", 15))
    val lootBoxTwo: LootBox<Coin> = LootBox(Coin(15))

    lootBoxOne.open = true
    lootBoxOne.fetch()?.run{
        println("You retrieve $name from the box!")
    }

    //17.3 傳入Coin()，回傳Coin()
    val coin = lootBoxOne.fetch() {
        Coin(it.value * 3)
    }
    coin?.let{ println(it.value)}

}


