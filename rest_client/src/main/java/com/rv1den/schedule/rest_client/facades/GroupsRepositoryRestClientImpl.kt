package com.rv1den.schedule.rest_client.facades

import android.util.Log
import com.rv1den.schedule.data.repositories.groups.GroupsRepositoryRestClient
import com.rv1den.schedule.domain.models.enteties.Group
import com.rv1den.schedule.rest_client.GROUPS_URL
import com.rv1den.schedule.rest_client.HEADERS
import com.rv1den.schedule.rest_client.METHODS
import com.rv1den.schedule.rest_client.URL_DOMAIN
import java.io.*
import java.net.HttpURLConnection
import java.net.URL
import java.nio.charset.Charset


class GroupsRepositoryRestClientImpl : GroupsRepositoryRestClient {
    override fun getGroups(): List<Group> {
        val response = getContentFromUrl(GROUPS_URL)
        Log.i("HUI", response)
        return emptyList()
    }

    fun getContentFromUrl(url: String?): String? {
        val content = StringBuilder()
        try {
            val u = URL(url)
            val uc = u.openConnection() as HttpURLConnection
            if (uc.responseCode == HttpURLConnection.HTTP_OK) {
                val `is`: InputStream = uc.inputStream
                val br =
                    BufferedReader(InputStreamReader(`is`, Charset.forName("UTF-8")))
                var line: String? = null
                while (br.readLine().also { line = it } != null) {
                    content.append(line).append("\n")
                }
            } else {
                throw IOException(uc.responseMessage)
            }
        } catch (s: StackOverflowError) {
            s.printStackTrace()
        } catch (s: Exception) {
            s.printStackTrace()
        } catch (e: Error) {
            e.printStackTrace()
        }
        return content.toString()
    }
}