package com.rv1den.schedule.api.parsers

import com.rv1den.schedule.api.jsons.GroupJsonScheme
import org.json.JSONObject

class GroupResponse(
    private val jsonObject: JSONObject
) : GroupJsonScheme {
    companion object KEYS {
        const val NAME = "name"
        const val ID_GROUP = "id_group"
    }

    override val id: Int
        get() = jsonObject.getInt(ID_GROUP)
    override val name: String
        get() = jsonObject.getString(NAME)
}