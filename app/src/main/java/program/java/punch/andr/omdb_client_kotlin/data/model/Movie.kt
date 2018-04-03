package program.java.punch.andr.omdb_client_kotlin.data.model

import android.arch.persistence.room.*
import android.support.annotation.NonNull

@Entity(tableName = "favourite_movies", indices = arrayOf(Index(value = ["movie_id"],
        unique = true)))
data class Movie(

        @PrimaryKey(autoGenerate = true)
        var id: Long,

        @ColumnInfo(name = "movie_title")
        var Title: String?,

        @ColumnInfo(name = "movie_year")
        var Year: String?,

        @ColumnInfo(name = "movie_rated")
        @NonNull
        var Rated: String?,

        @ColumnInfo(name = "movie_released")
        var Released: String?,

        @ColumnInfo(name = "movie_genre")
        var Genre: String?,

        @ColumnInfo(name = "movie_director")
        var Director: String?,

        @ColumnInfo(name = "movie_writer")
        var Writer: String?,

        @ColumnInfo(name = "movie_actors")
        var Actors: String?,

        @ColumnInfo(name = "movie_plot")
        var Plot: String?,

        @ColumnInfo(name = "movie_language")
        var Language: String?,

        @ColumnInfo(name = "movie_country")
        var Country: String?,

        @ColumnInfo(name = "movie_awards")
        var Awards: String?,

        @ColumnInfo(name = "movie_poster")
        var Poster: String?,

        @ColumnInfo(name = "movie_metascore")
        var Metascore: String?,

        @ColumnInfo(name = "movie_rating")
        var imdbRatinge: String?,

        @ColumnInfo(name = "movie_votes")
        var imdbVotes: String?,

        @ColumnInfo(name = "movie_id")
        var imdbID: String,

        @ColumnInfo(name = "movie_type")
        var Type: String?,

        @ColumnInfo(name = "movie_response")
        var Response: String?
)