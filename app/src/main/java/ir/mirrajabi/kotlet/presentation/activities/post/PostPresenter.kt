package ir.mirrajabi.kotlet.presentation.activities.main

import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.functions.Consumer
import io.reactivex.schedulers.Schedulers
import ir.mirrajabi.kotlet.infrastructure.api.services.SimpleService
import ir.mirrajabi.kotlet.presentation.base.BasePresenter
import retrofit2.Retrofit
import javax.inject.Inject

class PostPresenter @Inject constructor(val view: PostView, retrofit: Retrofit) : BasePresenter  {
    val service : SimpleService = retrofit.create(SimpleService::class.java)

    fun fetchPost(postId: Int) {
        service.getPost(postId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .retry(3)
                .subscribe({post-> view.bindPost(post)},
                        {t->t.printStackTrace()})
    }

    fun fetchComments(postId: Int){
        service.getCommentsForPost(postId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .retry(3)
                .subscribe({comments-> view.bindComments(comments = comments)},
                        {t->t.printStackTrace()})
    }
}
