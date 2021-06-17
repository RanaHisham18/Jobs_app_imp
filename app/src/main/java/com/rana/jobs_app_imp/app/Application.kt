package com.rana.jobs_app_imp.app

import android.app.Application
import coil.Coil
import coil.ImageLoader
import coil.decode.SvgDecoder
import com.rana.jobs_app_imp.Di.jobsModule
import com.rana.jobs_app_imp.Di.networkModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class Application : Application() {

    @Override
    override fun onCreate() {
        super.onCreate()

        val imageLoader = ImageLoader.Builder(this).componentRegistry {
            add(SvgDecoder(this@Application))
        }.build()

        Coil.setImageLoader(imageLoader)
        startKoin {
            androidContext(this@Application)
            modules(
                listOf(
                    jobsModule,
                    networkModule
                )
            )
        }

    }
}