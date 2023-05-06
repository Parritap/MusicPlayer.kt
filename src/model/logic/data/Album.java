package model.logic.data;

import java.util.ArrayList;

public class Album {
    private String name;
    private String coverPath;
    private String year;
    private String artist;
    private ArrayList<Song> songList;

    public Album(String name, String coverPath, String year, String artist, ArrayList<Song> songList) {
        this.name = name;
        this.coverPath = coverPath;
        this.year = year;
        this.artist = artist;
        this.songList = songList;
    }

    public Album(String name, String coverPath, ArrayList<Song> songList) {
        this(name, coverPath, "SomeDateIn2000s", "Unknown", songList);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCoverPath() {
        return coverPath;
    }

    public void setCoverPath(String coverPath) {
        this.coverPath = coverPath;
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

    public ArrayList<Song> getSongList() {
        return songList;
    }

    public void setSongList(ArrayList<Song> songList) {
        this.songList = songList;
    }
}
