package com.emamagic.imagefinder.ui.gallery

import androidx.lifecycle.LiveData
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.liveData
import com.emamagic.imagefinder.db.MyDao
import com.emamagic.imagefinder.model.UnSplashPhoto
import com.emamagic.imagefinder.network.MyApi
import com.emamagic.imagefinder.network.paging.UnSplashPagingSource
import com.emamagic.imagefinder.safe.GeneralErrorHandlerImpl
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UnSplashRepositoryImpl @Inject constructor(
    private val myApi: MyApi,
    private val myDao: MyDao
): UnSplashRepository ,GeneralErrorHandlerImpl() {


    override fun getSearchResult(query: String): LiveData<PagingData<UnSplashPhoto>> {
        return Pager(
            config = PagingConfig(
                pageSize = 20,
                maxSize = 100,
                enablePlaceholders = false
            ),
            pagingSourceFactory = { UnSplashPagingSource(myApi ,query) }
        ).liveData
    }


}