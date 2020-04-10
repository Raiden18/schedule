package com.rv1den.schedule.api.client.factories.urlconnection

import java.net.HttpURLConnection
import java.net.URL

internal class UrlConnectionFactoryImpl: UrlConnectionFactory {

    override fun create(urlString: String): HttpURLConnection {
        val url = URL(urlString)
        val urlConnection = url.openConnection()
        return urlConnection as HttpURLConnection
    }
}