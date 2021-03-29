package com.emamagic.imagefinder.ui.gallery

import androidx.lifecycle.LiveData
import androidx.paging.PagingData
import com.emamagic.imagefinder.model.UnSplashPhoto

interface UnSplashRepository {

    fun getSearchResult(query: String): LiveData<PagingData<UnSplashPhoto>>

}