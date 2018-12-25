package tands.nirergonomika.processing

import com.musicg.wave.Wave

/**
 * собсно тут происходит обработка
 */
interface Process {
    fun process(wave: Wave)
}