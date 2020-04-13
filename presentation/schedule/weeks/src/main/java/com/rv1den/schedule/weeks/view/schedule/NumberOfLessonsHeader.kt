package com.rv1den.schedule.weeks.view.schedule

import android.content.Context
import android.widget.TableRow
import com.rv1den.schedule.weeks.R


class NumberOfLessonsHeader(context: Context) : TableRow(context) {
    private val numbersOfLesson = context.resources.getStringArray(R.array.numbers_of_lessons)

    init {
        for (number in numbersOfLesson) {
            addLesson(number)
        }
    }

    private fun addLesson(number: String) {
        val cell =
            TableCellTextView(
                number,
                context
            )
        this.addView(cell)
    }
}