package com.rv1den.schedule.api.client.factories.urlconnection

import java.net.HttpURLConnection

internal interface UrlConnectionFactory {
    fun create(urlString: String): HttpURLConnection
}