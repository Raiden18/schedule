package com.rv1den.schedule.api.client

import com.rv1den.schedule.api.client.factories.bufferedeader.BufferedReaderFactory
import com.rv1den.schedule.api.client.factories.stringbuilder.StringBuilderFactory
import com.rv1den.schedule.api.client.factories.urlconnection.UrlConnectionFactory
import io.mockk.every
import io.mockk.mockk
import io.mockk.spyk
import io.mockk.verify
import org.junit.Before
import org.junit.Test
import java.net.HttpURLConnection

class RestClientImplTest {
    private lateinit var restClient: RestClient
    private lateinit var stringBuilderFactory: StringBuilderFactory
    private lateinit var bufferedReaderFactory: BufferedReaderFactory
    private lateinit var urlConnectionFactory: UrlConnectionFactory
    private lateinit var URL: String

    @Before
    fun setUp() {
        URL = "123"
        stringBuilderFactory = spyk()
        bufferedReaderFactory = spyk()
        urlConnectionFactory = spyk()
        restClient = RestClientImpl(
            stringBuilderFactory,
            bufferedReaderFactory,
            urlConnectionFactory
        )
    }

    @Test
    fun `Should create create StringBuilder and httpUrlConnection every time when json is required`() {
        //Given
        val httpURLConnection: HttpURLConnection = mockk(relaxed = true)
        every {
            stringBuilderFactory.create()
        } returns StringBuilder()
        every {
            urlConnectionFactory.create(any())
        } returns httpURLConnection
        every {
            httpURLConnection.responseCode
        } returns HttpURLConnection.HTTP_OK

        //When
        restClient.getJson(URL)

        //Then
        verify(exactly = 1) {
            stringBuilderFactory.create()
            urlConnectionFactory.create(URL)
        }
    }
}