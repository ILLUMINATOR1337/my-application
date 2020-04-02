package daniil.zagirov.top100currencies.formatters

import com.github.mikephil.charting.components.AxisBase
import com.github.mikephil.charting.formatter.IAxisValueFormatter
import daniil.zagirov.top100currencies.dateToString
import java.util.*

//Этот класс нужен для преобразования даты с помощью вышеупомянутой внешней функции
//в строковый формат для отрисовки легенды оси X графика цены криптовалюты.

class YearValueFormatter: IAxisValueFormatter {

    override fun getFormattedValue(value: Float, axis: AxisBase?): String {
        val calendar = Calendar.getInstance()
        calendar.timeInMillis = value.toLong()
        return calendar.toFormatted()
    }

    fun Calendar.toFormatted(): String {
        val date = this.timeInMillis
        return date.dateToString("MMM yyy")
    }
}