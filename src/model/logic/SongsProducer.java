package model.logic;

import model.logic.data.Song;
import org.jaudiotagger.audio.AudioFileIO;
import org.jaudiotagger.tag.FieldKey;
import org.jaudiotagger.tag.datatype.Artwork;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * This class is responsible for producing songs so the UI can show them when the app starts.
 */
public class SongsProducer {


    private static final String songsPath = PathFinder.getMusicFolderPath();
    private static final ArrayList<Song> songsFound = new ArrayList<>();

    public static ArrayList<Song> getProducts() {
        searchSongs();
        return songsFound;
    }

    /**
     * This method is responsible for finding the songs in the given path and add them to the list of songs.
     */
    private static void searchSongs() {
        List<String> listOfSongs = Utils.findSongsInPath(SongsProducer.songsPath);
        List<Song> listOfSongObjects = new ArrayList<>();
        for (String songPath : listOfSongs) {
            listOfSongObjects.add(convertFileToSong(songPath));
        }
        songsFound.addAll(listOfSongObjects);
    }

    /**
     * Converts the given path into a Song and then returns it.
     *
     * @param path
     */
    public static Song convertFileToSong(String path) {
        Song song = null;
        try {
            org.jaudiotagger.audio.AudioFile audioFile = AudioFileIO.read(new File(path));
            org.jaudiotagger.tag.Tag tag = audioFile.getTag();
            String title = tag.getFirst(FieldKey.TITLE);
            String artist = tag.getFirst(FieldKey.ARTIST);
            String album = tag.getFirst(FieldKey.ALBUM);
            String year = tag.getFirst(FieldKey.YEAR);
            Artwork artWork = Utils.getArtWorkNotNull(audioFile);

            song = new Song(path, title, year, artist, album, artWork);
        } catch (Exception e) {
            System.out.println("Failed to convert file to song: " + e.getMessage());
        }
        return song;
    }
}
