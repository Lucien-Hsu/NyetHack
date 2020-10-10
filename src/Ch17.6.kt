//將泛型參數設為生產者，可以接收泛型參數類型的子類別了，但可讀不可寫
class Barrel<in T>(item: T)

fun main(args: Array<String>) {
    var fedoraBarrel: Barrel<Fedora> = Barrel(Fedora("a fedora", 15))
    //因泛型參數為生產者，所以這邊設定為Loot後則不可再改變
    var lootBarrel: Barrel<Loot> = Barrel(Coin(15))

    //在此的lootBarrel已被設定為Barrel<Loot>，並可接收泛型參數為子類別的物件
//    lootBarrel = fedoraBarrel
    fedoraBarrel = lootBarrel

    //lootBarrel的類型轉為Barrel<Fedora>
//    val myFedora: Fedora = lootBarrel.item
}