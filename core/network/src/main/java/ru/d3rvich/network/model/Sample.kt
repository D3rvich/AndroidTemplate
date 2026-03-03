package ru.d3rvich.network.model

import kotlinx.serialization.Serializable

@Serializable
data class Sample(val id: Long, val text: String)