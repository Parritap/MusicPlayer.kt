package model.logic

import model.logic.data.Song
import java.io.File

/**
 * This class is responsible for producing songs to the UI can show them when the app starts.
 */
class SongsProducer : Producer<Song> {

    //TODO We have to tell the producer where to find the songs

    val songsPath: String = PathFinder.getPath(PathFinder.SONG())
    val songsFound: MutableList<Song> = mutableListOf();

    /**
     * This method is responsible for finding the songs in the device and return them so the can be used by the UI.
     */
    override fun Produce(): Unit {
        searchSongs(songsPath);
    }

    override fun getProducts(): MutableList<Song> {
        return this.songsFound;
    }


    private fun searchSongs(songsPath: String) {
     val musicDir = File(songsPath) //
     val listOfFiles = musicDir.listFiles()

     for (aux : File in listOfFiles){
         if (aux.isDirectory) ""
     }

    }
}