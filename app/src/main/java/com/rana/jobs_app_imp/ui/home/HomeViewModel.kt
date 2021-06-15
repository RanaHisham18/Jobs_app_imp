package com.rana.jobs_app_imp.ui.home

import android.webkit.JsResult
import com.rana.jobs_app_imp.data.remote.datasources.IJobRemoteDataSource

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import arrow.core.Either
import kotlinx.coroutines.launch
import arrow.core.Either.Left as EitherLeft

class HomeViewModel(
    private val remoteDataSource: IJobRemoteDataSource,
) : ViewModel() {

    private val _stateLiveData: MutableLiveData<HomeState> = MutableLiveData(HomeState.Loading)

    //createv a mutable live data instance and init it to the live data to enable us to change values.
    val stateLiveData: LiveData<HomeState> = _stateLiveData
    //init the home state.

    init {

        viewModelScope.launch {
            when (val jobsResult = remoteDataSource.fetch()) {
                is Either.Left -> _stateLiveData.value = HomeState.Error(jobsResult.a ?: "")
                //incase left >> error state
                is Either.Right -> _stateLiveData.value = HomeState.Success(jobsResult.b)
                //incase right>> success state
            }
        }
    }
}