package com.bignerdranch.nyethack

import java.io.File

fun main(args: Array<String>) {
//    //9.1
//    //原寫法
//    val menuFile = File("menu.txt")
//    menuFile.setReadable(true)
//    menuFile.setWritable(true)
//    menuFile.setExecutable(true)
//
//    //改用apply的寫法
//    val menuFile2 = File("menu.txt").apply {
//        setReadable(true)
//        setWritable(true)
//        setExecutable(true)
//    }
//
//    //9.2
//    //原寫法
//    val a = listOf(1, 2, 3).first()
//    val b = a * a
//
//    //改用let的寫法
//    val a2 = listOf(1, 2, 3).first().let {
//        it * it
//    }
//
//    println(testFun("Ann"))

    //9.3
    fun nameIsLong(name: String) = name.length >= 20
    fun playerCreateMessage(nameTooLong: Boolean): String {
        return if (nameTooLong) {
            "Name is too long."
        } else {
            "Welcome~"
        }
    }
    //用花括號會出錯，尚不清楚原因
//    "I'm the king of the really cool kingdom."
//        .run { ::nameIsLong }
//        .run { ::playerCreateMessage }
//        .run { ::println}

    //用一般括號才正常運作
    "I'm the king of the really cool kingdom."
        .run(::nameIsLong)
        .run(::playerCreateMessage)
        .run(::println)

    //9.4
    val namrTooLong = with("I'm the king of the really cool kingdom.") {
        length >= 20
    }

    //9.5
    var fileContents: List<String>
    File("file.txt")
        .also {
            print(it.name)
        }.also {
            fileContents = it.readLines()
        }

    //9.6
    val fileContents2 = File("myfile.txt")
        .takeIf { it.canRead() && it.canWrite() }   //內容為true才做接下來的處理
        ?.readText()


}

fun testFun(str: String): String {
    return str?.let {
        "歡迎~ $it."
    } ?: "沒人來..."
}