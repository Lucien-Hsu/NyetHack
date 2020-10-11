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


}

