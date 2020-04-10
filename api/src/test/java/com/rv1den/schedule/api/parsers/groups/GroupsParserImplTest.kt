package com.rv1den.schedule.api.parsers.groups

import com.rv1den.schedule.api.parsers.group.GroupParser
import com.rv1den.schedule.domain.models.enteties.Group
import com.rv1den.schedule.domain.models.values.Title
import io.mockk.every
import io.mockk.mockk
import io.mockk.spyk
import org.json.JSONArray
import org.json.JSONObject
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class GroupsParserImplTest {
    private lateinit var groupsParserImpl: GroupsParserImpl
    private lateinit var groupParser: GroupParser

    @Before
    fun setUp() {
        groupParser = spyk()
        groupsParserImpl = GroupsParserImpl(groupParser)
    }

    @Test
    fun `Should parse groups`() {
        //Given
        val groupsJson: JSONArray = mockk()
        val groupJson: JSONObject = mockk()
        val expectedGroup = Group(228, Title("24П"))
        val expectedGroups = listOf(expectedGroup)
        every {
            groupsJson.length()
        } returns 1
        every {
            groupsJson.getJSONObject(0)
        } returns groupJson
        every {
            groupParser.parse(any())
        } returns expectedGroup

        //When
        val groups = groupsParserImpl.parse(groupsJson)

        //Then
        assertEquals(expectedGroups, groups)
    }
}