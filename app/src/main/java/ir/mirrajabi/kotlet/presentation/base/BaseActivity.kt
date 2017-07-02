package ir.mirrajabi.kotlet.presentation.base

import android.os.Bundle
import android.support.v7.app.AppCompatActivity

import javax.inject.Inject

abstract class BaseActivity<P : BasePresenter> : AppCompatActivity(), BaseView {
    @Inject
    lateinit var presenter: P

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
}
