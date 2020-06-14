package AND1.TheRasmussen.ui.lecture_eight;

import android.app.Application;
import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static okhttp3.internal.Internal.instance;

public class LectureEightRepository {

    private static LectureEightRepository instance;
    private MutableLiveData<String> joke;


    public static LectureEightRepository getInstance(Application application) {
        if (instance == null) {
            instance = new LectureEightRepository(application);
        }
        return instance;
    }

    public LectureEightRepository(Application application) {
        joke = new MutableLiveData<>();
    }

    public MutableLiveData<String> getDadJoke(){
        return joke;
    }

    public void updateDadJoke() {

        DadJokeAPI dadJokeAPI = ServiceGenerator.getDadJokeAPI();
        Call<DadJoke> call = dadJokeAPI.getDadJoke();
        call.enqueue(new Callback<DadJoke>() {
            @Override
            public void onResponse(Call<DadJoke> call, Response<DadJoke> response) {
                if (response.code() == 200) {
                    Log.i("API", response.body().getJoke());
                    joke.setValue(response.body().getJoke());
                }
            }

            @Override
            public void onFailure(Call<DadJoke> call, Throwable t) {
                Log.i("Retrofit", "Something went wrong :(");
            }
        });
    }


}

