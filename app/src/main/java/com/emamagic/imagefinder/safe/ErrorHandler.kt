package com.emamagic.imagefinder.safe

interface ErrorHandler {
    fun getError(throwable: Throwable): ErrorEntity
}