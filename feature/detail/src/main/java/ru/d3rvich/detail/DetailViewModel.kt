package ru.d3rvich.detail

import androidx.lifecycle.viewModelScope
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import ru.d3rvich.detail.model.DetailUiAction
import ru.d3rvich.detail.model.DetailUiEvent
import ru.d3rvich.detail.model.DetailUiState
import ru.d3rvich.domain.usecases.GetSampleUseCase
import ru.d3rvich.ui.mvibase.BaseViewModel
import javax.inject.Provider

@HiltViewModel(assistedFactory = DetailViewModel.Factory::class)
internal class DetailViewModel @AssistedInject constructor(
    @Assisted private val id: Int,
    private val getSampleUseCase: Provider<GetSampleUseCase>,
) : BaseViewModel<DetailUiState, DetailUiEvent, DetailUiAction>() {
    override fun createInitialState(): DetailUiState = DetailUiState.Loading

    override fun obtainEvent(event: DetailUiEvent) {
        when (event) {
            DetailUiEvent.OnBackClicked -> sendAction { DetailUiAction.NavigateBack }
        }
    }

    init {
        viewModelScope.launch {
            val sample = getSampleUseCase.get().invoke(id)
            setState(DetailUiState.Detail(sample))
        }
    }

    @AssistedFactory
    internal interface Factory {
        fun create(id: Int): DetailViewModel
    }
}