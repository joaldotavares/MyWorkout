package br.com.myworkout.commons.extensions

import android.content.Context
import android.view.View
import com.google.android.material.snackbar.Snackbar

fun Context.showSnackBar(view: View, text: Int) {
    Snackbar.make(
        this,
        view,
        this.getString(text),
        Snackbar.LENGTH_SHORT
    ).show()
}
