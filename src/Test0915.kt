fun main(args: Array<String>) {
    //宣告List
    val myList: List<String> = listOf("Ann", "Bob", "Coco")

    println(myList[0])      //印出第0個元素
    //println(myList[3])      //試圖印出第3個元素，會拋出"ArrayIndexOutOfBoundsException"異常
    println(myList.getOrElse(3){"無字串"})      //印出第3個元素，採用"安全索引取值函數"
    println(myList.getOrNull(3)?: "無字串")       //印出第3個元素，採用"安全索引取值函數"

    println(myList.first()) //印出List第一個元素
    println(myList.last())  //印出List最後一個元素

    //檢查元素是否被包含
    //注意，這邊檢查的是元素結構，而非參照。
    if(myList.contains("Ann")){
        println("Ann is here.")
    }
    //檢查多個元素是否被包含
    if(myList.containsAll(listOf("Ann", "Bob"))){
        println("Ann and Bob are here.")
    }
}