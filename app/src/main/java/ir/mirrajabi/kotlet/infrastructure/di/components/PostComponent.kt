package ir.mirrajabi.kotlet.infrastructure.di.components

import dagger.Component
import ir.mirrajabi.kotlet.infrastructure.di.modules.PostModule
import ir.mirrajabi.kotlet.infrastructure.di.scopes.ActivityScope
import ir.mirrajabi.kotlet.presentation.activities.main.PostActivity

@ActivityScope
@Component(dependencies = arrayOf(ApplicationComponent::class), modules = arrayOf(PostModule::class))
interface PostComponent {
    fun inject(postActivity: PostActivity)
}
