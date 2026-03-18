package ru.d3rvich.data.repositories

import ru.d3rvich.database.dao.SampleDao
import ru.d3rvich.domain.entities.SampleEntity
import ru.d3rvich.domain.repositories.SampleRepository
import ru.d3rvich.network.TemplateNetworkDataSource

internal class SampleRepositoryImpl(
    val dao: SampleDao,
    val networkDataSource: TemplateNetworkDataSource
) : SampleRepository {
    private val list: List<SampleEntity> by lazy {
        List(20) {
            SampleEntity(id = it, text = "Item: $it")
        }
    }

    override suspend fun getList(): List<SampleEntity> = list

    override suspend fun getSampleBy(id: Int): SampleEntity = list.first { it.id == id }
}