package model.logic

/**
 * Returns a path depending the type of object that want to be found.
 */
sealed class PathFinder {
    class SONG : PathFinder();

    //Companion objects son todas las clases y atributos estaticos de una clase.
    companion object {

        fun getMusicFolderPath(): String = when (Singleton.operatingSystem) {

            is OS.LINUX -> "/home/${System.getProperty("user.name")}/Music";
            is OS.MAC -> "/Users/${System.getProperty("user.name")}/Music";
            is OS.WINDOWS -> "C:\\Users\\${System.getProperty("user.name")}\\Music";
            is OS.UNKNOWN -> throw Exception("Unknown OS");
        }
    }
}

