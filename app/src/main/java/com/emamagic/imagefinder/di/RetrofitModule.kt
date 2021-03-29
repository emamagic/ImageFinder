package com.emamagic.imagefinder.di

import com.emamagic.imagefinder.network.MyApi
import com.emamagic.imagefinder.util.Constants.BASE_URL
import dagger.Lazy
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.Call
import okhttp3.OkHttpClient
import okhttp3.Request
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RetrofitModule {

    @Singleton
    @Provides
    fun provideOkHttp(): OkHttpClient{
        return OkHttpClient.Builder()
            .readTimeout(8000 , TimeUnit.SECONDS)
            .writeTimeout(8000 , TimeUnit.SECONDS)
            .connectTimeout(1 , TimeUnit.MINUTES)
            .build()
    }


    @Singleton
    @Provides
    fun provideRetrofit(client: Lazy<OkHttpClient>): Retrofit{
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .callFactory { request ->
                // this bellow fun ,called in background thread
                client.get().newCall(request)
            }
            .build()
    }

    @Provides
    fun provideMyApi(retrofit: Retrofit): MyApi {
        return retrofit.create(MyApi::class.java)
    }




}