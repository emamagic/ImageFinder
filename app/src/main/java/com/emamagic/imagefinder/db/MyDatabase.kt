package com.emamagic.imagefinder.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.emamagic.imagefinder.db.entity.MyEntity

@Database(entities = [MyEntity::class] ,version = 1)
abstract class MyDatabase: RoomDatabase() {

    abstract fun getDao(): MyDao

}