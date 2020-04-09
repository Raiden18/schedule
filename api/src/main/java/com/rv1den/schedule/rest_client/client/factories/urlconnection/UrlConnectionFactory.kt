package com.rv1den.schedule.rest_client.client.factories.urlconnection

import java.net.HttpURLConnection

interface UrlConnectionFactory {
    fun create(urlString: String): HttpURLConnection
}