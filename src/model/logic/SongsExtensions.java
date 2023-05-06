package model.logic;

public enum SongsExtensions {
    FLAC("flac"), MP3("mp3"), M4A("m4a"), MP4("mp4");
    public static final SongsExtensions[] listOfExtensions = SongsExtensions.values();
    private final String extension;
    SongsExtensions(String extension) {
        this.extension = extension;
    }
    public String getExtension() {
        return extension;
    }
}
