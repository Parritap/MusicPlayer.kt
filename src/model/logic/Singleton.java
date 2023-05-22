package model.logic;

import model.logic.data.Song;

import javax.sound.sampled.*;
import java.util.ArrayList;

public class Singleton {


    private static volatile Singleton INSTANCE;
    private OS operatingSystem;
    private ArrayList<Song> songsFound;

    private Clip audioClip;

    private  Song currentSong;

    private Singleton() {
    }

    public static Singleton getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new Singleton();
            System.out.println("Singleton instance created");
            INSTANCE.operatingSystem = OS.getOperatingSystem();
            INSTANCE.songsFound = SongsProducer.getProducts();
        }
        return INSTANCE;
    }



    public static OS getOperatingSystem() {
        return Singleton.getInstance().operatingSystem;
    }

    public static ArrayList<Song> getSongsFound() {
        return Singleton.getInstance().songsFound;
    }

    public void setAudioCLip(Clip audioClip) {
        this.audioClip = audioClip;
    }

    public Clip getAudioClip() {
        return audioClip;
    }

}
