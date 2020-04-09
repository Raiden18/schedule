package com.rv1den.schedule.rest_client.client.factories.urlconnection

import java.net.HttpURLConnection
import java.net.URL

class UrlConnectionFactoryImpl: UrlConnectionFactory {

    override fun create(urlString: String): HttpURLConnection {
        val url = URL(urlString)
        val urlConnection = url.openConnection()
        return urlConnection as HttpURLConnection
    }
}