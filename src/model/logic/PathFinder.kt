package model.logic

sealed class PathFinder {
    class SONG : PathFinder();
}

fun getPath (findable : PathFinder) : String = when (findable) {
    is PathFinder.SONG -> "/home/juanestebanparraparra/Music";
}