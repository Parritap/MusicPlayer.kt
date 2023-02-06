package model.logic

object Singleton {

    init {
       println( "Singleton created!" )
        SongsProducer.produce()
        val song = SongsProducer.getProducts().get(0)
        //
        println (song.path + " " + " " + song.title + " " + song.year + " " + song.artist + " " + song.album)

        //
    }
}

fun main() {
    Singleton
}