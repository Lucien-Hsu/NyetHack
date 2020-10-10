//
//import java.lang.Thread.sleep
//import java.net.URL
//
////以常數紀錄Web API端點
//private const val DATA_API = "https://chargen-api.herokuapp.com"
//
//fun main(args: Array<String>) {
//
//    sleep(1000)
//    GlobalScope.launch{
//
//    }
//    launch(UI){
//
//    }
////    var str: String = fromApiData("Monster,Jack,3,2,1")
//    var str: String = fetchCharacterData()
//    println(str)
//}
//
//fun fromApiData(apiData: String): String {
//    val (race, name, dex, wis, str) = apiData.split(",")
//    return "$race : $name : $dex : $wis : $str"
//}
//
//fun fetchCharacterData(): Deferred<String> {
//    return async {
//        val apiData = URL(DATA_API).readText()
//        apiData
//    }
//}
