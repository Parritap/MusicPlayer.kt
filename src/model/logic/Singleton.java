package model.logic;

import model.logic.data.Song;

import java.sql.SQLOutput;
import java.util.ArrayList;

public class Singleton {


    private static Singleton instance = null;
    private final OS operatingSystem = OS.detectOperatingSystem();
    private final ArrayList<Song> songsFound =  SongsProducer.getProducts();

    private Singleton() {
        // private constructor to prevent instantiation
    }

    public static Singleton getInstance() {
        if (instance == null) {
            synchronized (Singleton.class) {
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }
        System.out.println("Singleton instance created");
        SongsProducer.produce(); //////////////////////////////////////////////////////////////////////////////////
        return instance;
    }

    public static OS getOperatingSystem() {
        return Singleton.getInstance().operatingSystem;
    }

    public static  ArrayList<Song> getSongsFound() {
        return Singleton.getInstance().songsFound;
    }
}
