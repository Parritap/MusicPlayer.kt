package model.logic

import org.jaudiotagger.audio.AudioFile
import org.jaudiotagger.audio.AudioFileIO
import org.jaudiotagger.audio.asf.util.TagConverter
import org.jaudiotagger.tag.datatype.Artwork
import java.io.File

class Utils {
    companion object {

        fun detectOperatingSystem(): String {
            val osName = System.getProperty("os.name").toLowerCase()

            return when {
                osName.contains("mac") -> "Mac"
                osName.contains("linux") -> "Linux"
                osName.contains("windows") -> "Windows"
                else -> "Unknown"
            }
        }



        /**
         * Verifies if a String has de extensions listed in the enum SongsExtensions.
         */
        fun isSong(file: String): Boolean {
            val index: Int = file.split(".").size - 1
            val ext: String = file.split(".").get(index)
            for (i in SongsExtensions.listOfExtensions) {
                if (ext.equals(i.extension)) return true
            }
            return false
        }


        private fun findFileWithExtension_aux(path: String, extension: SongsExtensions, list: ArrayList<String>) {
            val file = File(path)
            val listOfFiles = file.listFiles()
            for (aux: File in listOfFiles!!) {
                if (aux.isDirectory) findFileWithExtension_aux(aux.path, extension, list)
                list.add(aux.path)
            }
        }

        fun findFilesWithExtension(path: String, extension: SongsExtensions): ArrayList<String> {
            val list: ArrayList<String> = ArrayList()
            findFileWithExtension_aux(path, extension, list)
            return list
        }

        fun findSongsInPath(path: String): ArrayList<String> {
            val list = ArrayList<String>()
            findSongsAux(path, list) //Adds any song found to the list passed
            return list
        }

        private fun findSongsAux(path: String, list: ArrayList<String>) {
            val file = File(path)
            for (i in file.listFiles()!!) {
                if (i.isDirectory) findSongsAux(i.path, list)
                else (if (isSong(i.path)) list.add(i.path))
            }
        }

        fun getArtWorkNotNull(audioFile : AudioFile): Artwork {

            val art : Artwork? = audioFile.tag.firstArtwork;
            if (art == null) {
                return  Artwork.createArtworkFromFile(File("/home/juanestebanparraparra/IdeaProjects/MusicPlayer.kt/src/resources/myResources/songGenericImage.png"))
            } else{
                return art;
            }

        }
    }
}



fun main(args: Array<String>) {
    val list = Utils.findSongsInPath(PathFinder.getMusicFolderPath())
    for (i in list) {
        println(i)
    }
}

