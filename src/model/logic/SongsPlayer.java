package model.logic;

import javafx.application.Platform;
import javafx.beans.property.Property;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.concurrent.Task;
import model.logic.bindingLayer.SongForBinding;
import model.logic.data.Song;
import model.logic.threads.SliderUptaderThread;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicBoolean;

public class SongsPlayer {

    public static SongForBinding currentSong  = new SongForBinding();
    private static SliderUptaderThread sliderUptader;

    public static void playSong(Song song) {

        if (sliderUptader != null) sliderUptader.stop();

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
        sliderUptader = new SliderUptaderThread("slider uptader", currentSong);

    }

    public static void pauseCurrentSong() {

        Optional.of(currentSong).ifPresent(song -> {
            Clip audioClip = Singleton.getInstance().getAudioClip();
            Optional.of(audioClip).ifPresent((clip -> {
                Optional.of(sliderUptader).ifPresent(uptader -> {

                    uptader.interrupt();
                    clip.stop();

                });
            }));
        });
    }

    public static void continueCurrentSong() {

        Optional.of(currentSong).ifPresent(song -> {
            Clip audioClip = Singleton.getInstance().getAudioClip();
            Optional.of(audioClip).ifPresent((clip -> {
                Optional.of(sliderUptader).ifPresent(uptader -> {

                    if (uptader.isInterrupted()) uptader.start();
                    clip.start();

                });
            }));
        });
    }
}
