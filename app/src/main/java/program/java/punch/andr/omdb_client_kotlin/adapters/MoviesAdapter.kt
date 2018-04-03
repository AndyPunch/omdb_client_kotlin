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
import program.java.punch.andr.omdb_client_kotlin.ui.main.interfaces.OnAddFavouriteClick
import program.java.punch.andr.omdb_client_kotlin.utils.GlideApp
import java.util.ArrayList


class MoviesAdapter(private val context: Context, private val listener: OnAddFavouriteClick) :
        RecyclerView.Adapter<MoviesAdapter.MoviesHolder>() {


    private val moviesList = ArrayList<Movie>()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
            MoviesHolder(LayoutInflater.from(context)
                    .inflate(R.layout.list_item_movie, parent, false))


    override fun getItemCount() = moviesList.size;


    override fun onBindViewHolder(holder: MoviesHolder, position: Int) {
        holder.movieTitle.setText(moviesList[position].Title)
        GlideApp.with(context).load(moviesList[position].Poster)
                .placeholder(R.drawable.noimage).into(holder.thumbnailImg)

        holder.favouriteImg.setOnClickListener { view ->
            listener
                    .OnAddFavouriteMovieClick(moviesList[position])
        }

    }


    fun addMoviesToAdapter(l: List<Movie>) {
        moviesList.clear()
        moviesList.addAll(l)
        notifyDataSetChanged()
    }


    fun clearMovies() {
        moviesList.clear()
        notifyDataSetChanged()
    }


    inner class MoviesHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var movieTitle: TextView = itemView.findViewById(R.id.movie_title) as TextView
        var thumbnailImg: ImageView = itemView.findViewById(R.id.thumbnail) as ImageView
        var favouriteImg: ImageButton = itemView.findViewById(R.id.favourite) as ImageButton


    }


}