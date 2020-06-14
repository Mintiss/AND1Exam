package AND1.TheRasmussen.ui.lecture_eight;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
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
        mViewModel = new ViewModelProvider(this).get(LectureEightViewModel.class);


        dadJoke = view.findViewById(R.id.lecture_eight_dad_joke_text);
        dadJokeButton = view.findViewById(R.id.lecture_eight_dad_joke_button);

        mViewModel.getDadJoke().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(String s) {
                dadJoke.setText(s);
            }
        });


        dadJokeButton.setOnClickListener(this);



        return view;
    }


    @Override
    public void onClick(View v) {
        mViewModel.updateDadJoke();

    }

}
