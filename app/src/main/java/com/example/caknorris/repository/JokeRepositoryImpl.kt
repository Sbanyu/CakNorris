import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.caknorris.apiservice.ChuckNorrisApi
import com.example.caknorris.model.Joke
import com.example.caknorris.model.JokeSearchResponse
import com.example.caknorris.repository.JokeRepository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class JokeRepositoryImpl(private val apiService: ChuckNorrisApi) : JokeRepository {
    override fun getRandomJoke(): LiveData<Joke> {
        val jokeLiveData = MutableLiveData<Joke>()
        apiService.getRandomJoke().enqueue(object : Callback<Joke> {
            override fun onResponse(call: Call<Joke>, response: Response<Joke>) {
                Log.d("API Response", "Code: ${response.code()}, Body: ${response.body()}")
                if (response.isSuccessful) {
                    response.body()?.let { jokeLiveData.value = it }
                } else {
                    jokeLiveData.value = null
                }
            }

            override fun onFailure(call: Call<Joke>, t: Throwable) {
                Log.e("API Error", "Error fetching joke", t)
                jokeLiveData.value = null
            }
        })
        return jokeLiveData
    }

    override fun searchJokes(query: String): LiveData<List<Joke>> {
        val jokeListLiveData = MutableLiveData<List<Joke>>()
        apiService.searchJokes(query).enqueue(object : Callback<JokeSearchResponse> {
            override fun onResponse(call: Call<JokeSearchResponse>, response: Response<JokeSearchResponse>) {
                Log.d("API Response", "Code: ${response.code()}, Body: ${response.body()}")
                if (response.isSuccessful) {
                    response.body()?.result?.let { jokeListLiveData.value = it }
                } else {
                    jokeListLiveData.value = emptyList()
                }
            }

            override fun onFailure(call: Call<JokeSearchResponse>, t: Throwable) {
                Log.e("API Error", "Error searching jokes", t)
                jokeListLiveData.value = emptyList()
            }
        })
        return jokeListLiveData
    }
}