package model.logic;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import model.logic.data.Song;
import model.logic.dataStructures.LinkedList;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.TreeMap;

public class SongsSearcher {

    private static StringProperty songNameSearch = new SimpleStringProperty("");

    private static LinkedList<Song> songsForSearch = new LinkedList<>(Singleton.getSongsFound());


    public static StringProperty songNameSearchProperty() {
        return songNameSearch;
    }

    public static List<Song> obtenerCancionesConCoincidencia(String nombre) {

        List<Song> songsFound = new ArrayList<>();
        for (int i = 0; i < songsForSearch.size(); i++){
            Song song = songsForSearch.get(i);
            if(song.getTitle().toLowerCase().contains(nombre.toLowerCase())) {
                songsFound.add(song);
            }
        }

        return songsFound;
    }
}
