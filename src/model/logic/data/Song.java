package model.logic.data;

import javafx.embed.swing.SwingFXUtils;
import javafx.scene.image.Image;
import lombok.Getter;
import lombok.Setter;
import org.jaudiotagger.tag.datatype.Artwork;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;


@Getter
@Setter

public class Song implements Comparable {
    private String path = "";
    private String title = "";
    private String year = "";
    private String artist = "";
    private String album = "";
    private Artwork artWork = null;

    private String wavFilePath;

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


    @Override
    public int compareTo(Object anotherSong) {
        return this.toString().compareTo(((Song) anotherSong).toString());
    }

    @Override
    public String toString(){
        return this.title;
    }
}
