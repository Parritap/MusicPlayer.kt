package model.logic

//Cuando una clase es Object se vuelve inmediatamente un Singleton, es decir, solo se puede crear una instancia de la clase
//y esta instancia se crea cuando se llama por primera vez.
//por ejemplo, para instanciar el singleton desde otra clase basta con hacer lo siguiente


object Singleton {

    val operatingSystem: OS = OS.detectOperatingSystem();

    //La palabra reservada init sirve para forzar a una clase (cualquiera, incluso singleton) a
    //ejecutar una porción de código UNICAMENTE CUANDO SEA INSTANCIADA. Funciona para data classes, object classes, sealed classes, etc...
    init {
        println("Singleton created!")
        SongsProducer.produce()
        val song = SongsProducer.getProducts().get(0)
        //
        println(song.path + " " + " " + song.title + " " + song.year + " " + song.artist + " " + song.album)
    }
}
