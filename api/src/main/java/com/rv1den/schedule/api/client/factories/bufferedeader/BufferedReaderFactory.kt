package com.rv1den.schedule.api.client.factories.bufferedeader

import java.io.BufferedReader
import java.net.HttpURLConnection

internal interface BufferedReaderFactory {
    fun create(httpURLConnection: HttpURLConnection): BufferedReader
}