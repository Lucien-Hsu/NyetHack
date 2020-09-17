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
//    //10.3
//    //讀取檔案內容，分割後丟給List
//    //在此的檔案路徑為data/menu.txt
//    val menuList = File("data/menu.txt")
//        .readText()
//        .split("\n")
//    //印出
//    menuList.forEachIndexed{index, content ->
//        print("[$index]：$content\n")
//    }
//
//    //10.4
//    val testStr = "A,b,c,d,e,f,g,h"
//    //最多可解構前五個元素
//    //可用底線過濾掉不需解構的元素
//    val (x1,x2,x3,_,x5) = testStr.split(",")
//    print(x1 + " ")
//    print(x2 + " ")
//    print(x3 + " ")
//    print(x5 + " ")
//
//    //10.5
//    //宣告不可變集合
//    val planets = setOf("Earth", "Jupiter", "Mars", "Earth")   //會自動移除重複值
//    println(planets)
//    //檢查是否包含元素
//    println("包含Earth：" + planets.contains("Earth"))
//    println("包含Venus：" + planets.contains("Venus"))
//    //取指定元素
//    println("第2個元素為：" + planets.elementAt(1))
//    //宣告可變集合
//    val fruits = mutableSetOf("kiwi", "mango", "apple")
//    //增加元素
//    fruits += listOf("banana", "apple")
//    println(fruits)
//
//    //10.8
//    val firstList = mutableListOf("A", "B", "C", "A")
//    println(firstList)
//    //轉為set再轉為list可消除重複元素。
//    val secondList = firstList.toSet().toList()
//    println(secondList)
//    //使用distinct也可直接消除重複元素
//    val thirdList = firstList.distinct()
//    println(thirdList)
//
//    //10.9
//    //建立Java中的int基礎類型的陣列
//    val xx: IntArray = intArrayOf(1,2,3)
//    //建立List，但在需要時用toIntArray()轉換為int基礎類型的陣列
//    val yy: List<Int> = listOf(1,2,3)
//    val zz: IntArray = yy.toIntArray()

    //10.10
    //可變的情況一
    val o = listOf(mutableListOf(1,2,3))
    val p = listOf(mutableListOf(1,2,3))
    println(o == p)
    o[0].add(4)
    println(o == p)
    //可變的情況二
    var tmpList: List<Int> = listOf(1,2,3)
    (tmpList as MutableList)[2] = 1000
    println(tmpList)

}