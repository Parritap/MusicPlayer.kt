package model.logic

interface Producer <T> {
    fun produce() : Unit;
    fun getProducts() : MutableList<T>
}