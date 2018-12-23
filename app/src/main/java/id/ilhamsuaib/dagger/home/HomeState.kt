package id.ilhamsuaib.dagger.home

import id.ilhamsuaib.dagger.model.Post

/**
 * Created by @ilhamsuaib on 23/12/18.
 * github.com/ilhamsuaib
 */

sealed class HomeState

data class OnLoadPostState(val postList: List<Post>) : HomeState()

data class OnErrorState(val t: Throwable) : HomeState()