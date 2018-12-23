package id.ilhamsuaib.dagger.home

import androidx.lifecycle.*
import id.ilhamsuaib.dagger.data.HomeRepository
import id.ilhamsuaib.dagger.model.Post
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

/**
 * Created by @ilhamsuaib on 23/12/18.
 * github.com/ilhamsuaib
 */

class HomeViewModel @Inject constructor(private val repo: HomeRepository) : ViewModel() {

    private val disposables = CompositeDisposable()

    val homeState = MutableLiveData<HomeState>()

    fun loadPosts() {
        disposables.add(
            repo.getPosts()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::onLoadPosts, this::onError)
        )
    }

    private fun onError(t: Throwable) {
        homeState.value = OnErrorState(t)
    }

    private fun onLoadPosts(posts: List<Post>) {
        homeState.value = OnLoadPostState(posts)
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    fun dispose() {
        if (!disposables.isDisposed) disposables.dispose()
    }
}