package model.logic

import javafx.*
import javafx.scene.layout.Pane

interface UIElement   {

    abstract val pane : Pane

    fun getPane () : Pane

}