package com.rv1den.schedule.api.parsers.groups

import com.rv1den.schedule.domain.models.enteties.Group
import org.json.JSONArray

interface GroupsParser {
    fun parse(groupsJson: JSONArray): List<Group>
}