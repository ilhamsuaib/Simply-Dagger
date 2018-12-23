package id.ilhamsuaib.dagger.home

import com.xwray.groupie.kotlinandroidextensions.Item
import com.xwray.groupie.kotlinandroidextensions.ViewHolder
import id.ilhamsuaib.dagger.R
import id.ilhamsuaib.dagger.model.Post
import kotlinx.android.synthetic.main.item_post.view.*

/**
 * Created by @ilhamsuaib on 23/12/18.
 * github.com/ilhamsuaib
 */

class PostAdapter(private val post: Post) : Item() {

    override fun bind(viewHolder: ViewHolder, position: Int) {
        viewHolder.itemView.apply {
            tvTitle.text = post.title
            tvBody.text = post.body
        }
    }

    override fun getLayout(): Int = R.layout.item_post
}