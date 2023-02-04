package model.logic

enum class SongsExtensions(val extension: String) {
    FLAC("flac"), MP3("mp3"), M4A("m4a"), MP4("mp4");

    companion object {
        val listOfExtensions = SongsExtensions.values()
    }
}
