package model.logic;

import javafx.beans.property.Property;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import model.logic.data.Song;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;
import java.util.Optional;

public class SongsPlayer {

    public static Song currentSong;

    //test
    public static SimpleStringProperty name = new SimpleStringProperty();
    public static SimpleDoubleProperty duration = new SimpleDoubleProperty();

    public static void playSong(Song song) {

        currentSong = song;
        Clip audioClip = Singleton.getInstance().getAudioClip();

        if (song != null) {
            if (audioClip != null) {
                audioClip.stop();
                audioClip.close();
            }

            try {
                AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(song.getWavFilePath()));
                audioClip = AudioSystem.getClip();
                audioClip.open(audioInputStream);
                audioClip.start();
            } catch (Exception e) {
                throw new RuntimeException("song cannot be played by the singleton %n%s".formatted(e.getMessage()));
            }

            Singleton.getInstance().setAudioCLip(audioClip);
        }
    }

    public static void pauseCurrentSong() {

        Optional.of(currentSong).ifPresent(song -> {
            Clip audioClip = Singleton.getInstance().getAudioClip();
            Optional.of(audioClip).ifPresent((clip -> {
                clip.stop();
            }));
        });
    }

    public static void continueCurrentSong() {

        Optional.of(currentSong).ifPresent(song -> {
            Clip audioClip = Singleton.getInstance().getAudioClip();
            Optional.of(audioClip).ifPresent((clip -> {
                clip.start();
            }));
        });
    }

    //test
    public static void testMethod(){
        name.setValue("hola mundo");
    }

    public static void secondTestMethod() { duration.setValue(10); }
}
