package onlymash.flexbooru.entity.post

import androidx.room.Entity
import androidx.room.Index
import com.tickaroo.tikxml.annotation.Attribute
import com.tickaroo.tikxml.annotation.Xml
import onlymash.flexbooru.util.formatDate
import java.text.SimpleDateFormat
import java.util.*

@Xml(name = "post")
@Entity(tableName = "posts_gelbooru", indices = [(Index(value = ["host", "keyword", "id"], unique = true))])
data class PostGel(
    @Attribute
    val id: Int,
    @Attribute
    val height: Int,
    @Attribute
    val score: Int,
    @Attribute
    val file_url: String,
    @Attribute
    val parent_id: String,
    @Attribute
    val sample_url: String,
    @Attribute
    val sample_width: Int,
    @Attribute
    val sample_height: Int,
    @Attribute
    val preview_url: String,
    @Attribute
    val rating: String,
    @Attribute
    val tags: String,
    @Attribute
    val width: Int,
    @Attribute
    val change: Long,
    @Attribute
    val md5: String,
    @Attribute
    val creator_id: Int,
    @Attribute
    val has_children: Boolean,
    @Attribute
    val created_at:	String,
    @Attribute
    val status: String,
    @Attribute
    val source: String,
    @Attribute
    val has_notes:	Boolean,
    @Attribute
    val has_comments: Boolean,
    @Attribute
    val preview_width: Int,
    @Attribute
    val preview_height: Int
) : BasePost() {

    override fun getPostId(): Int = id

    override fun getPostWidth(): Int = width

    override fun getPostHeight(): Int = height

    override fun getPostScore(): Int = score

    override fun getPostRating(): String = rating

    override fun getPreviewUrl(): String = checkUrl(preview_url)

    override fun getSampleUrl(): String = checkUrl(sample_url)

    override fun getLargerUrl(): String = getSampleUrl()

    override fun getOriginUrl(): String = checkUrl(file_url)

    override fun getCreatedDate(): String =
        formatDate(SimpleDateFormat(PATTERN, Locale.ENGLISH).parse(created_at).time).toString()

    override fun getUpdatedDate(): String =
        formatDate(change * 1000L).toString()

    companion object {
        private const val PATTERN = "EEE MMM dd HH:mm:ss Z yyyy"
    }
}