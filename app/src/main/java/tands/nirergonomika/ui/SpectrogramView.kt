package tands.nirergonomika.ui

import android.content.Context
import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View

class SpectrogramView(context: Context, attrs: AttributeSet) : View(context, attrs) {
    private val paint = Paint()
    private var bmp: Bitmap? = null

    fun calculate(data: Array<DoubleArray>) {
        paint.strokeWidth = 1f
        val width = data.size
        val height = data[0].size

        val arrayCol = IntArray(width * height)
        var counter = 0
        for (i in 0 until height) {
            for (j in 0 until width) {
                val value: Int = 255 - (data[j][i] * 255).toInt()
                val color: Int = value shl 16 or (value shl 8) or value or (255 shl 24)
                arrayCol[counter] = color
                counter++
            }
        }
        bmp = Bitmap.createBitmap(arrayCol, width, height, Bitmap.Config.ARGB_8888)
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        canvas.drawBitmap(bmp!!, 0f, 100f, paint)
    }
}
