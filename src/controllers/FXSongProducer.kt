package controllers

import javafx.fxml.FXMLLoader
import javafx.scene.Parent
import javafx.scene.layout.Pane
import model.logic.data.Song
import sun.security.x509.OIDMap.getClass
import java.util.*
import java.lang.Class.*

class FXSongProducer {
   var song : Song = Song()
   var Pane = Pane();

   fun getPane () : Pane {
      val root : Parent = FXMLLoader.load(ge+tClass().getResource("/view/SongView.fxml"))
   }
}