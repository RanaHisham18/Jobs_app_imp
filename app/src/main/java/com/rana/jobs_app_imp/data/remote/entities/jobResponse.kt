package com.rana.jobs_app_imp.data.remote.entities

import com.squareup.moshi.JsonClass
@JsonClass(generateAdapter = true)
data class JobResponse(
        val company: String? = null,
        val company_logo: String? = null,
        val company_url: String? = null,
        val created_at: String? = null,
        val description: String? = null,
        val how_to_apply: String? = null,
        val id: String? = null,
        val location: String? = null,
        val title: String? = null,
        val type: String? = null,
        val url: String? = null
)