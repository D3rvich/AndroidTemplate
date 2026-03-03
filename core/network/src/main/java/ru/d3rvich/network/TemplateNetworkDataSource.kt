package ru.d3rvich.network

import ru.d3rvich.network.model.Sample
import ru.d3rvich.network.result.NetworkResult

interface TemplateNetworkDataSource {
    fun sampleApiCall(): NetworkResult<Sample>
}