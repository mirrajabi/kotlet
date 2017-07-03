package ir.mirrajabi.kotlet.infrastructure.extensions

import android.app.Activity
import android.content.Intent

fun Activity.startActivity(clazz: Class<Activity>) = this.startActivity(Intent(this@startActivity, clazz))