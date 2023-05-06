package model.logic.data;

import java.util.ArrayList;

public class Artist {
    private String name;
    private ArrayList<Album> albums;

    public Artist(String name, ArrayList<Album> albums) {
        this.name = name;
        this.albums = albums;
    }

    public Artist(ArrayList<Album> albums) {
        this("nul", albums);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Album> getAlbums() {
        return albums;
    }

    public void setAlbums(ArrayList<Album> albums) {
        this.albums = albums;
    }
}
