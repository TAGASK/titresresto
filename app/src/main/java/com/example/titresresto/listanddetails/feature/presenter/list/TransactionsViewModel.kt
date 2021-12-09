package com.example.titresresto.listanddetails.feature.presenter.list

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.base.tools.data.Resource
import com.example.titresresto.listanddetails.feature.domain.usecases.GetTransactionUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class TransactionsViewModel @Inject constructor(
    private val getTransactionUseCase: GetTransactionUseCase
) : ViewModel() {

    val _state = mutableStateOf(ListState())
    val state: State<ListState> = _state

    private var getAlbumsJob: Job? = null

    init {
        getTransactions()
    }

    private fun getTransactions() {
        getAlbumsJob?.cancel()
        getAlbumsJob = getTransactionUseCase.invoke()
            .onEach { resource ->
                when (resource.status) {
                    Resource.Status.SUCCESS -> {
                        resource.data?.let {
                            val grouped = it.groupBy { current ->
                                current.getDateAsDate()?.month
                            }
                            _state.value = state.value.copy(
                                grouped = grouped,
                                isVisible = true
                            )
                        }
                    }
                    Resource.Status.ERROR -> {
                        _state.value = state.value.copy(
                            grouped = emptyMap(),
                            isVisible = false
                        )
                    }
                    Resource.Status.LOADING -> {
                        _state.value = state.value.copy(
                            grouped = emptyMap(),
                            isVisible = false
                        )
                    }
                }
            }
            .launchIn(viewModelScope)
    }
}
