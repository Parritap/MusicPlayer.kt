package model.logic;

import model.logic.data.Song;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import java.io.File;
import java.util.Optional;

public class SongsPlayer {

    public static void playSong(Song song) {

        Clip audioClip = Singleton.getInstance().getAudioClip();

        if (song != null) {
            if (audioClip != null) {
                audioClip.stop();
                audioClip.close();
            } else {
                try {
                    audioClip = AudioSystem.getClip();
                } catch (LineUnavailableException e) {
                    throw new RuntimeException("cannot get the audio clip by the singleton %n%s".formatted(e.getMessage()));
                }
            }

            try {
                AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(song.getPath()));
                audioClip = AudioSystem.getClip();
                audioClip.open(audioInputStream);
                audioClip.start();
            } catch (Exception e) {
                throw new RuntimeException("song cannot be played by the singleton %n%s".formatted(e.getMessage()));
            }

            Singleton.getInstance().setAudioCLip(audioClip);
        }

    }

}
