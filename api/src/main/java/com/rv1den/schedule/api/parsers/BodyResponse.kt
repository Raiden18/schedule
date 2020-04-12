package com.rv1den.schedule.api.parsers

import com.rv1den.schedule.api.jsons.TopLevelArrayJsonScheme
import org.json.JSONArray
import org.json.JSONObject

class BodyResponse(
    private val pureJson: String
) : TopLevelArrayJsonScheme {
    override val body: JSONObject
        get() {
            val jsonArray = JSONArray(pureJson)
            return try {
                jsonArray.getJSONObject(0)
            } catch (exception: Exception) {
                throw IllegalStateException("Response is empty")
            }
        }
}