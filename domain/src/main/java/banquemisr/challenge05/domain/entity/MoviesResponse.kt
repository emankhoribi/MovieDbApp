package banquemisr.challenge05.domain.entity

data class MoviesResponse(
    val dates: Dates,
    val page: Int,
    val results: List<MoviesResult>,
    val total_pages: Int,
    val total_results: Int
)