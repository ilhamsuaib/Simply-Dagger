package id.ilhamsuaib.dagger.data

import dagger.Reusable
import id.ilhamsuaib.dagger.model.Post
import io.reactivex.Single
import javax.inject.Inject

/**
 * Created by @ilhamsuaib on 23/12/18.
 * github.com/ilhamsuaib
 */

@Reusable
class HomeRepository @Inject constructor(private val service: PostService) {

    fun getPosts(): Single<List<Post>> {
        return service.getPosts()
            .flatMapIterable { it }
            .map {
                Post(
                    id = it.id,
                    title = it.title,
                    body = it.body
                )
            }
            .toList()
    }
}