fun main(args: Array<String>) {
    //1.直接使用匿名函數
    {println("我是單純的匿名函數")}()

    //2.建立一個Function Type變數存放並使用匿名函數
    val show = {
        val who = "以Function Type變數存放的匿名函數"
        println("我是$who")
    }
    show    //此行不執行，因為沒有括號
    show()

    //3.以Function Type變數存放匿名函數，有String類型的引數與String類型的回傳值
    val show2: (String) -> (String) = {
        val who = "以Function Type變數存放的匿名函數，而且我有String類型的引數與String類型的回傳值"
        //Lambda的最後一行就是預設的回傳值
        //當只有一個引數時，可以用it來代表
        "$it 你好，我是$who"
    }
    println(show2("宅男さま"))

    //4.使用函數參照
    //4.1.定義一個要被參照的函數
    fun show3(str: String): String{
        return "$str [我是被參照的函數]"
    }
    //4.2.定義一個使用函數類型作為參數的函數
    fun reallyShow(myFun: (String) -> String){
        println(myFun("呼叫被參照函數:"))
    }
    //4.3.使用函數參照類型的引數呼叫
    reallyShow(::show3)
}


