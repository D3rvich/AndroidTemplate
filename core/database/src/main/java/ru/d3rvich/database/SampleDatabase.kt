package ru.d3rvich.database

import androidx.room.Database
import androidx.room.RoomDatabase
import ru.d3rvich.database.dao.SampleDao
import ru.d3rvich.database.dbo.SampleDBO

@Database(entities = [SampleDBO::class], version = 1, exportSchema = false)
internal abstract class SampleDatabase : RoomDatabase() {
    abstract fun sampleDao(): SampleDao
}