package com.rv1den.schedule.domain.models.values

import com.rv1den.schedule.domain.models.values.day.SchoolDay
import com.rv1den.schedule.domain.models.values.lesson.Lesson
import io.mockk.mockk
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

class SchoolDayTest {
    private lateinit var firstLesson: Lesson
    private lateinit var secondLesson: Lesson
    private lateinit var thirdLesson: Lesson
    private lateinit var fourthLesson: Lesson
    private lateinit var fifthLesson: Lesson
    private lateinit var schoolDay: SchoolDay
    @Before
    fun setUp() {
        firstLesson = mockk(relaxed = true)
        secondLesson = mockk(relaxed = true)
        thirdLesson = mockk(relaxed = true)
        fourthLesson = mockk(relaxed = true)
        fifthLesson = mockk(relaxed = true)
    }

    @Test
    fun `Should return the first lesson`() {
        //Given
        val lessons = listOf<Lesson>(
            firstLesson
        )
        schoolDay =
            SchoolDay(lessons, 1)

        //When
        val firstLesson = schoolDay.firstLesson

        //Then
        assertEquals(this.firstLesson, firstLesson)
    }

    @Test
    fun `Should return the second lesson`() {
        //Given
        val lessons = listOf<Lesson>(
            firstLesson,
            secondLesson
        )
        schoolDay =
            SchoolDay(lessons, 1)

        //When
        val secondLesson = schoolDay.secondLesson

        //Then
        assertEquals(this.secondLesson, secondLesson)
    }

    @Test
    fun `Should return the third lesson`() {
        //Given
        val lessons = listOf<Lesson>(
            firstLesson,
            secondLesson,
            thirdLesson
        )
        schoolDay =
            SchoolDay(lessons, 1)

        //When
        val thirdLesson = schoolDay.thirdLesson

        //Then
        assertEquals(this.thirdLesson, thirdLesson)
    }


    @Test
    fun `Should return the fourh lesson`() {
        //Given
        val lessons = listOf<Lesson>(
            firstLesson,
            secondLesson,
            thirdLesson,
            fourthLesson
        )
        schoolDay =
            SchoolDay(lessons, 1)

        //When
        val fourthLesson = schoolDay.fourthLesson

        //Then
        assertEquals(this.fourthLesson, fourthLesson)
    }

    @Test
    fun `Should return the fifth lesson`() {
        //Given
        val lessons = listOf<Lesson>(
            firstLesson,
            secondLesson,
            thirdLesson,
            fourthLesson,
            fifthLesson
        )
        schoolDay =
            SchoolDay(lessons, 1)

        //When
        val fifthLesson = schoolDay.fifthLesson

        //Then
        assertEquals(this.fifthLesson, fifthLesson)
    }

    @Test
    fun `Should return true if there is no lessons`() {
        //When
        schoolDay = SchoolDay.noLessons(1)

        //Then
        assertTrue(schoolDay.isNoLessons)
    }

    @Test
    fun `Should false true if there is no lessons`() {
        //Given
        val lessons = listOf<Lesson>(
            firstLesson
        )

        //When
        schoolDay = SchoolDay(lessons, 1)

        //Then
        assertFalse(schoolDay.isNoLessons)
    }

}