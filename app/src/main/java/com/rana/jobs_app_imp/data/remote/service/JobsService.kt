package com.rana.jobsapp.data.remote.service
import com.rana.jobs_app_imp.data.remote.entities.JobResponse
import retrofit2.http.GET

interface JobsService {
    @GET("positions.json?description=api")
    suspend fun fetchJobs(): List<JobResponse>
}