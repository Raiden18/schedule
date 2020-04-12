package com.rv1den.schedule.domain.models.values

data class Number(val value: Int) {
    companion object {
        private const val EMPTY_VALUE = -1

        fun createEmpty() = Number(EMPTY_VALUE)
    }

    fun isEmpty() = value == EMPTY_VALUE
}