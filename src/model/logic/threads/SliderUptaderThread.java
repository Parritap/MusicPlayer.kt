package model.logic.threads;

import javafx.application.Platform;
import model.logic.bindingLayer.SongForBinding;
import model.logic.data.Song;

public class SliderUptaderThread implements Runnable {

    public boolean exit;
    public SongForBinding currentSong;

    private String name;
    private Thread t;
    public SliderUptaderThread(String name, SongForBinding currentSong){
        this.currentSong = currentSong;
        this.name = name;
        t = new Thread(this, name);
        // for testing: System.out.println("New thread: " + t);
        exit = false;
        t.start(); // Starting the thread
    }

    // execution of thread starts from run() method
    public void run() {
        while (currentSong.progressProperty().lessThan(currentSong.durationProperty()).get() && !exit){
            Platform.runLater(() -> {
                currentSong.incrementProgress();
            });

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {}
        }
    }

    // for stopping the thread


    public boolean isInterrupted() {
        return t.isInterrupted();
    }

    public void start() {
        t.start();
    }

    public boolean isAlive() {
        return t.isAlive();
    }

    public void interrupt() {
        t.interrupt();
    }

    public void stop(){
        exit = true;
    }
}
