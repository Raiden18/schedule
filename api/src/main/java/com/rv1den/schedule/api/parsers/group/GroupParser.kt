package com.rv1den.schedule.api.parsers.group

import com.rv1den.schedule.domain.models.enteties.Group
import org.json.JSONObject

interface GroupParser {
    fun parse(groupJson: JSONObject): Group
}