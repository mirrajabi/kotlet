package ir.mirrajabi.kotlet.presentation.activities.main

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import ir.mirrajabi.kotlet.GlobalApplication
import ir.mirrajabi.kotlet.R
import ir.mirrajabi.kotlet.infrastructure.api.models.CommentModel
import ir.mirrajabi.kotlet.infrastructure.api.models.PostModel
import ir.mirrajabi.kotlet.infrastructure.di.components.DaggerPostComponent
import ir.mirrajabi.kotlet.infrastructure.di.modules.PostModule
import ir.mirrajabi.kotlet.presentation.base.BaseActivity
import kotlinx.android.synthetic.main.activity_post.*

class PostActivity : BaseActivity<PostPresenter>(), PostView {
    var postId : Int = -1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_post)
        DaggerPostComponent.builder()
                .applicationComponent((application as GlobalApplication).component)
                .postModule(PostModule(view = this))
                .build()
                .inject(postActivity = this)
        initializeComponents()
    }

    fun initializeComponents() {
        postId = intent.getIntExtra("id",-1)
        if(postId != -1)
            presenter.fetchPost(postId)
        else finish()
        commentsRecycler.layoutManager =
                LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
    }

    override fun bindPost(post: PostModel) {
        txtTitle?.text = post.title
        txtBody?.text = post.body
        presenter.fetchComments(postId)
    }

    override fun bindComments(comments: ArrayList<CommentModel>) {
        // I wrote this adapter inline on purpose so you'll see how the object expression works
        // https://kotlinlang.org/docs/reference/object-declarations.html#object-expressions
        commentsRecycler.adapter = object : BaseQuickAdapter<CommentModel, BaseViewHolder>
        (R.layout.item_comment, comments) {
            override fun convert(helper: BaseViewHolder?, item: CommentModel?) {
                helper?.setText(R.id.txtName, item?.name)
                helper?.setText(R.id.txtEmail, item?.email)
                helper?.setText(R.id.txtMessage, item?.message)
            }
        }
    }
}