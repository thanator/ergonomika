package tands.nirergonomika.processing

import android.content.Context
import com.musicg.fingerprint.FingerprintManager
import com.musicg.fingerprint.FingerprintSimilarityComputer
import com.musicg.wave.Wave
import com.musicg.wave.WaveHeader
import tands.nirergonomika.R
import kotlin.math.max

class ProcessImpl(val context: Context) : Process {

    override fun process(wave: Wave): Float {


        val originFingerPrint = FingerprintManager().extractFingerprint(wave)
        val inp1 = context.resources.openRawResource(R.raw.first_sample_520_hz);
        val firstFingerPrint = FingerprintManager().extractFingerprint(Wave(WaveHeader(inp1), inp1.readBytes()))
        inp1.close()
        val inp2 = context.resources.openRawResource(R.raw.second_sample_400_hz);
        val secondFingerPrint = FingerprintManager().extractFingerprint(Wave(WaveHeader(inp2), inp2.readBytes()))
        inp2.close()
        val inp = context.resources.openRawResource(R.raw.t_3_10_sec);
        val thirdFingerPrint = FingerprintManager().extractFingerprint(Wave(WaveHeader(inp), inp.readBytes()))
        inp.close()

        val fingerprintSimilarityOne =
            FingerprintSimilarityComputer(firstFingerPrint, originFingerPrint).fingerprintsSimilarity
        val fingerprintSimilarityTwo =
            FingerprintSimilarityComputer(secondFingerPrint, originFingerPrint).fingerprintsSimilarity
        val fingerprintSimilarityThree =
            FingerprintSimilarityComputer(thirdFingerPrint, originFingerPrint).fingerprintsSimilarity

        val maximum =
            max(max(fingerprintSimilarityOne.score, fingerprintSimilarityTwo.score), fingerprintSimilarityThree.score)

        return returning(maximum)
    }

    private fun returning(value: Float): Float {
        if (value < 0.1f) {
            return value * 10
        }
        if (value < 1f) {
            return 0.9f + value / 10
        }
        return if (value < 1f) value else 1f
    }
}