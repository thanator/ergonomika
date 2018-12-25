package tands.nirergonomika.processing

import java.io.Serializable

/**
 * хранит основные параметры музыки
 *
 * @param name имя
 * @param fullPath путь до
 */

data class MusicFile(var name: String, var fullPath: String) : Serializable