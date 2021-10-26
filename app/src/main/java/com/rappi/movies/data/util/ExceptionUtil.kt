package com.rappi.movies.data.util

import com.rappi.movies.data.exception.RequestTimeoutException
import com.rappi.movies.data.exception.UncaughtErrorException
import com.rappi.movies.data.exception.UnknownDataException
import java.lang.Exception

fun getExceptionByCode(status: Int): Exception {
    return when (status) {
        408 -> RequestTimeoutException()
        422 -> UnknownDataException()
        else -> UncaughtErrorException()
    }
}