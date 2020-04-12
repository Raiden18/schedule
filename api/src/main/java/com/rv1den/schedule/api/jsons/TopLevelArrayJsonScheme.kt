package com.rv1den.schedule.api.jsons

import org.json.JSONObject

/**
 * Each response from rest api is wrapped in' array with one element. So it is needed to derive.
 */
interface TopLevelArrayJsonScheme {
    val body: JSONObject
}