fun main(){

    //給B()引數，所以會執行B()，因此印出"X"
    //B("X")執行完畢，回傳"(String) -> String"類型之lambda，
    // 然後println會將其印出
    println(B("X"))
    println("------------")

    //給B()引數，所以會執行B()，因此印出"X"
    //B("X")執行完畢，回傳"(String) -> String"類型之lambda，
    // 然後此lambda又被賦予"Y"引數，於是執行lambda，
    // 然後回傳"String"類型之結果(即lambda之最後一行)，然後println會將其印出
    println(B("X")("Y"))
    println("------------")

    //給B()引數，所以會執行B()，因此印出"X"
    //B("X")執行完畢，回傳"(String) -> String"類型之lambda給A，因此A是"(String) -> String"類型之lambda
    //接著給與A()一個"Y"引數來執行此lambda，執行完畢回傳"String"類型之結果(即lambda之最後一行)，然後println會將其印出
    var A: (String) -> String = B("X")
    println(A("Y"))
}

fun B(str1: String): (String) -> String{
    println( str1 )
    return {"[$it]"}
}