package ir.mirrajabi.kotlet.infrastructure.di.modules

import dagger.Module
import dagger.Provides
import ir.mirrajabi.kotlet.infrastructure.di.scopes.ActivityScope
import ir.mirrajabi.kotlet.presentation.activities.main.PostView

/*
 * Another shape of the class which is exactly equal to main module's structure
 */
@Module
class PostModule(val view: PostView) {
    @ActivityScope
    @Provides
    internal fun provideView() : PostView = view
}
