package me.vavra.javatokotlintips

import android.view.View

fun ifNotNull(first: String?, second: String?, ifBothNotNull: (String, String)->Unit) {
    if (first != null && second != null) {
        ifBothNotNull(first, second)
    }
}

fun View.show() {
    this.visibility = View.VISIBLE
}