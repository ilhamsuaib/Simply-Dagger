package id.ilhamsuaib.dagger.utils

import android.content.Context
import android.widget.Toast

/**
 * Created by @ilhamsuaib on 23/12/18.
 * github.com/ilhamsuaib
 */

fun Context.toast(message: String?) {
    message?.let {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}