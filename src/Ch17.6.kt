class Barrel<out T>(val item: T)

fun main(args: Array<String>) {
    var fedoraBarrel: Barrel<Fedora> = Barrel(Fedora("a fedora", 15))
    var lootBarrel: Barrel<Loot> = Barrel(Coin(15))

    lootBarrel = fedoraBarrel
//    var loot: Loot = Fedora("a fedora", 15)
//    lootBarrel.item = Coin(15)
    val myFedora: Fedora = fedoraBarrel.item
}