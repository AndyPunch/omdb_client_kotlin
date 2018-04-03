package program.java.punch.andr.omdb_client_kotlin.data.model

data class Movies(
        val Search: List<Movie>,
        val totalResults: String,
        val Response: String
)