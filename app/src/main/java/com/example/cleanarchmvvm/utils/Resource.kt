package com.example.cleanarchmvvm.utils

/**
 * Created by Aalishan Ansari on 29/03/23.
 */
sealed class Resource<out T>(val data: T? = null, val message: String? = null) {
    class Loading<T> : Resource<T>()
    class Success<T>(data: T? = null) : Resource<T>(data)
    class Error<T>(message: String?, data: T? = null) : Resource<T>(message = message, data = data)
}
