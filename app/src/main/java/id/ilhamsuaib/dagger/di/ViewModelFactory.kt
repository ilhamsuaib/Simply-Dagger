package id.ilhamsuaib.dagger.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import javax.inject.Inject
import javax.inject.Provider

/**
 * Created by @ilhamsuaib on 23/12/18.
 * github.com/ilhamsuaib
 */

class ViewModelFactory<VM : ViewModel> @Inject constructor(private val viewModel: Provider<VM>) :
    ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return viewModel.get() as T
    }
}