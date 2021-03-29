package com.emamagic.imagefinder.di

import android.content.Context
import androidx.room.Room
import com.emamagic.imagefinder.db.MyDao
import com.emamagic.imagefinder.db.MyDatabase
import com.emamagic.imagefinder.network.MyApi
import com.emamagic.imagefinder.util.Constants.DB_NAME
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RoomModule {

    @Singleton
    @Provides
    fun provideRoom(@ApplicationContext context: Context): MyDatabase {
        return Room.databaseBuilder(context ,MyDatabase::class.java ,DB_NAME)
            .fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    fun provideMyDao(db: MyDatabase): MyDao {
        return db.getDao()
    }

}