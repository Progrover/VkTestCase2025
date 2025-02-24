
import com.squareup.moshi.FromJson
import com.squareup.moshi.ToJson
import java.time.Instant
import java.time.ZoneId
import java.time.ZoneOffset
import java.time.ZonedDateTime
import java.time.format.DateTimeFormatter

@Suppress("unused")
class ZonedDateTimeAdapter {

    @ToJson
    fun toJson(value: ZonedDateTime): String =
        mapToUTCFormat(value)

    fun mapToUTCFormat(value: ZonedDateTime): String {
        val zonedDateTimeAtUTC = value.withZoneSameInstant(ZoneOffset.UTC)
        return FORMATTER.format(zonedDateTimeAtUTC)
    }

    @FromJson
    fun fromJson(value: String): ZonedDateTime {
        val instant = Instant.parse(value)
        return ZonedDateTime
            // withZone для приведения к пользовательской таймзоне
            .ofInstant(instant, ZoneId.systemDefault())
//            .parse(value, FORMATTER.withZone(ZoneId.systemDefault()))
    }


    companion object {

        private val FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
    }
}