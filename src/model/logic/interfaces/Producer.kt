package model.logic.interfaces

interface Producer <T> {
    fun produce() : Unit
    fun getProducts() : MutableList<T>
}