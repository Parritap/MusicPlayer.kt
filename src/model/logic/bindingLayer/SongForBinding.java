package model.logic.bindingLayer;

import javafx.application.Platform;
import javafx.beans.property.*;
import javafx.scene.image.Image;
import model.logic.Singleton;
import model.logic.data.Song;

public class SongForBinding {

    StringProperty title = new SimpleStringProperty();
    StringProperty artist = new SimpleStringProperty();
    ObjectProperty<Image> image = new SimpleObjectProperty<>();
    IntegerProperty duration = new SimpleIntegerProperty();
    IntegerProperty progress = new SimpleIntegerProperty();

    public void setearCancion(Song song) {

        title.setValue(song.getTitle());
        artist.setValue(song.getArtist());
        image.setValue(song.getImageFromArtWork());

        // potentially bad
        duration.setValue(Singleton.getInstance().getAudioClip().getMicrosecondLength() / 1000000);
        progress.setValue(0);

    }

    public void incrementProgress(){
        if (progress.lessThan(duration).getValue()) {
            progress.setValue(progress.add(1).get());
        }
    }

    public String getTitle() {
        return title.get();
    }

    public StringProperty titleProperty() {
        return title;
    }

    public void setTitle(String title) {
        this.title.set(title);
    }

    public String getArtist() {
        return artist.get();
    }

    public StringProperty artistProperty() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist.set(artist);
    }

    public Image getImage() {
        return image.get();
    }

    public ObjectProperty<Image> imageProperty() {
        return image;
    }

    public void setImage(Image image) {
        this.image.set(image);
    }

    public int getDuration() {
        return duration.get();
    }

    public IntegerProperty durationProperty() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration.set(duration);
    }

    public int getProgress() {
        return progress.get();
    }

    public IntegerProperty progressProperty() {
        return progress;
    }

    public void setProgress(int progress) {
        this.progress.set(progress);
    }
}
