package com.emamagic.imagefinder.safe

import androidx.lifecycle.LiveData
import androidx.lifecycle.map
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import retrofit2.Response

fun <T> Response<T>.toResult(errorHandler: ErrorHandler): ResultWrapper<T> =
    try {
        if (isSuccessful) {
            body()?.let {
                ResultWrapper.Success(
                    data = it,
                    code = code()
                )
            }
        }
        ResultWrapper.Error(
            ErrorEntity.Api(
                message = message(), code = code(), errorBody = errorBody()?.string()
                    ?: "error body is null"
            )
        )
    } catch (t: Throwable) {
        ResultWrapper.Error(errorHandler.getError(t))
    }


fun <T> LiveData<T>.toResult(errorHandler: ErrorHandler): LiveData<ResultWrapper<T>> = map {

    try {
        ResultWrapper.Success(it)
    } catch (t: Throwable) {
        ResultWrapper.Error(errorHandler.getError(t))
    }
}


fun <T> Flow<T>.toResult(errorHandler: ErrorHandler): Flow<ResultWrapper<T>> = map {

    try {
        ResultWrapper.Success(it)
    } catch (t: Throwable) {
        ResultWrapper.Error(errorHandler.getError(t))
    }
}


