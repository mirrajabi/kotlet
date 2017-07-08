package ir.mirrajabi.kotlet.presentation.activities.main

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import ir.mirrajabi.kotlet.GlobalApplication
import ir.mirrajabi.kotlet.R
import ir.mirrajabi.kotlet.infrastructure.api.models.PostModel
import ir.mirrajabi.kotlet.infrastructure.di.components.DaggerMainComponent
import ir.mirrajabi.kotlet.infrastructure.di.modules.MainModule
import ir.mirrajabi.kotlet.infrastructure.extensions.startActivity
import ir.mirrajabi.kotlet.presentation.adapters.PostAdapter
import ir.mirrajabi.kotlet.presentation.base.BaseActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.experimental.CommonPool
import kotlinx.coroutines.experimental.delay
import kotlinx.coroutines.experimental.launch

class MainActivity : BaseActivity<MainPresenter>() , MainView {
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

        /* A useless Coroutine!
        * Read more about coroutines here :
        * https://github.com/Kotlin/kotlinx.coroutines/blob/master/coroutines-guide.md
        */
        launch(CommonPool) {
            delay(1000)
            Log.v(packageName, "Logging something here...")
            delay(1000)
            Log.v(packageName, "and one here...")
        }
        Log.v(packageName, "This one gets logged first")
    }

    fun initializeComponents(){
        recyclerView.layoutManager =
                LinearLayoutManager(this@MainActivity, LinearLayoutManager.VERTICAL, false)
        adapter = PostAdapter(R.layout.item_post)
        adapter?.setOnItemClickListener { a, _, position ->
            // This is a good one
            // We made this extension in UIExtension.kt classs
            startActivity(clazz=PostActivity::class.java,
                          id = (a as PostAdapter).getItem(position).id)
        }
        recyclerView.adapter = adapter
        presenter.fetchPosts()
    }

    override fun bindData(items: ArrayList<PostModel>) {
        adapter?.setNewData(items)
    }
}