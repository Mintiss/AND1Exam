package AND1.TheRasmussen.ui.lecture_eight;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ServiceGenerator {
    private static Retrofit.Builder retrofitBuilder = new Retrofit.Builder()
            .baseUrl("https://icanhazdadjoke.com")
            .addConverterFactory(GsonConverterFactory.create());

    private static Retrofit retrofit = retrofitBuilder.build();

    private static DadJokeAPI dadJokeAPI = retrofit.create(DadJokeAPI.class);

    public static DadJokeAPI getDadJokeAPI() {
        return dadJokeAPI;
    }
}
