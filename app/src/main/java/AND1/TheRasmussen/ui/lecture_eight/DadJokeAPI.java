package AND1.TheRasmussen.ui.lecture_eight;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;

public interface DadJokeAPI {

    @Headers("Accept: application/json")
    @GET("/")
    Call<DadJoke> getDadJoke();

}
