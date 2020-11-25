package com.example.madlevel5task2.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "gameTable")
data class Game(

    @ColumnInfo(name = "title")
    var title: String,

    @ColumnInfo(name = "platform")
    var platform: String,

    @ColumnInfo(name = "day")
    var day: Int,

    @ColumnInfo(name = "month")
    var month: Int,

    @ColumnInfo(name = "year")
    var year: Int,

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id: Long? = null
)