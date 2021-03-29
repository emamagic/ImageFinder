package com.emamagic.imagefinder.network.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.emamagic.imagefinder.model.UnSplashPhoto
import com.emamagic.imagefinder.network.MyApi
import com.emamagic.imagefinder.util.Constants.PAGING_START_PAGE
import retrofit2.HttpException
import java.io.IOException

class UnSplashPagingSource(
    private val myApi: MyApi,
    private val query: String
): PagingSource<Int, UnSplashPhoto>() {

    override fun getRefreshKey(state: PagingState<Int, UnSplashPhoto>) = state.anchorPosition

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, UnSplashPhoto> {
        val position = params.key ?: PAGING_START_PAGE
        return try {
            val response = myApi.searchPhotos(query ,position ,params.loadSize)
            val photos = response.results

            LoadResult.Page(
                data = photos,
                prevKey = if (position == PAGING_START_PAGE) null else position - 1,
                nextKey = if (photos.isEmpty()) null else position + 1
            )
        }catch (exception: IOException){
            LoadResult.Error(exception)
        }catch (exception: HttpException) {
            LoadResult.Error(exception)
        }
    }
}
