package model.logic;

import javafx.application.Platform;
import javafx.beans.property.Property;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.concurrent.Task;
import model.logic.bindingLayer.SongForBinding;
import model.logic.data.Song;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;
import java.util.Optional;

public class SongsPlayer {

    public static SongForBinding currentSong  = new SongForBinding();

    public static void playSong(Song song) {

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

        currentSong.setearCancion(song);
        (new Thread(() -> {
            while (true){
                Platform.runLater(() -> {
                    currentSong.incrementProgress();
                });

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        })).start();

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
}
