package id.ilhamsuaib.dagger.data

import id.ilhamsuaib.dagger.model.Post
import io.reactivex.Observable
import retrofit2.http.GET

/**
 * Created by @ilhamsuaib on 23/12/18.
 * github.com/ilhamsuaib
 */

interface PostService {

    @GET("posts")
    fun getPosts(): Observable<List<Post>>
}