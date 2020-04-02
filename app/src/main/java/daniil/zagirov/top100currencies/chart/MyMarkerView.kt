package daniil.zagirov.top100currencies.chart

import android.annotation.SuppressLint
import android.content.Context
import android.widget.TextView
import com.github.mikephil.charting.components.MarkerView
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.highlight.Highlight
import com.github.mikephil.charting.utils.MPPointF
import daniil.zagirov.top100currencies.R
import daniil.zagirov.top100currencies.dateToString

@SuppressLint("ViewConstructor")
class MyMarkerView(context: Context, layoutResource: Int) : MarkerView(context, layoutResource) {

    private val tvContext: TextView

    init {
        tvContext = findViewById(R.id.tvContent)
    }

    // запускается каждый раз, когда MarkerView перерисовывается, может использоваться для обновления
    // контент (пользовательский интерфейс)
    @SuppressLint("SetTextI18n")
    override fun refreshContent(e: Entry, highlight: Highlight) {

        tvContext.text = e.y.toString() + "\n" + e.x.dateToString("MMM dd, yyyy")

        super.refreshContent(e, highlight)
    }

    //Возвращаем положение маркера
    override fun getOffset(): MPPointF {
        return MPPointF((-(width / 2)).toFloat(), (-height).toFloat())
    }
}