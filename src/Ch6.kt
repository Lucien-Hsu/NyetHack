fun main(args: Array<String>){
//    //6.4.1
//    //讀入引數並印出
//    print("請輸入飲料：")
//    //var beverage = readLine().capitalize()    //錯誤
//    var beverage = readLine()?.capitalize()     //正確，使用安全呼叫運算子
//    println(beverage)
//
//    //以 let 做進一步處理
//    print("請輸入飲料：")
//    var beverage2 = readLine()?.let{
//        if (it.isNotBlank()){
//            it.capitalize()
//        }else{
//            "Buttered Ale"
//        }
//    }
//    println(beverage2)
//
//    //6.4.2
//    print("請輸入飲料：")
//    var beverage3 = readLine()!!.capitalize()     //使用非空斷言
//    println(beverage3)
//
//    //6.4.3
//    print("請輸入飲料：")
//    var beverage4 = readLine()
//
//    beverage4 = null    //設定為 null
//    if(beverage4 != null){
//        beverage4 = beverage4.capitalize()
//        println(beverage4)
//    }else{
//        println("beverage was null!")   //輸出此行
//    }

    //6.4.3_2
    //空合併運算子
    print("請輸入飲料：")
    var beverage5 = readLine()
    val beverageServed: String = beverage5 ?: "Buttered Ale"
    println(beverageServed)

    //空合併運算子搭配 let
    print("請輸入飲料：")
    var beverage6 = readLine()
    beverage6?.let{
        beverage6 = it.capitalize()
    } ?: println("beverage was null!")

    //6.5









}