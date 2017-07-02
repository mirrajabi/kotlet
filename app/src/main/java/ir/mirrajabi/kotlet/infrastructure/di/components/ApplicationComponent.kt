package ir.mirrajabi.kotlet.infrastructure.di.components

import android.app.Application
import android.content.Context
import dagger.Component
import ir.mirrajabi.kotlet.infrastructure.di.modules.ApplicationModule
import ir.mirrajabi.kotlet.infrastructure.di.modules.NetModule
import retrofit2.Retrofit
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(ApplicationModule::class, NetModule::class))
interface ApplicationComponent {
    fun context(): Context
    fun retrofit(): Retrofit
    fun inject(application: Application)
}