package app

import model.logic.Singleton

fun main( args : Array<String>) {
   val properties : String = System.getProperties().toString();
    //println(properties)
    println("/home/${System.getProperty("user.name")}/Music");
    //print the operating system of the computer
    println(System.getProperty("os.name"))
    Singleton


}
