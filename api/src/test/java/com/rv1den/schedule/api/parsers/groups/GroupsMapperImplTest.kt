package com.rv1den.schedule.api.parsers.groups

import com.rv1den.schedule.api.mappers.group.GroupsMapperImpl
import com.rv1den.schedule.domain.models.enteties.Group
import com.rv1den.schedule.domain.models.values.group.GroupTitle
import io.mockk.every
import io.mockk.mockk
import io.mockk.spyk
import org.json.JSONArray
import org.json.JSONObject
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class GroupsMapperImplTest {
    private lateinit var groupsParserImpl: GroupsMapperImpl
    private lateinit var groupMapper: GroupMapper

    @Before
    fun setUp() {
        groupMapper = spyk()
        groupsParserImpl =
            GroupsMapperImpl(groupMapper)
    }

    @Test
    fun `Should parse groups`() {
        //Given
        val groupsJson: JSONArray = mockk()
        val groupJson: JSONObject = mockk()
        val expectedGroup = Group(228,
            GroupTitle("24П")
        )
        val expectedGroups = listOf(expectedGroup)
        every {
            groupsJson.length()
        } returns 1
        every {
            groupsJson.getJSONObject(0)
        } returns groupJson
        every {
            groupMapper.parse(any())
        } returns expectedGroup

        //When
        val groups = groupsParserImpl.map(groupsJson)

        //Then
        assertEquals(expectedGroups, groups)
    }
}