package com.rana.jobs_app_imp.data.remote.datasources

import android.app.job.JobService
import arrow.core.Either
import kotlinx.coroutines.Job

//class JobRemoteDataSource {
//    private val service = JobService
//    ) : IJobsRemoteDataSource
//    {
//        override suspend fun fetch(): Either<String?, List<Job>> {
//return try {
//    val list = service.fetchJobs().mapNotNull {
//        it.toJob()
//}
//    Either.right(list)
//} catch (e: Exception) {
//    Either.left(e.message)
//}
//        }
//    }
//}