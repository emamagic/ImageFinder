package com.emamagic.imagefinder.db.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "my_table")
data class MyEntity(
    val name: String? = null,
    @PrimaryKey(autoGenerate = true)
    val id: Long? = null
)