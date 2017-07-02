package ir.mirrajabi.kotlet.presentation.adapters

import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import ir.mirrajabi.kotlet.R
import ir.mirrajabi.kotlet.infrastructure.api.models.PostModel
import kotlinx.android.synthetic.main.item_post.view.*

class PostAdapter : BaseQuickAdapter<PostModel, BaseViewHolder>{
    constructor(layoutResId: Int) : super(layoutResId)

    override fun convert(helper: BaseViewHolder?, item: PostModel?) {
        helper?.setText(R.id.txtTitle, item?.title)
        //Or this approach
        helper?.getConvertView()?.txtBody?.text = item?.body
    }
}