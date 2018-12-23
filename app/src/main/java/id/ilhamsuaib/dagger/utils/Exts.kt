package id.ilhamsuaib.dagger.utils

import com.google.gson.Gson

/**
 * Created by @ilhamsuaib on 23/12/18.
 * github.com/ilhamsuaib
 */

fun Any.toJson() = Gson().toJsonTree(this)