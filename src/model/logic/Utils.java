package model.logic;

import org.jaudiotagger.audio.AudioFile;
import org.jaudiotagger.audio.AudioFileIO;
import org.jaudiotagger.audio.asf.util.TagConverter;
import org.jaudiotagger.tag.datatype.Artwork;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Objects;

public class Utils {


    /**
     * Verifies if a String has the extensions listed in the enum SongsExtensions.
     */
    public static boolean isSong(String file) {
        int index = file.split("\\.").length - 1; //Esto apunta a la ultima posicion del array, que es la extension
        String ext = file.split("\\.")[index]; //Esto ya es la extension
        for (SongsExtensions songExt : SongsExtensions.values()) {
            if (songExt.getExtension().equals(ext)) return true;
        }
        return false;
    }

    private static void findFileWithExtension_aux(String path, SongsExtensions extension, ArrayList<String> list) {
        File file = new File(path);
        File[] listOfFiles = file.listFiles();
        for (File aux : listOfFiles) {
            if (aux.isDirectory()) findFileWithExtension_aux(aux.getPath(), extension, list);
            list.add(aux.getPath());
        }
    }

    public static ArrayList<String> findFilesWithExtension(String path, SongsExtensions extension) {
        ArrayList<String> list = new ArrayList<>();
        findFileWithExtension_aux(path, extension, list);
        return list;
    }

    public static ArrayList<String> findSongsInPath(String path) {
        ArrayList<String> list = new ArrayList<>();
        findSongsAux(path, list); // Adds any song found to the list passed
        return list;
    }

    private static void findSongsAux(String path, ArrayList<String> list) {
        File file = new File(path);
        for (File i : Objects.requireNonNull(file.listFiles())) {
            if (i.isDirectory()) findSongsAux(i.getPath(), list);
            else if (isSong(i.getPath())) list.add(i.getPath());
        }
    }

    public static Artwork getArtWorkNotNull(AudioFile audioFile) throws IOException {
        Artwork art = audioFile.getTag().getFirstArtwork();
        if (art == null) {
            URL path = Utils.class.getResource("../../resources/myResources/songGenericImage.png");
            return Artwork.createArtworkFromFile(new File(path.getPath()));
        } else {
            return art;
        }
    }
}
