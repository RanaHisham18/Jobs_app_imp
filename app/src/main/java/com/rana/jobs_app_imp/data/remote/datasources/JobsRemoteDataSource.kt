package com.rana.jobs_app_imp.data.remote.datasources

import arrow.core.Either
import com.rana.jobs_app_imp.data.remote.mappers.toJob
import com.rana.jobs_app_imp.ui.home.JobItem
import com.rana.jobsapp.data.remote.service.JobsService

class JobsRemoteDataSource(
    private val service: JobsService,
) : IJobRemoteDataSource {

    override suspend fun fetch(): Either<String?, List<JobItem>> {
        return try {
            val list = service.fetchJobs().mapNotNull {
                it.toJob()
            }
            Either.right(list)
        } catch (e: Exception) {
            Either.left(e.message)
        }
    }
}