package com.rv1den.schedule.weeks.view

import android.annotation.SuppressLint
import android.content.Context
import android.widget.TableRow
import android.widget.TextView
import androidx.core.content.ContextCompat
import com.rv1den.schedule.domain.models.values.day.SchoolDay
import com.rv1den.schedule.domain.models.values.lesson.Lesson
import com.rv1den.schedule.weeks.R

@SuppressLint("ViewConstructor")
class DayLessonsRow(
    private val nameOfDay: NameOfDay,
    context: Context
) : TableRow(context) {

    companion object {
        const val MAX_NUMBER_OF_LESSONS = 5
        fun createMonday(context: Context) = DayLessonsRow(NameOfDay.Monday, context)
        fun createTuesday(context: Context) = DayLessonsRow(NameOfDay.Tuesday, context)
        fun createWednesday(context: Context) = DayLessonsRow(NameOfDay.Wednesday, context)
        fun createThursday(context: Context) = DayLessonsRow(NameOfDay.Thursday, context)
        fun createFriday(context: Context) = DayLessonsRow(NameOfDay.Friday, context)
        fun createSaturday(context: Context) = DayLessonsRow(NameOfDay.Saturday, context)
    }

    init {
        layoutParams = LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT)
        iniDayName()
        for (i in 1..MAX_NUMBER_OF_LESSONS) {
            initEmptyLessons()
        }
    }

    fun cleanLesson() {
        for (i in 0 until virtualChildCount) {
            val lessonTextView = getVirtualChildAt(i) as TextView
            lessonTextView.setBackgroundColor(context.resources.getColor(android.R.color.white))
        }
    }

    fun addLessons(schoolDay: SchoolDay, onDayClick: (Int) -> Unit) {
        if (schoolDay.firstLesson.isNotEmpty()) {
            initCellLesson(schoolDay.firstLesson, onDayClick)
        }
        if (schoolDay.secondLesson.isNotEmpty()) {
            initCellLesson(schoolDay.secondLesson, onDayClick)
        }
        if (schoolDay.thirdLesson.isNotEmpty()) {
            initCellLesson(schoolDay.thirdLesson, onDayClick)
        }
        if (schoolDay.fourthLesson.isNotEmpty()) {
            initCellLesson(schoolDay.fourthLesson, onDayClick)
        }
        if (schoolDay.fifthLesson.isNotEmpty()) {
            initCellLesson(schoolDay.fifthLesson, onDayClick)
        }

    }

    private fun initCellLesson(lesson: Lesson, onDayClick: (Int) -> Unit) {
        val lessonTextView = getVirtualChildAt(lesson.number.value) as TextView
        val lessonColor = ContextCompat.getColor(context, R.color.colorPrimary)
        lessonTextView.setBackgroundColor(lessonColor)
        lessonTextView.setOnClickListener { onDayClick(lesson.number.value) }
    }

    private fun iniDayName() {
        val dayName = context.resources.getString(nameOfDay.dayId)
        val dayNameCell = TableCellTextView(dayName, context)
        addView(dayNameCell)
    }

    private fun initEmptyLessons() {
        val emptyCell = TableCellTextView.createEmpty(context)
        addView(emptyCell)
    }
}