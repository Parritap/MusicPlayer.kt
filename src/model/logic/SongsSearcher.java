package model.logic;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import model.logic.data.Song;

import java.util.ArrayList;
import java.util.LinkedList;

import java.util.List;

public class SongsSearcher {

    private static StringProperty songNameSearch = new SimpleStringProperty(){{
        addListener((observableValue, s, t1) -> {
            System.out.println("cambio!!");
        });
    }};
    private static LinkedList<Song> songsForSearch = new LinkedList(Singleton.getSongsFound());

    public static String getSongNameSearch() {
        return songNameSearch.get();
    }

    public static StringProperty songNameSearchProperty() {
        return songNameSearch;
    }

    public static List<Song> obtenerCancionesConCoincidencia(String nombre) {

        songsForSearch = new LinkedList<>(Singleton.getSongsFound());
        System.out.println(songsForSearch.toString());

        return songsForSearch.stream().filter( song -> song.getTitle().contains(nombre)).toList();

    }


}
