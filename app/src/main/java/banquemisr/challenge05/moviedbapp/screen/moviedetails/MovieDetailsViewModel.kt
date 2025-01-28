package banquemisr.challenge05.moviedbapp.screen.moviedetails

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import banquemisr.challenge05.domain.entity.details.MovieDetailsResponse
import banquemisr.challenge05.domain.usecase.MovieDetailsUseCase
import banquemisr.challenge05.moviedbapp.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class MovieDetailsViewModel @Inject constructor(private val movieDetailsUseCase: MovieDetailsUseCase)
    : ViewModel(){


        suspend fun getMovieDetails(id: Int): Resource<MovieDetailsResponse> {
            val response = try {
                movieDetailsUseCase(id)
            } catch(e: Exception) {
                return Resource.Error(e.message.toString())
            }
            return Resource.Success(response)
        }
}