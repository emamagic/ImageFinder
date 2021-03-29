package com.emamagic.imagefinder.network.response

import com.emamagic.imagefinder.model.UnSplashPhoto

data class UnSplashResponse(
    val results: List<UnSplashPhoto>
)