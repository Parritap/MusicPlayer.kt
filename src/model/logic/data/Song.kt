package model.logic.data

import org.jaudiotagger.tag.datatype.Artwork

class Song(
    var path: String = "",
    var title: String = "",
    var year: String = "",
    var artist: String = "",
    var album: String = ""

) {
    var cover : String = ""
    var artWork: Artwork? = null

    constructor(path: String, name: String, year: String, artist: String, album: String, _artWork: Artwork) : this(
        path,
        name,
        year,
        artist,
        album
    ) {
        this.artWork = _artWork
    }
}

