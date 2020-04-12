package com.rv1den.schedule.api.jsons

interface UniversityJsonScheme {
    val universityName: String
    val idUniversity: Int
    val groups: List<GroupJsonScheme>
    val groupsExt: List<GroupJsonScheme>
    val about: String
}