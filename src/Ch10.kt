import java.io.File

fun main(args: Array<String>) {
//    //宣告List
//    val myList: List<String> = listOf("Ann", "Bob", "Coco")
//
//    println(myList[0])      //印出第0個元素
//    //println(myList[3])      //試圖印出第4個元素，會拋出"ArrayIndexOutOfBoundsException"異常
//    println(myList.getOrElse(3){"無字串"})      //印出第3個元素，採用"安全索引取值函數"
//    println(myList.getOrNull(3)?: "無字串")       //印出第3個元素，採用"安全索引取值函數"
//
//    println(myList.first()) //印出List第一個元素
//    println(myList.last())  //印出List最後一個元素
//
//    //檢查元素是否被包含
//    //注意，這邊檢查的是元素結構，而非參照。
//    if(myList.contains("Ann")){
//        println("Ann is here.")
//    }
//    //檢查多個元素是否被包含
//    if(myList.containsAll(listOf("Ann", "Bob"))){
//        println("Ann and Bob are here.")
//    }
//
//    //10.1.2
//    //宣告List
//    val myMutableList: MutableList<String> = mutableListOf("Ann", "Bob", "Coco")
//
//    println("MutableList：" + myMutableList)
//    myMutableList.remove("Ann") //移除元素
//    println("移除元素：" + myMutableList)
//    myMutableList.add("Alex")           //增加元素，一律加在最後
//    println("增加元素：" + myMutableList)
//    myMutableList -= "Alex"             //刪除元素運算子
//    println("刪除元素運算子：" + myMutableList)
//    myMutableList += listOf("GOD", "DEVIL")              //增加元素運算子
//    println("增加元素運算子：" + myMutableList)
//    myMutableList.addAll(listOf("Xeon", "Yaya", "Zoe"))  //增加多個元素
//    println("增加多個元素：" + myMutableList)
//    myMutableList.add(0, "New")  //增加元素，並指定放在索引0的位置
//    println("增加指定位置元素(0)：" + myMutableList)
//
//    myMutableList[1] = "Bell"           //更改指定元素
//    println("更改指定元素(1)：" + myMutableList)
//
//    //將MutableList轉換為List
//    val readOnlyList = myMutableList.toList()
//    println("MutableList -> List：" + myMutableList)
//
//    //10.2
//    val myList2 = listOf("A", "B", "C")
//    for(word in myList2)print(word + ",")       //以for迴圈巡訪
//    println()
//    myList2.forEach{ word -> print(word + "/")} //以forEach巡訪
//    println()
//    myList2.forEachIndexed{index, word ->       //以forEachIndexed巡訪
//        println("第${index}個元素為：$word")
//    }
//
    //10.3
    //讀取檔案內容，分割後丟給List
    //在此的檔案路徑為data/menu.txt
    val menuList = File("data/menu.txt")
        .readText()
        .split("\n")
    //印出
    menuList.forEachIndexed{index, content ->
        print("[$index]：$content\n")
    }


}