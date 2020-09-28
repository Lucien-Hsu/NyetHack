//定義String的擴充函數
fun String.addEnthusiasm(amount: Int = 1) = this + "!".repeat(amount)
//定義超類別Any的擴充函數
//fun Any.easyPrint() = print(this)
//以泛型改寫為支援鍊式呼叫
fun <T> T.easyPrint(): T{
    println(this)
    return this
}

fun main(args: Array<String>) {
    //使用String的擴充函數
    println("Hello".addEnthusiasm())
    println("BYE".addEnthusiasm(3))
    //使用超類別Any的擴充函數
    "Welcome~\n".easyPrint()
    886.easyPrint()
    //使用支援鍊式呼叫的函數
    "Hi~Hi~~~".easyPrint().addEnthusiasm(3).easyPrint()

}