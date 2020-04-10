package com.rv1den.schedule.api.parsers.group

import com.rv1den.schedule.domain.models.enteties.Group
import com.rv1den.schedule.domain.models.values.Title
import org.json.JSONObject

class GroupParserImpl : GroupParser {
    companion object KEYS {
        const val NAME = "name"
        const val ID_GROUP = "id_group"
    }

    override fun parse(groupJson: JSONObject): Group {
        val groupName = groupJson.getString(NAME)
        val groupId = groupJson.getInt(ID_GROUP)
        val title = Title(groupName)
        return Group(groupId, title)
    }
}