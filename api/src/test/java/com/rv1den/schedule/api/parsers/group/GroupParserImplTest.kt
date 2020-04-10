package com.rv1den.schedule.api.parsers.group

import com.rv1den.schedule.domain.models.enteties.Group
import com.rv1den.schedule.domain.models.values.Title
import io.mockk.every
import io.mockk.mockk
import junit.framework.Assert.assertEquals
import org.json.JSONObject
import org.junit.Before

import org.junit.Test

class GroupParserImplTest {
    private lateinit var groupParser: GroupParserImpl

    @Before
    fun setUp() {
        groupParser = GroupParserImpl()
    }

    @Test
    fun `Should parse group`() {
        //Given
        val groupTitle = "24п"
        val groupId = 228
        val jsonGroup: JSONObject = mockk(relaxed = true)
        every{
            jsonGroup.getString(any())
        } returns groupTitle
        every {
            jsonGroup.getInt(any())
        } returns groupId
        val expectedGroup = Group(groupId, Title(groupTitle))

        //When
        val result = groupParser.parse(jsonGroup)

        //Then
        assertEquals(expectedGroup, result)
    }
}