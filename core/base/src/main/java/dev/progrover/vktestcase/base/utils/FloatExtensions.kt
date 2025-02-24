
import java.util.Locale
import kotlin.math.floor

/**
 * Если число по факту целое, то дробная часть будет отброшена. Если же дробная часть есть, то
 * отобразится, как есть
 */
fun Float.roundIfWhole(): String =
    when (this % 1.0f == 0f) {
        true -> String.format("%d", this.toInt())
        false -> String.format("%s", this)
    }

val Float.Companion.One: Float
    get() = 1.0f

val Float.Companion.Zero: Float
    get() = 0f

val Float.Companion.Half: Float
    get() = 0.5f

/**
 * Убирает лишние знаки при отображении float-чисел. По умолчанию число 5.5f будет отображаться как
 * 5,500000002 или типа того. Этот экстеншн режет визуальную часть до двух знаков после запятой
 */
fun Float.formatToString(): String{
    val scaled = floor(this.toDouble() * 100) / 100
    val formattedString = String.format(Locale.US, "%.2f", scaled)
    return formattedString.replace(Regex("\\.00$"), "")
}