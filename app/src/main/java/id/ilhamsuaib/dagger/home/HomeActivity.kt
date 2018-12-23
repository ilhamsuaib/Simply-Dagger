package id.ilhamsuaib.dagger.home

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.kotlinandroidextensions.ViewHolder
import id.ilhamsuaib.dagger.R
import id.ilhamsuaib.dagger.di.injector
import id.ilhamsuaib.dagger.model.Post
import id.ilhamsuaib.dagger.utils.toJson
import id.ilhamsuaib.dagger.utils.toast
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity() {

    private val tag = "HomeActivity"
    private val viewModel: HomeViewModel by lazy {
        ViewModelProviders.of(this, injector.homeViewModelFactory())
            .get(HomeViewModel::class.java)
    }

    private val postAdapter = GroupAdapter<ViewHolder>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        setupView()

        if (savedInstanceState == null) viewModel.loadPosts()

        observeHomeState()
    }

    private fun setupView() {
        rvPost.apply {
            layoutManager = LinearLayoutManager(this@HomeActivity)
            adapter = postAdapter
        }
    }

    private fun observeHomeState() {
        viewModel.homeState.observe(this, Observer { state ->
            when (state) {
                is OnLoadPostState -> onLoadPost(state.postList)
                is OnErrorState -> onError(state.t)
            }
        })
    }

    private fun onError(t: Throwable) {
        toast(t.localizedMessage)
    }

    private fun onLoadPost(postList: List<Post>) {
        Log.d(tag, "onLoadPost : ${postList.toJson()}")
        postAdapter.clear()
        postList.forEach {
            postAdapter.add(PostAdapter(it))
        }
        postAdapter.notifyDataSetChanged()
    }
}
