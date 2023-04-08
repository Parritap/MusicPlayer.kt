package model.logic

import model.logic.data.Song
import model.logic.interfaces.Producer
import org.jaudiotagger.audio.AudioFileIO
import org.jaudiotagger.tag.FieldKey
import org.jaudiotagger.tag.datatype.Artwork
import java.io.File

/**
 * This class is responsible for producing songs to the UI can show them when the app starts.
 */
object SongsProducer : Producer<Song> {



    //TODO We have to tell the producer where to find the songs

    val songsPath: String = PathFinder.getMusicFolderPath()
    val songsFound: MutableList<Song> = mutableListOf();

    /**
     * This method is responsible for finding the songs in the device and return them so the can be used by the UI.
     */
    override fun produce(): Unit {
        searchSongs(songsPath);
    }

    override fun getProducts(): MutableList<Song> {
        return this.songsFound;
    }

    /**
     * This method is responsible for finding the songs in the given path and add them to the list of songs.
     */
    private fun searchSongs(songsPath: String) {
        val listOfSongs = Utils.findSongsInPath(songsPath)
        val listOfSongObjects = listOfSongs.map { convertFileToSong(it) }
        songsFound.addAll(listOfSongObjects)
    }

    /**
     * Converts the given path into a Song and the returns it.
     * @param path
     */
    fun convertFileToSong(path: String): Song {
        val audioFile = AudioFileIO.read(File(path))
        val tag = audioFile.tag
        val title = tag.getFirst(FieldKey.TITLE)
        val artist = tag.getFirst(FieldKey.ARTIST)
        val album = tag.getFirst(FieldKey.ALBUM)
        val year = tag.getFirst(FieldKey.YEAR)
        val artWork: Artwork = Utils.getArtWorkNotNull(audioFile)

        return Song(path, title, year, artist, album, artWork)
    }
}