import kotlin.system.measureNanoTime
import kotlin.system.measureTimeMillis

fun main(args: Array<String>) {
    //map
    val animals = listOf("zebra", "giraffe", "cat")
    val babies = animals
        .map { animal -> "A baby $animal" }
        .map { baby -> "$baby, with little tail.\n" }

    println(babies)

    //flatMap
    val myList = listOf(listOf(1,2,3), listOf(4,5,6)).flatMap { it }
    println(myList)

    //filter
    val item = listOf(listOf("red apple", "green apple"), listOf("red fish", "blue fish"))
    val redItem = item.flatMap { it.filter { it.contains("red") } }
    println(redItem)

    //zip
    val name = listOf("Ann", "Bob")
    val size = listOf("M", "L")
    //合併後成為鍵值對的集合，再轉換為Map集合
    val nameShirtSize = name.zip(size).toMap()
    println(nameShirtSize)

    //fold
    //accumulator為累加器初始值，這邊是0
    //number為集合中的元素值，會不斷尋訪
    val foldedValue = listOf(1,2,3).fold(0){accumulator, number ->
        println("value: $accumulator")
        accumulator + (number * 3)
    }
    println("Final value: $foldedValue")

    //generateSequence
    generateSequence(0) { it + 1 }
        .onEach { println("$it hi~") }

    //19.4
    //返回奈秒時間
    val m01 = measureNanoTime {
        //要測量時間的程式碼
    }

    //返回豪秒時間
    val m02 = measureTimeMillis {
        //要測量時間的程式碼
    }

    //19.5
//    fun parse(s: String): Either<NumberFormatException, Int> =
//        if (s.matches(Regex("-?[0-9]"))){
//            Either.Right(s.toInt())
//        }else{
//            Either.Left(NumberFormatException("$s is not a valid integer"))
//        }
//
//    val value = when(x){
//        is Either.Left -> when(x.a){
//            is java.lang.NumberFormatException -> "Not a number!"
//            else -> "Unknown error"
//        }
//        is Either.Right -> "Number that was parsed: ${x.b}"
//    }

    //19.6 Map鍵值反轉
    val gradesByStudent = mapOf("Ann" to 4.0, "Bob" to 2.0, "Cathy" to 3.0)
    println(gradesByStudent)
    println(flipValue(gradesByStudent))
}

//19.6
fun flipValue(gradesByStudent: Map<String, Double>): Map<Double, String> {
    //用toList()將Map轉為List
    //用unzip分割鍵值對列表，產生包含鍵集合與值集合這兩個元素的List
    //選擇第二個元素(值集合)，並使用zip雙路合併第一個元素
    //最後轉為Map
    val newMap = gradesByStudent.toList().unzip().second
        .zip(
            gradesByStudent.toList().unzip().first
        ).toMap()

    return newMap
}

