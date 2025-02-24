package dev.progrover.vktestcase.base.data.repository

import ZonedDateTimeAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext

open class BaseRepository(
    private val dispatcher: CoroutineDispatcher,
) {

    val moshi: Moshi = Moshi.Builder()
        .add(ZonedDateTimeAdapter())
        .addLast(KotlinJsonAdapterFactory())
        .build()

    protected suspend fun <T> executeOnIO(
        call: suspend () -> T,
    ): T =
        withContext(dispatcher) {
            call.invoke()
        }
}