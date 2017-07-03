package ir.mirrajabi.kotlet.presentation.adapters

import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import ir.mirrajabi.kotlet.R
import ir.mirrajabi.kotlet.infrastructure.api.models.PostModel
import kotlinx.android.synthetic.main.item_post.view.*

class PostAdapter : BaseQuickAdapter<PostModel, BaseViewHolder>{
    constructor(layoutResId: Int) : super(layoutResId)

    override fun convert(holder: BaseViewHolder?, item: PostModel?) {
        bind(holder, item)
    }
}
/*
 * This function is an extension for PostAdapter just to demonstrate
 * how the extensions work
 * I didn't want to move this to a separate extension file. Its fine here, so let it be...
 */
fun PostAdapter.bind(holder: BaseViewHolder?, item: PostModel?): Unit {
    holder?.setText(R.id.txtTitle, item?.title + item?.getIdsString())
    //Or this approach
    holder?.getConvertView()?.txtBody?.text = item?.body
}