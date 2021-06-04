package com.rana.jobs_app_imp.data.remote.datasources

import arrow.core.Either
import kotlinx.coroutines.Job


interface IJobRemoteDataSource {
    suspend fun fetch(): Either<String?, List<Job>>
}