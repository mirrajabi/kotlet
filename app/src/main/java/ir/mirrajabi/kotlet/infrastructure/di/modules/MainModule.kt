package ir.mirrajabi.kotlet.infrastructure.di.modules

import dagger.Module
import dagger.Provides
import ir.mirrajabi.kotlet.infrastructure.di.scopes.ActivityScope
import ir.mirrajabi.kotlet.presentation.activities.main.MainView

@Module
class MainModule(viewParam: MainView) {
    val view : MainView = viewParam

    @ActivityScope
    @Provides
    internal fun provideView() : MainView = view
}
