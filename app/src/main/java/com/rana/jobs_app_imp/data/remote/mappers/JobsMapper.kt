package com.rana.jobs_app_imp.data.remote.mappers

import com.rana.jobs_app_imp.data.remote.entities.JobResponse
import com.rana.jobs_app_imp.ui.home.JobItem

fun JobResponse.toJob(): JobItem? {
    if (company == null || description == null || id == null || title == null) return null

    return JobItem(
        id = id,
        companyName = company,
        companyLogo = company_logo,
        companyUrl = company_url,
        createdAt = created_at,
        description = description,
        howToApply = how_to_apply,
        location = location,
        title = title,
        type = type,
        url = url
    )
}