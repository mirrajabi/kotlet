package ir.mirrajabi.kotlet.presentation.activities.main

import ir.mirrajabi.kotlet.infrastructure.api.models.PostModel

interface MainView {
    fun bindData(items : ArrayList<PostModel>)
}