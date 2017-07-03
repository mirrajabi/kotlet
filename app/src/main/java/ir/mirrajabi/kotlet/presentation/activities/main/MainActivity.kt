package ir.mirrajabi.kotlet.presentation.activities.main

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import ir.mirrajabi.kotlet.GlobalApplication
import ir.mirrajabi.kotlet.R
import ir.mirrajabi.kotlet.infrastructure.api.models.PostModel
import ir.mirrajabi.kotlet.infrastructure.di.components.DaggerMainComponent
import ir.mirrajabi.kotlet.infrastructure.di.modules.MainModule
import ir.mirrajabi.kotlet.presentation.adapters.PostAdapter
import ir.mirrajabi.kotlet.presentation.base.BaseActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity<MainPresenter>() , MainView{
    var adapter : PostAdapter? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        DaggerMainComponent.builder()
                .applicationComponent((application as GlobalApplication).component)
                .mainModule(MainModule(viewParam = this))
                .build()
                .inject(mainActivity = this)
        initializeComponents()
    }

    fun initializeComponents(){
        recyclerView.layoutManager =
                LinearLayoutManager(this@MainActivity, LinearLayoutManager.VERTICAL, false)
        adapter = PostAdapter(R.layout.item_post)
        recyclerView.adapter = adapter
        presenter.fetchPosts()
    }

    override fun bindData(items: ArrayList<PostModel>) {
        adapter?.setNewData(items)
    }
}