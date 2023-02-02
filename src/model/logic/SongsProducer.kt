package model.logic

import model.Singleton
import model.Song

/**
 * This class is responsible for producing songs to the UI can show them when the app starts.
 */
class SongsProducer : Producer<Song> {

    //TODO We have to tell the producer where to find the songs

    val songsPath: String = Singleton.
    val songsFound: MutableList<Song> = mutableListOf();

    /**
     * This method is responsible for finding the songs in the device and return them so the can be used by the UI.
     */
    override fun Produce(): Song {
        searchSongs(songsPath);
    }

    private fun searchSongs(songsPath: String) {

    }
}