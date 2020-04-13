package com.rv1den.schedule.weeks.view.schedule

import android.content.Context
import android.util.AttributeSet
import android.widget.TableLayout
import com.rv1den.schedule.domain.models.values.lesson.Lesson
import com.rv1den.schedule.domain.models.values.schedule.SchoolWeek

class WeekTableLayout(context: Context, attributes: AttributeSet) :
    TableLayout(context, attributes) {
    private lateinit var monday: DayLessonsRow
    private lateinit var tuesday: DayLessonsRow
    private lateinit var wednesday: DayLessonsRow
    private lateinit var thursday: DayLessonsRow
    private lateinit var friday: DayLessonsRow
    private lateinit var saturday: DayLessonsRow
    lateinit var onDayClick: (Lesson) -> Unit

    init {
        createSchedule()
    }

    fun addSchedule(oddWeek: SchoolWeek) {
        if (oddWeek.monday.isLessonsExist) {
            monday.addLessons(oddWeek.monday, onDayClick)
        }
        if (oddWeek.tuesday.isLessonsExist) {
            tuesday.addLessons(oddWeek.tuesday, onDayClick)
        }
        if (oddWeek.wednesday.isLessonsExist) {
            wednesday.addLessons(oddWeek.wednesday, onDayClick)
        }
        if (oddWeek.thursday.isLessonsExist) {
            thursday.addLessons(oddWeek.thursday, onDayClick)
        }
        if (oddWeek.friday.isLessonsExist) {
            friday.addLessons(oddWeek.friday, onDayClick)
        }
        if (oddWeek.saturday.isLessonsExist) {
            saturday.addLessons(oddWeek.saturday, onDayClick)
        }
    }

    fun clearLessonsCells() {
        monday.cleanLesson()
        tuesday.cleanLesson()
        wednesday.cleanLesson()
        thursday.cleanLesson()
        friday.cleanLesson()
        saturday.cleanLesson()
    }

    private fun createSchedule() {
        numberOfLesson()
        createDays()
    }

    private fun numberOfLesson() {
        val numbersOfLessons =
            NumberOfLessonsHeader(context)
        addView(numbersOfLessons)
    }

    private fun createDays() {
        monday = DayLessonsRow.createMonday(context)
        tuesday = DayLessonsRow.createTuesday(context)
        wednesday = DayLessonsRow.createWednesday(context)
        thursday = DayLessonsRow.createThursday(context)
        friday = DayLessonsRow.createFriday(context)
        saturday = DayLessonsRow.createSaturday(context)
        addView(monday)
        addView(tuesday)
        addView(wednesday)
        addView(thursday)
        addView(friday)
        addView(saturday)
    }


}