package program.java.punch.andr.omdb_client_kotlin.model

import com.google.gson.annotations.SerializedName

data class Movies(
        @SerializedName("Search")
        val movies: List<Movie>? = null
)