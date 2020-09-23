package com.bignerdranch.nyethack

//15.7
open class Weapon(val name: String, val type: String) {
    //覆寫 equals() and hashCode()
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is Weapon) return false

        if (name != other.name) return false
        if (type != other.type) return false

        return true
    }

    override fun hashCode(): Int {
        var result = name.hashCode()
        result = 31 * result + type.hashCode()
        return result
    }
}
