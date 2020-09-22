package com.bignerdranch.nyethack

//15.4 列舉類型
enum class Direction(private val coordinate: Coordinate) {
    //列舉常數
    NORTH(Coordinate(0, -1)),
    EAST(Coordinate(1, 0)),
    SOUTH(Coordinate(0, 1)),
    WEST(Coordinate(-1, 0));    //最後的列舉常數要加上分號

    //列舉類別函數
    fun updateCoordinate(playerCoodinate: Coordinate) =
        Coordinate(
            playerCoodinate.x + coordinate.x,
            playerCoodinate.y + coordinate.y
        )
}
//呼叫列舉常數的方法
//Direction.EAST.updateCoordinate(Coordinate(1, 0))

data class Coordinate(val x: Int, val y: Int) {
    val isInBounds = x >= 0 && y >= 0
}