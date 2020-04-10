package com.rv1den.schedule.i_async_framework

interface AsyncFramework {
    fun<T> execute(
        onDoTask: () -> T,
        onSuccess: (T) -> Unit,
        onError: (Exception) -> Unit
    )

    fun cancel()
}