package ru.d3rvich.domain.usecases

import ru.d3rvich.domain.repositories.SampleRepository
import javax.inject.Inject

class GetSampleUseCase @Inject constructor(private val sampleRepository: SampleRepository) {
    operator fun invoke(): Int = sampleRepository.sample()
}