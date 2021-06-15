package com.rana.jobs_app_imp.Di

import com.squareup.moshi.Moshi
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory


const val SERVER_URL = "https://jobs.github.com/"
val networkModule = module {
    single { retrofit(SERVER_URL, get()) }
    single { moshi() }
}

private fun moshi(): Moshi {
    return Moshi.Builder()
        .build()
}


fun retrofit(baseUrl: String, moshi: Moshi): Retrofit {
    return Retrofit.Builder()
        .baseUrl(baseUrl)
        .addConverterFactory(MoshiConverterFactory.create(moshi))
        .build()
}

