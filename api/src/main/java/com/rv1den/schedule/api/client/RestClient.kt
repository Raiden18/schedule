package com.rv1den.schedule.api.client

interface RestClient {
    fun getJson(urlString: String): String
}