package AND1.TheRasmussen.ui.lecture_eight;

import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import AND1.TheRasmussen.R;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LectureEightFragment extends Fragment implements View.OnClickListener {

    private View view;
    private LectureEightViewModel mViewModel;
    private Button dadJokeButton;
    private TextView dadJoke;

    public static LectureEightFragment newInstance() {
        return new LectureEightFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_lecture_eight, container, false);

        dadJoke = view.findViewById(R.id.lecture_eight_dad_joke_text);
        dadJokeButton = view.findViewById(R.id.lecture_eight_dad_joke_button);


        dadJokeButton.setOnClickListener(this);



        return view;
    }


    @Override
    public void onClick(View v) {

        DadJokeAPI dadJokeAPI = ServiceGenerator.getDadJokeAPI();
        Call<DadJoke> call = dadJokeAPI.getDadJoke();
        call.enqueue(new Callback<DadJoke>() {
            @Override
            public void onResponse(Call<DadJoke> call, Response<DadJoke> response) {
                if (response.code() == 200) {
                    Log.i("ass", response.body().getJoke());

                }
            }

            @Override
            public void onFailure(Call<DadJoke> call, Throwable t) {
                Log.i("Retrofit", "Something went wrong :(");
            }
        });

    }
}
