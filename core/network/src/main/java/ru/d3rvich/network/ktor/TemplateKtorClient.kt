package ru.d3rvich.network.ktor

import io.ktor.client.HttpClient
import ru.d3rvich.network.TemplateNetworkDataSource
import ru.d3rvich.network.model.Sample
import ru.d3rvich.network.result.NetworkResult

internal class TemplateKtorClient(private val client: HttpClient): TemplateNetworkDataSource {
    override fun sampleApiCall(): NetworkResult<Sample> {
        TODO("Not yet implemented")
    }
}

private const val BASE_URL = "YOUR_BASE_URL"