package model.logic

/**
 * Clase cerrada encargada de contener las subclases que simbolizan los sistemas operativos: LINUX, MAC, WINDOWS, DESCONOCIDO.
 * Una "sealed class" en Kotlin es una clase abstracta que permite definir un conjunto cerrado de subclases.
 * Tambien permite definir funciones dentro de esta. Todas las operaciones que se hagan con las subclasses o subObjetos
 * Han de ser cubiertos, de lo contrario se entrará en un error de compilación.
 *
 * Esto es basicamente lo mismo que un ENUM, pero con esteroides.
 */
sealed class OS() {
    //bien podríamos usar un "class MAC : OS" en vez de un object, pero no hay uso en ello
    //debido a que los objetos funcionan como enums, lo cual es lo que queremos.
    //En caso de que usemos clases, otras clases podrían heredar de estas.
    object MAC : OS()
    object LINUX : OS()
    object WINDOWS : OS()
    object UNKNOWN : OS()

    companion object {
        fun detectOperatingSystem(): OS {
            val osName = System.getProperty("os.name").toLowerCase()

            return when {
                osName.contains("mac") -> MAC //Returns a OS.MAC
                osName.contains("linux") -> LINUX //Returns a OS.LINUX
                osName.contains("windows") -> WINDOWS //Returns a OS.WINDOWS
                else -> UNKNOWN
            }
        }
    }

}


