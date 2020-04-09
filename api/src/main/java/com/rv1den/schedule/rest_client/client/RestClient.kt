package com.rv1den.schedule.rest_client.client

interface RestClient {
    fun getJson(urlString: String): String
}