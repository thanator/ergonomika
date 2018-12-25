package tands.nirergonomika.processing

import java.io.Serializable

/**
 * возможно кандидат на хранилище мелодии
 */

data class MusicFile(var name:String,  var fullPath : String ) : Serializable {



}