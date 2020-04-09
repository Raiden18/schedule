package com.rv1den.schedule.rest_client.client.factories.bufferedeader

import java.io.BufferedReader
import java.net.HttpURLConnection

interface BufferedReaderFactory {
    fun create(httpURLConnection: HttpURLConnection): BufferedReader
}