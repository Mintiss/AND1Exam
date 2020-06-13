package AND1.TheRasmussen.ui.lecture_eight;

import android.util.Log;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LectureEightRepository {

    private String joke;

    public String getDadJoke() {

        DadJokeAPI dadJokeAPI = ServiceGenerator.getDadJokeAPI();
        Call<DadJoke> call = dadJokeAPI.getDadJoke();
        call.enqueue(new Callback<DadJoke>() {
            @Override
            public void onResponse(Call<DadJoke> call, Response<DadJoke> response) {
                if (response.code() == 200) {
                    joke = response.body().getJoke();
                    Log.i("ass", joke);

                }
            }

            @Override
            public void onFailure(Call<DadJoke> call, Throwable t) {
                Log.i("Retrofit", "Something went wrong :(");
            }
        });


        return joke;
    }


}
