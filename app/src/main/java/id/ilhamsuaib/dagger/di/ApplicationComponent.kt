package id.ilhamsuaib.dagger.di

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import id.ilhamsuaib.dagger.home.HomeViewModel
import javax.inject.Singleton

/**
 * Created by @ilhamsuaib on 23/12/18.
 * github.com/ilhamsuaib
 */

@Singleton
@Component(modules = [NetworkModule::class])
interface ApplicationComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun applicationContext(context: Context): Builder

        fun build(): ApplicationComponent
    }

    fun homeViewModelFactory(): ViewModelFactory<HomeViewModel>
}