package com.rv1den.schedule.domain.usecases.group

import com.rv1den.schedule.domain.models.enteties.Group
import com.rv1den.schedule.domain.repositories.GroupRepository
import io.mockk.mockk
import io.mockk.spyk
import io.mockk.verify
import org.junit.Before
import org.junit.Test

class SaveGroupUseCaseTest {
    private lateinit var saveGroupUseCase: SaveGroupUseCase
    private lateinit var groupRepository: GroupRepository

    @Before
    fun setUp() {
        groupRepository = spyk()
        saveGroupUseCase = SaveGroupUseCase(groupRepository)
    }

    @Test
    fun `Should save group`() {
        //Given
        val group: Group = mockk(relaxed = true)

        //When
        saveGroupUseCase.execute(group)

        //Then
        verify(exactly = 1) {
            groupRepository.save(group)
        }
    }
}