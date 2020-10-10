package com.bignerdranch.nyethack.extensions

//18.6 擴充
//18.9 定義擴充檔
fun <T> Iterable<T>.random(): T = this.shuffled().first()

