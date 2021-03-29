package com.emamagic.imagefinder.di

import com.emamagic.imagefinder.ui.gallery.UnSplashRepository
import com.emamagic.imagefinder.ui.gallery.UnSplashRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class BinderModule {

    @Binds
    abstract fun bindUnSplashRepository(unSplashRepositoryImpl: UnSplashRepositoryImpl): UnSplashRepository

}