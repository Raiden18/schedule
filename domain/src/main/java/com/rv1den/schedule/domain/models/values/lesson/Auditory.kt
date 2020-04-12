package com.rv1den.schedule.domain.models.values.lesson

data class Auditory(val value: String){
    companion object {
        fun createEmpty() = Auditory("")
    }

    fun isEmpty() = value.isEmpty()
}