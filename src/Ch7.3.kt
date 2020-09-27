fun main(args: Array<String>) {
    val a = "aaa"
    //直接宣告時，若宣告字串的值已存在，則Kotlin會自動指向同一參照，所以必定為同物件
    //val b = "aaa"
    //應該這樣宣告才是不同物件
    val b = String().plus("aaa")
    println("[b=$b]")

    //字串比較
    if(a == b)println("a、b 字串相同")
    //參照比較
    if(a === b)println("a、b 物件相同")
}

