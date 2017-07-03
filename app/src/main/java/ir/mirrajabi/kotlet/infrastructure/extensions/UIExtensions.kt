package ir.mirrajabi.kotlet.infrastructure.extensions

import android.app.Activity
import android.content.Intent

// "id" parameter is optional cause we gave it a default value
fun <T : Activity>Activity.startActivity(clazz: Class<T>, id: Int = -1) {
    var intent = Intent(this@startActivity, clazz)
    if(id != -1)
        intent.putExtra("id", id)
    this.startActivity(intent)
}