package com.rv1den.schedule.api.client.factories.bufferedeader

import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.nio.charset.Charset

internal class BufferedReaderFactoryImpl: BufferedReaderFactory {
    private val charSet = Charset.forName("UTF-8")

    override fun create(httpURLConnection: HttpURLConnection): BufferedReader {
        val inputStream = httpURLConnection.inputStream
        val inputStreamReader = InputStreamReader(inputStream, charSet)
        return BufferedReader(inputStreamReader)
    }
}