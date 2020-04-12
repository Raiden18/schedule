package com.rv1den.schedule.data.repositories.group

import com.rv1den.schedule.domain.models.enteties.Group
import com.rv1den.schedule.domain.repositories.GroupRepository
import io.mockk.mockk
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class GroupRepositoryImplTest {
    private lateinit var groupRepository: GroupRepository

    @Before
    fun setUp() {
        groupRepository = GroupRepositoryImpl()
    }

    @Test(expected = NullPointerException::class)
    fun `Should throw NullPointerException if group was not saved`() {
        groupRepository.getSavedGroup()
    }

    @Test
    fun `Should save group`() {
        //Given
        val group: Group = mockk()

        //When
        groupRepository.save(group)
        val resultGroup = groupRepository.getSavedGroup()

        //Then
        assertEquals(group, resultGroup)
    }
}