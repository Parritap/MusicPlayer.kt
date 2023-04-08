package model.logic.interfaces

interface Subject {

    fun attach(observer: Observer) : Unit
    fun detach(observer: Observer) : Unit
    fun notifyObservers() : Unit
}