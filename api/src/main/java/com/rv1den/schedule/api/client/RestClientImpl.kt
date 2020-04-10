package com.rv1den.schedule.api.client

import com.rv1den.schedule.api.client.factories.bufferedeader.BufferedReaderFactory
import com.rv1den.schedule.api.client.factories.bufferedeader.BufferedReaderFactoryImpl
import com.rv1den.schedule.api.client.factories.stringbuilder.StringBuilderFactory
import com.rv1den.schedule.api.client.factories.stringbuilder.StringBuilderFactoryImpl
import com.rv1den.schedule.api.client.factories.urlconnection.UrlConnectionFactory
import com.rv1den.schedule.api.client.factories.urlconnection.UrlConnectionFactoryImpl
import java.io.IOException
import java.net.HttpURLConnection

class RestClientImpl : RestClient {
    private val stringBuilderFactory: StringBuilderFactory = StringBuilderFactoryImpl()
    private val bufferedReaderFactory: BufferedReaderFactory = BufferedReaderFactoryImpl()
    private val urlConnectionFactory: UrlConnectionFactory = UrlConnectionFactoryImpl()
    private lateinit var content: StringBuilder
    private lateinit var httpUrlConnection: HttpURLConnection

    override fun getJson(urlString: String): String {
        content = stringBuilderFactory.create()
        httpUrlConnection = urlConnectionFactory.create(urlString)
        tryToMakeRequestAndDisconnect()
        return content.toString()
    }

    private fun tryToMakeRequestAndDisconnect() {
        try {
            makeRequest()
        } catch (exception: Exception) {
            exception.printStackTrace()
        } finally {
            httpUrlConnection.disconnect()
        }
    }

    private fun makeRequest() {
        if (httpUrlConnection.responseCode == HttpURLConnection.HTTP_OK) {
            makeUpResponse()
        } else {
            throw IOException(httpUrlConnection.responseMessage)
        }
    }

    private fun makeUpResponse() {
        val bufferedReader = bufferedReaderFactory.create(httpUrlConnection)
        var line: String
        while (bufferedReader.readLine().also { line = it } != null) {
            content.append(line).append("\n")
        }
    }
}
