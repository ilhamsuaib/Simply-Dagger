package id.ilhamsuaib.dagger.data.model

import com.google.gson.annotations.SerializedName

/**
 * Created by @ilhamsuaib on 23/12/18.
 * github.com/ilhamsuaib
 */

data class PostModel(
    @field:SerializedName("userId")
    val userId: Int?,
    @field:SerializedName("id")
    val id: Int?,
    @field:SerializedName("title")
    val title: String?,
    @field:SerializedName("body")
    val body: String?
)