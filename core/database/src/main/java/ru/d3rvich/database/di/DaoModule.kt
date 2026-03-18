package ru.d3rvich.database.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ru.d3rvich.database.SampleDatabase
import ru.d3rvich.database.dao.SampleDao

@Module
@InstallIn(SingletonComponent::class)
internal object DaoModule {

    @Provides
    fun provideSampleDao(database: SampleDatabase): SampleDao = database.sampleDao()
}