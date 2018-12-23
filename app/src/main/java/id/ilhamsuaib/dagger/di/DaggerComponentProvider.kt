package id.ilhamsuaib.dagger.di

import android.app.Activity

/**
 * Created by @ilhamsuaib on 23/12/18.
 * github.com/ilhamsuaib
 */

interface DaggerComponentProvider {

    val appComponent: ApplicationComponent
}

val Activity.injector: ApplicationComponent get() = (application as DaggerComponentProvider).appComponent