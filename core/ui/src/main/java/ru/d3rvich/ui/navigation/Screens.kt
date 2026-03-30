package ru.d3rvich.ui.navigation

import androidx.navigation3.runtime.NavKey
import kotlinx.serialization.Serializable

object Screens {

    @Serializable
    data object List : NavKey

    @Serializable
    data class Detail(val id: Int) : NavKey
}