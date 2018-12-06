package program.java.punch.andr.omdb_client_kotlin.model

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.Index
import android.arch.persistence.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "favourite_movies", indices = arrayOf(Index(value = ["movie_id"],
        unique = true)))
data class Movie(

        @PrimaryKey(autoGenerate = true)
        var id: Long,

        @ColumnInfo(name = "movie_title")
        @SerializedName("Title")
        val title: String? = null,

        @ColumnInfo(name = "movie_year")
        @SerializedName("Year")
        val year: String? = null,

        @ColumnInfo(name = "movie_id")
        @SerializedName("imdbID")
        val imdbId: String? = null,

        @ColumnInfo(name = "movie_poster")
        @SerializedName("Poster")
        var poster: String? = null
)