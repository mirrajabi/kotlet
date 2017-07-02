package ir.mirrajabi.kotlet.infrastructure.di.components

import dagger.Component
import ir.mirrajabi.kotlet.infrastructure.di.modules.MainModule
import ir.mirrajabi.kotlet.infrastructure.di.scopes.ActivityScope
import ir.mirrajabi.kotlet.presentation.activities.main.MainActivity

@ActivityScope
@Component(dependencies = arrayOf(ApplicationComponent::class), modules = arrayOf(MainModule::class))
interface MainComponent {
    fun inject(mainActivity: MainActivity)
}
