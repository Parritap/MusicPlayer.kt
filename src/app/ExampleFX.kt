package app

//Create a class called ExampleFX that extends javafx.application.Application
class ExampleFX : javafx.application.Application() {
    //Override the start method
    override fun start(primaryStage: javafx.stage.Stage) {
        //Create a new Label with the text "Hello World"
        val label =  javafx.scene.control.Label("Hello World")
        //Create a new Scene with the label as the root node
        val scene = javafx.scene.Scene(label)
        //Set the scene on the stage
        primaryStage.scene = scene
        //Show the stage
        primaryStage.show()
    }
}