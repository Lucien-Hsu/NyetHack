package com.bignerdranch.nyethack

class Player3{
    //延遲初始化
    lateinit var alignment: String

    fun determineFate(){
        alignment = "GOOD"
    }

    fun proclaimFate(){
        //可用.isInitialized檢查是否已經初始化
        if (::alignment.isInitialized) println(alignment)
    }
}

//13.7
fun main(args: Array<String>) {
    val w = Sword("Allen")
    println(w.name)
    w.name = "Joy"
    println(w.name)
}

class Sword(_name: String){
    var name = _name
        get() = "The Legendary $field"
        set(value){
            field = value.toLowerCase().reversed().capitalize()
        }

    //若不使用以下初始化區塊，則不會使用name的setter來設定值
    init{
        name = _name
    }
}

