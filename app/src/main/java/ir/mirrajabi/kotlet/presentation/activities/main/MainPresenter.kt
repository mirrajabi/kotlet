package ir.mirrajabi.kotlet.presentation.activities.main

import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.functions.Consumer
import io.reactivex.schedulers.Schedulers
import ir.mirrajabi.kotlet.infrastructure.api.services.SimpleService
import ir.mirrajabi.kotlet.presentation.base.BasePresenter
import retrofit2.Retrofit
import javax.inject.Inject

class MainPresenter : BasePresenter {
    var view : MainView
    var service : SimpleService

    @Inject constructor(viewParam: MainView, retrofit: Retrofit){
        view = viewParam
        service = retrofit.create(SimpleService::class.java)
    }

    fun fetchPosts() {
        service.getPosts()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({items-> view.bindData(items = items)})
        // OR   .subscribe({view.bindData(items = it)})
    }
}
