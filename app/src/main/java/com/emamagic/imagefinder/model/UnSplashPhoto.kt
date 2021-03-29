package com.emamagic.imagefinder.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class UnSplashPhoto(
    val id: String,
    val description: String?,
    val urls: UnSplashPhotoUrls,
    val user: UnSplashUser
): Parcelable{

    @Parcelize
    data class UnSplashPhotoUrls(
        val raw: String,
        val full: String,
        val regular: String,
        val small: String,
        val thumb: String
    ): Parcelable

    @Parcelize
    data class UnSplashUser(
        val name: String,
        val username: String
    ): Parcelable{
        val attributionUrl get() = "https://unsplash.com/$username?utm_source=ImageSearchApp&utm_medium=referral"
    }

}

