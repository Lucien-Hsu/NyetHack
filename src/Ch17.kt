//定義泛型類別
//T是泛型參數通常採用的名稱
//17.4 泛型約束，在此將T限制為Loot與其子類別型態
class LootBox<T : Loot>(vararg item: T) {
    var open = false
    private var loot: Array<out T> = item

    //17.5 覆寫運算子
    operator fun get(index: Int): T? = loot[index].takeIf { open }

    //17.2 定義泛型函數
    fun fetch(item: Int): T? {
        return loot[item].takeIf { open }
    }

    //17.3 使用多泛型參數
    //T在建立類別實體時由建構子引數決定，R則是在使用此函數時依引數類型決定
    fun <R> fetch(item: Int, lootModFunction: (T) -> R): R? {
        return lootModFunction(loot[item]).takeIf { open }
    }
}

open class Loot(val value: Int)
class Fedora(val name: String, value: Int) : Loot(value)
class Coin(value: Int) : Loot(value)

fun main(args: Array<String>) {
    //創造兩個同類型但不同泛型引數的物件
    val lootBoxOne: LootBox<Fedora> = LootBox(
        Fedora("a generic-looking fedora", 15),
        Fedora("a dazzling magenta fedora", 25)
    )
    val lootBoxTwo: LootBox<Coin> = LootBox(Coin(15))

    lootBoxOne.open = true
    lootBoxOne.fetch(1)?.run {
        println("You retrieve $name from the box!")
    }

    //17.3 傳入Fedora()，回傳Coin()
    val coin = lootBoxOne.fetch(0) {
        Coin(it.value * 3)
    }
    coin?.let { println(it.value) }

    //17.5 使用覆寫的get運算子讀取索引值為1的元素
    val fedora = lootBoxOne[1]
    fedora?.let { println(it.name) }
}


