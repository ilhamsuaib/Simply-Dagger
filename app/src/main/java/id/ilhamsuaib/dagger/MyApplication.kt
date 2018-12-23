package id.ilhamsuaib.dagger

import android.app.Application
import id.ilhamsuaib.dagger.di.ApplicationComponent
import id.ilhamsuaib.dagger.di.DaggerApplicationComponent
import id.ilhamsuaib.dagger.di.DaggerComponentProvider

/**
 * Created by @ilhamsuaib on 23/12/18.
 * github.com/ilhamsuaib
 */

class MyApplication : Application(), DaggerComponentProvider {

    override val appComponent: ApplicationComponent by lazy {
        DaggerApplicationComponent.builder()
            .applicationContext(applicationContext)
            .build()
    }

    override fun onCreate() {
        super.onCreate()
    }
}