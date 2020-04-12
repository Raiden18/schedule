package com.rv1den.schedule.weeks.view

import android.annotation.SuppressLint
import android.content.Context
import android.view.Gravity
import android.widget.TableRow
import android.widget.TextView
import com.rv1den.schedule.weeks.R

@SuppressLint("ViewConstructor")
class TableCellTextView(textCell: String, context: Context) : TextView(context) {
    private val longSide = getDimen(R.dimen.week_cell_side_long).toInt()
    private val marginSide = getDimen(R.dimen.week_cell_side_margin).toInt()

    companion object {
        fun createEmpty(context: Context) = TableCellTextView("", context)
    }

    init {
        text = textCell
        layoutParams = TableRow.LayoutParams(longSide, longSide).apply {
            setMargins(marginSide, marginSide, marginSide, marginSide)
            weight = 1f
        }
        gravity = Gravity.CENTER
        setTextColor(context.resources.getColorStateList(android.R.color.black))
    }

    private fun getDimen(idDimen: Int) = context.resources.getDimension(idDimen)
}