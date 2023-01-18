package app

import javafx.application.Application
import javafx.scene.Scene
import javafx.scene.layout.BorderPane
import javafx.stage.Stage

class App : Application (){

    override fun start(primaryStage: Stage) {
        val root = BorderPane()
        val scene = Scene(root, 300.0, 300.0)
        primaryStage.scene = scene
        primaryStage.show()
    }

    fun main(args: Array<String>) {
        start (Stage())
    }


}