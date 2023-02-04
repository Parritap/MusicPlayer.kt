package model.logic

interface Producer <T> {
    fun Produce() : Unit;
    fun getProducts() : MutableList<T>
}