package ir.mirrajabi.kotlet

import android.app.Application
import ir.mirrajabi.kotlet.infrastructure.di.components.ApplicationComponent
import ir.mirrajabi.kotlet.infrastructure.di.components.DaggerApplicationComponent
import ir.mirrajabi.kotlet.infrastructure.di.modules.ApplicationModule
import ir.mirrajabi.kotlet.infrastructure.di.modules.NetModule

class GlobalApplication : Application() {
    val component : ApplicationComponent by lazy {
        DaggerApplicationComponent.builder()
                .applicationModule(ApplicationModule(app = this))
                .netModule(NetModule(mBaseUrl = "https://jsonplaceholder.typicode.com"))
                .build()
    }
    override fun onCreate() {
        super.onCreate()
        component.inject(application = this)
    }
}