package com.rana.jobs_app_imp.data.remote.datasources

import arrow.core.Either
import com.rana.jobs_app_imp.ui.home.JobItem


interface IJobRemoteDataSource {
    suspend fun fetch(): Either<String?, List<JobItem>>
}