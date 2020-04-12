package com.rv1den.schedule.api.parsers

import com.rv1den.schedule.api.jsons.GroupJsonScheme
import com.rv1den.schedule.api.jsons.UniversityJsonScheme
import org.json.JSONObject

class UniversityResponse(
    private val jsonObject: JSONObject
) : UniversityJsonScheme {
    private companion object {
        const val NAME = "name"
        const val ID_UNIVERSITY = "id_university"
        const val GROUPS = "groups"
        const val GROUPS_EXT = "groups_ext"
        const val ABOUT = "about"
    }

    override val universityName: String
        get() = jsonObject.getString(NAME)
    override val idUniversity: Int
        get() = jsonObject.getInt(ID_UNIVERSITY)
    override val groups: List<GroupJsonScheme>
        get() = getGroups(GROUPS)
    override val groupsExt: List<GroupJsonScheme>
        get() = getGroups(GROUPS_EXT)
    override val about: String
        get() = jsonObject.getString(ABOUT)

    private fun getGroups(key: String): List<GroupJsonScheme> {
        val groupsJson = jsonObject.getJSONArray(key)
        val groups = arrayListOf<GroupJsonScheme>()
        for (groupIndex in 0 until groupsJson.length()) {
            val groupJson = groupsJson.getJSONObject(groupIndex)
            val groupResponse =
                GroupResponse(groupJson)
            groups.add(groupResponse)
        }
        return groups
    }
}