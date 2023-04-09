package model.logic.data

import javafx.embed.swing.SwingFXUtils
import javafx.scene.image.Image
import org.jaudiotagger.tag.datatype.Artwork

class Song (){
    var path: String = ""
    var title: String = ""
    var year: String = ""
    var artist: String = ""
    var album: String = ""
    var artWork: Artwork? = null


    constructor (path: String, title : String, year : String, artist : String, album : String, artwork: Artwork) : this(){
        this.path = path
        this.title = title
        this.year = year
        this.artist = artist
        this.album = album
        this.artWork = artwork
    }

    fun getImageFromArtWork () : Image{
        var img : Image
        try {
            img =  SwingFXUtils.toFXImage(artWork?.image,null);
        } catch (e: Exception) {
            img = Image("../../../resources/myResources/littleDoggy.png")
        }
        return img;
    }
}


