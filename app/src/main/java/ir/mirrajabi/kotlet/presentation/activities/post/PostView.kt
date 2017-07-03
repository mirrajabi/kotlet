package ir.mirrajabi.kotlet.presentation.activities.main

import ir.mirrajabi.kotlet.infrastructure.api.models.CommentModel
import ir.mirrajabi.kotlet.infrastructure.api.models.PostModel

interface PostView {
    fun bindPost(post : PostModel)
    fun bindComments(comments : ArrayList<CommentModel>)
}