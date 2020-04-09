package com.rv1den.schedule.domain.usecases.groups

import com.rv1den.schedule.domain.models.enteties.Group
import com.rv1den.schedule.domain.repositories.GroupsRepository
import io.mockk.every
import io.mockk.mockk
import junit.framework.TestCase.assertEquals
import org.junit.Before
import org.junit.Test

class GetGroupsUseCaseImplTest {
    private lateinit var getGroupsUseCaseImpl: GetGroupsUseCaseImpl
    private lateinit var groupsRepository: GroupsRepository

    @Before
    fun setUp() {
        groupsRepository = mockk()
        getGroupsUseCaseImpl = GetGroupsUseCaseImpl(groupsRepository)
    }

    @Test
    fun `Should return grous when get groups is called`() {
        //Given
        val groups = listOf<Group>()
        every {
            groupsRepository.getGroups()
        } returns groups

        //When
        val groupsResult = getGroupsUseCaseImpl.execute()

        //Then
        assertEquals(groups, groupsResult)
    }
}