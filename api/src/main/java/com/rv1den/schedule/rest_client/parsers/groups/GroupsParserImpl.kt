package com.rv1den.schedule.rest_client.parsers.groups

import com.rv1den.schedule.domain.models.enteties.Group
import com.rv1den.schedule.rest_client.parsers.group.GroupParser
import org.json.JSONArray

class GroupsParserImpl(private val groupParser: GroupParser) : GroupsParser {
    private lateinit var groups: ArrayList<Group>
    private lateinit var groupsJson: JSONArray

    override fun parse(groupsJson: JSONArray): List<Group> {
        groups = arrayListOf()
        this.groupsJson = groupsJson
        for (groupIndex in 0 until groupsJson.length()) {
            parseGroup(groupIndex)
        }
        return groups
    }

    private fun parseGroup(groupIndex: Int) {
        val groupJson = groupsJson.getJSONObject(groupIndex)
        val group = groupParser.parse(groupJson)
        groups.add(group)
    }
}