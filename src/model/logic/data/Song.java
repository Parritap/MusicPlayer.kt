package model.logic.data;

import javafx.embed.swing.SwingFXUtils;
import javafx.scene.image.Image;
import org.jaudiotagger.tag.datatype.Artwork;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

public class Song {
    private String path = "";
    private String title = "";
    private String year = "";
    private String artist = "";
    private String album = "";
    private Artwork artWork = null;

    public Song() {
    }

    public Song(String path, String title, String year, String artist, String album, Artwork artwork) {
        this.path = path;
        this.title = title;
        this.year = year;
        this.artist = artist;
        this.album = album;
        this.artWork = artwork;

        // test
        System.out.println(path);
    }

    public Image getImageFromArtWork() {
        try {
            if (artWork != null) {
                byte[] imageData = artWork.getBinaryData();
                InputStream inputStream = new ByteArrayInputStream(imageData);
                BufferedImage bufferedImage = ImageIO.read(inputStream);
                return SwingFXUtils.toFXImage(bufferedImage, null);
            }
        } catch (IOException e) {
            // ignore
        }
        return new Image("../../../resources/myResources/littleDoggy.png");
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public Artwork getArtWork() {
        return artWork;
    }

    public void setArtWork(Artwork artWork) {
        this.artWork = artWork;
    }
// getters and setters
    // ...

}
