package com.rv1den.schedule.domain.models.values.schedule

data class Schedule(
    val oddSchoolWeek: SchoolWeek,
    val evenSchoolWeek: SchoolWeek
) {
    companion object {
        fun createEmpty() =
            Schedule(
                SchoolWeek.createEmpty(),
                SchoolWeek.createEmpty()
            )
    }

    fun isEmpty(): Boolean {
        return oddSchoolWeek.isEmpty() && evenSchoolWeek.isEmpty()
    }


    override fun toString(): String {
        return "Odd: $oddSchoolWeek  Even: $evenSchoolWeek"
    }

}