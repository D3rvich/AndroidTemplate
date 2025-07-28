package ru.d3rvich.data.repositories

import ru.d3rvich.domain.repositories.SampleRepository

internal class SampleRepositoryImpl : SampleRepository {
    override fun sample(): Int {
        return 42
    }
}