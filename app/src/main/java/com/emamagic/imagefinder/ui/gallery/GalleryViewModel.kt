package com.emamagic.imagefinder.ui.gallery

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.switchMap
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.emamagic.imagefinder.ui.gallery.UnSplashRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class GalleryViewModel @Inject constructor(
    private val repository: UnSplashRepository
): ViewModel() {

    private val currentQuery = MutableLiveData("cats")

    val photos = currentQuery.switchMap { query ->
        repository.getSearchResult(query).cachedIn(viewModelScope)
    }

    fun searchPhotos(query: String) {
        currentQuery.value = query
    }


}