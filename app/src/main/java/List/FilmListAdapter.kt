package List

import android.view.LayoutInflater

import android.view.ViewGroup
import android.widget.AbsListView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.migue.gar.databinding.FilmListBinding
import com.migue.gar.databinding.FilmOverviewBinding
import javax.inject.Inject
typealias OnMessageClick = (FilmOverviewDataView)-> Unit
open class FilmViewHolder(val binding: FilmOverviewBinding): RecyclerView.ViewHolder(binding.root)

class FilmListAdapter @Inject constructor(): ListAdapter<FilmOverviewDataView, FilmViewHolder>(diffUtil) {
    companion object{
        private val diffUtil = object :DiffUtil.ItemCallback<FilmOverviewDataView>(){
            override fun areItemsTheSame(
                oldItem: FilmOverviewDataView,
                newItem: FilmOverviewDataView
            )=oldItem.title == newItem.title

            override fun areContentsTheSame(
                oldItem: FilmOverviewDataView,
                newItem: FilmOverviewDataView
            )=oldItem==newItem
            }

         }
    var callback : OnMessageClick? = null
    override fun onCreateViewHolder(parent:ViewGroup,viewType:Int)=
        object :FilmViewHolder(FilmOverviewBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
false   )){}

    override fun onBindViewHolder(holder: FilmViewHolder, position: Int) {
    val film=getItem(position)
    holder.binding.textView.text = film.title
    Glide.with(holder.binding.imageView3).load(film.imageUrl).into(holder.binding.imageView3)
        holder.binding.root.setOnClickListener {
            callback?.invoke(film)
        }
}
}