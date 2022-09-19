package ncb.program

import java.text.SimpleDateFormat
import java.util.*

const val JAN = 1643605200000
const val FEB = 1646024400000
const val MAR = 1648702800000
const val APR = 1651294800000
const val MAY = 1653886800000
const val JUN = 1656565200000
const val JUL = 1659243600000
const val AUG = 1661922000000
const val SEP = 1664514000000
const val OCT = 1667192400000
const val NOV = 1667192400000
const val DEC = 1672462800000

fun main(args: Array<String>) {
    println(convertLongToTime(reconverter(JAN)))
}

fun reconverter(long: Long): Long {
    return floatToLong(long.toFloat())
}

fun floatToLong(float: Float): Long {
    return float.toLong()
}

fun getDate() {
    val dateTime: Date = Calendar.getInstance().time
    //Convert it to a Long
    val dateTimeAsLong: Long = dateTime.time
    println(dateTimeAsLong)
    //Convert that Long back to a Date
    val backToDate: Date = Date(dateTimeAsLong)
    println(backToDate)
}

fun convertLongToTime(time: Long): String {
    val date = Date(time)
    val format = SimpleDateFormat("yyyy.MM.dd HH:mm")
    return format.format(date)
}

fun currentTimeToLong(): Long {
    return System.currentTimeMillis()
}

fun convertDateToLong(date: String): Long {
    val df = SimpleDateFormat("yyyy.MM.dd HH:mm")
    return df.parse(date).time
}

private fun getFormattedValue(value: Float): String {
    val mFormat = SimpleDateFormat("dd MMM", Locale.ENGLISH)
    val millis = value.toLong() * 9000000L
    return mFormat.format(Date(millis))
}
