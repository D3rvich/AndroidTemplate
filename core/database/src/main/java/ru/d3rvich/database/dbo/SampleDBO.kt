package ru.d3rvich.database.dbo

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "sample")
data class SampleDBO(@PrimaryKey val id: Int, @ColumnInfo("text") val text: String)