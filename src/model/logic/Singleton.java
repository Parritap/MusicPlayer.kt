package model.logic;

import app.App;
import lombok.Getter;
import lombok.Setter;
import model.logic.data.Song;
import model.logic.data.User;

import javax.sound.sampled.*;
import java.util.ArrayList;

@Getter
@Setter
public class Singleton {


    private static volatile Singleton INSTANCE;
    private OS operatingSystem;
    private ArrayList<Song> songsFound;
    private ArrayList <User> userList;
    private Clip audioClip;

    {
        try {
            audioClip = AudioSystem.getClip();
        } catch (LineUnavailableException e) {
            throw new RuntimeException(e);
        }
    }

    private  Song currentSong;
    private User currentUser;
    private App app;

    private Singleton() {
    }

    public static Singleton getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new Singleton();
            System.out.println("Singleton instance created");
            INSTANCE.operatingSystem = OS.getOperatingSystem();
            INSTANCE.songsFound = SongsProducer.getProducts();
            INSTANCE.app = new App();
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
