package model.logic.threads;

import javafx.application.Platform;
import model.logic.bindingLayer.SongForBinding;
import model.logic.data.Song;

import java.util.concurrent.atomic.AtomicBoolean;

public class SliderUptaderThread implements Runnable {

    public AtomicBoolean exit = new AtomicBoolean();
    public SongForBinding currentSong;

    private String name;
    private Thread t;
    public SliderUptaderThread(String name, SongForBinding currentSong){
        this.currentSong = currentSong;
        this.name = name;
        t = new Thread(this, name);
        // for testing: System.out.println("New thread: " + t);
        exit.set(false);
        t.start(); // Starting the thread
    }

    // execution of thread starts from run() method
    public void run() {
        updateSongProgress();
    }

    public void updateSongProgress() {
        while (currentSong.progressProperty().lessThan(currentSong.durationProperty()).get() && !exit.get()){
            Platform.runLater(() -> {
                currentSong.incrementProgress();
            });

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {}
        }
    }

    // for stopping the thread
    public void kill() { stop(); }

    public void interrupt() { stop(); }

    public void start() { t.start(); }

    public void contin() {
        exit.set(false);
        t = new Thread(this, name);
        t.start();
    }

    // public boolean isInterrupted() { return t.isInterrupted(); }

    public boolean isAlive() {
        return t.isAlive();
    }

    public void stop(){
        exit.set(true);
    }
}
