package model.logic;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import model.logic.data.Song;

import java.util.ArrayList;
import java.util.LinkedList;

import java.util.List;

public class SongsSearcher {

    private static StringProperty songNameSearch = new SimpleStringProperty("");

    private static LinkedList<Song> songsForSearch = new LinkedList<>(Singleton.getSongsFound());


    public static StringProperty songNameSearchProperty() {
        return songNameSearch;
    }

    public static List<Song> obtenerCancionesConCoincidencia(String nombre) {


        return songsForSearch.stream().filter( song -> song.getTitle().contains(nombre)).toList();

    }

}
