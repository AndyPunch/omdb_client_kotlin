package program.java.punch.andr.omdb_client_kotlin.adapters

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import program.java.punch.andr.omdb_client_kotlin.R
import program.java.punch.andr.omdb_client_kotlin.data.model.Movie
import program.java.punch.andr.omdb_client_kotlin.ui.favourite.interfaces.OnDeleteFavouriteClick
import program.java.punch.andr.omdb_client_kotlin.utils.GlideApp
import java.util.*


class FavouriteAdapter(private val context: Context, private val listener: OnDeleteFavouriteClick)
    : RecyclerView.Adapter<FavouriteAdapter.FavouriteHolder>() {


    private val favouriteList = ArrayList<Movie>()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
            FavouriteHolder(LayoutInflater.from(context)
                    .inflate(R.layout.favourite_item_movie, parent, false))


    override fun getItemCount() = favouriteList.size;


    override fun onBindViewHolder(holder: FavouriteHolder, position: Int) {

        holder.movieTitle.setText(favouriteList[position].Title)
        GlideApp.with(context).load(favouriteList[position].Poster)
                .placeholder(R.drawable.noimage).into(holder.thumbnailImg)

        holder.favouriteImg.setOnClickListener({ view ->
            listener.OnDeleteFavouriteMovieClick(favouriteList[position])
        })
    }


    fun addMoviesToAdapter(l: List<Movie>) {
        favouriteList.clear()
        favouriteList.addAll(l)
        notifyDataSetChanged()
    }


    fun clearMovies() {
        favouriteList.clear()
        notifyDataSetChanged()
    }


    inner class FavouriteHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var movieTitle: TextView = itemView.findViewById(R.id.movie_title_favourite) as TextView
        var thumbnailImg: ImageView = itemView.findViewById(R.id.thumbnail_favourite) as ImageView
        var favouriteImg: ImageButton = itemView.findViewById(R.id.favourite_delete) as ImageButton


    }


}