package program.java.punch.andr.omdb_client_kotlin.services

import io.reactivex.Observable
import program.java.punch.andr.omdb_client_kotlin.data.model.Movies
import retrofit2.http.GET
import retrofit2.http.Query

interface RetrofitService {
    @GET("/?apikey=8d82b59e&?type=movie")
    fun getMovies(@Query("s") Title: String): Observable<Movies>
}