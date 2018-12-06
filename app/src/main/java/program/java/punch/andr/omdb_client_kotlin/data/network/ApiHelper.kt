package program.java.punch.andr.omdb_client_kotlin.data.network

import io.reactivex.Observable
import program.java.punch.andr.omdb_client_kotlin.model.Movies
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiHelper {
    @GET("/")
    fun getMovies(
            @Query("apikey") apikey: String,
            @Query("type") type: String,
            @Query("s") title: String
    ): Observable<Movies>
}