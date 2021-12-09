package com.example.titresresto.listanddetails.feature.presenter.details

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.base.tools.data.Resource
import com.example.titresresto.listanddetails.feature.domain.usecases.GetTransactionDetailsUsecase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class TransactionDetailsViewModel @Inject constructor(
    private val getTransactionDetailsUsecase: GetTransactionDetailsUsecase
) : ViewModel() {

    val _state = mutableStateOf(DetailsState())
    val state: State<DetailsState> = _state

    private var getAlbumsJob: Job? = null

    fun getTransaction(id: Int) {
        getAlbumsJob?.cancel()
        getAlbumsJob = getTransactionDetailsUsecase.invoke(id)
            .onEach { resource ->
                when (resource.status) {
                    Resource.Status.SUCCESS -> {
                        resource.data?.let {
                            _state.value = state.value.copy(
                                transaction = it,
                                isVisible = true
                            )
                        }
                    }
                    Resource.Status.ERROR -> {
                        _state.value = state.value.copy(
                            transaction = null,
                            isVisible = false
                        )
                    }
                    Resource.Status.LOADING -> {
                        _state.value = state.value.copy(
                            transaction = null,
                            isVisible = false
                        )
                    }
                }
            }
            .launchIn(viewModelScope)
    }
}