package daniil.zagirov.top100currencies

import java.text.SimpleDateFormat
import java.util.*

//Функция для разделения порядков в числах в списке криптовалют
fun Float.formatThousands(): String {
    val sb = StringBuilder()
    val formatter = Formatter(sb, Locale.US)
    formatter.format("%(,.2f", this)
    return sb.toString()
}

//Функция для перевода дат из Unix в строковый формат, для использования на графике
fun Number.dateToString(pattern: String): String {
    val calendar = Calendar.getInstance()
    calendar.timeInMillis = this.toLong()
    return SimpleDateFormat(pattern).format(calendar.time)
}