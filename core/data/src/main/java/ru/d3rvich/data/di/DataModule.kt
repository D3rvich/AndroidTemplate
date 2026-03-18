package ru.d3rvich.data.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import ru.d3rvich.data.repositories.SampleRepositoryImpl
import ru.d3rvich.database.dao.SampleDao
import ru.d3rvich.domain.repositories.SampleRepository
import ru.d3rvich.network.TemplateNetworkDataSource

@Module
@InstallIn(ViewModelComponent::class)
internal object DataModule {

    @Provides
    fun provideSampleRepository(dao: SampleDao, networkDataSource: TemplateNetworkDataSource): SampleRepository =
        SampleRepositoryImpl(dao = dao, networkDataSource = networkDataSource)
}