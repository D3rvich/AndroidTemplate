package ru.d3rvich.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow
import ru.d3rvich.database.dbo.SampleDBO

@Dao
interface SampleDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveSample(sampleDBO: SampleDBO)

    @Query("SELECT * FROM sample WHERE :id LIKE id")
    fun getSamples(id: Int): Flow<List<SampleDBO>>

    @Query("SELECT * FROM sample WHERE :id LIKE id")
    fun getSample(id: Int): Flow<SampleDBO>
}