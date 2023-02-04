package model.logic

/**
 * Returns a path depending the type of object that want to be found.
 */
sealed class PathFinder {
    class SONG : PathFinder();


    companion object{
        fun getPath (findable : PathFinder) : String = when (findable) {
            is SONG -> "/home/Parritap/Music";
        }
    }
}

