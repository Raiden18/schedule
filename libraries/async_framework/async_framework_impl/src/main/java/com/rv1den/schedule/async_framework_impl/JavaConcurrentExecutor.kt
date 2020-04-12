package com.rv1den.schedule.async_framework_impl

import android.os.Handler
import android.os.Looper
import com.rv1den.schedule.i_async_framework.AsyncFramework

class JavaConcurrentExecutor : AsyncFramework {
    private var thread: Thread? = null

    override fun <T> execute(
        onDoTask: () -> T,
        onSuccess: (T) -> Unit,
        onError: (Exception) -> Unit
    ) {
        thread = Thread {
            try {
                val result = onDoTask()
                Handler(Looper.getMainLooper()).post {
                    onSuccess(result)
                }
            } catch (exception: java.lang.Exception) {
                onError(exception)
                cancel()
            }
        }
        thread!!.start()
    }

    override fun cancel() {
        if (thread != null) {
            thread!!.interrupt()
            thread == null
        }
    }
}