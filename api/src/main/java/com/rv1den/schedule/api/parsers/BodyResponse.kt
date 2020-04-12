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
            return jsonArray.getJSONObject(0)
        }
}