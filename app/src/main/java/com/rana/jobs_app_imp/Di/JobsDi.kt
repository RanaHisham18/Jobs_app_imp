package com.rana.jobs_app_imp.Di

import com.rana.jobs_app_imp.data.remote.datasources.IJobRemoteDataSource
import com.rana.jobs_app_imp.data.remote.datasources.JobsRemoteDataSource
import com.rana.jobs_app_imp.ui.home.HomeViewModel
import com.rana.jobsapp.data.remote.service.JobsService
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit

val jobsModule = module {
    viewModel { HomeViewModel(get()) }
    single<IJobRemoteDataSource> { JobsRemoteDataSource(get()) }
    single { createJobsService(get()) }
}

fun createJobsService(retrofit: Retrofit): JobsService {
    return retrofit.create(JobsService::class.java)
}