package com.rv1den.schedule.rest_client

internal const val URL_DOMAIN = "http://sked.iatit.ru/api/"
internal const val GROUPS_URL = URL_DOMAIN + "university"

internal object METHODS {
    const val GET = "GET"
}

internal object HEADERS {
    object TITLE {
        internal const val CONTENT_TYPE = "Content-Type"
    }

    object VALUE {
        internal const val APPLICATION_JSON = "application/json"
    }

}