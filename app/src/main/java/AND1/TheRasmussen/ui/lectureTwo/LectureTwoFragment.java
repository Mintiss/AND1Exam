package AND1.TheRasmussen.ui.lectureTwo;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import AND1.TheRasmussen.R;

public class LectureTwoFragment extends Fragment {

    private LectureTwoViewModel lectureTwoViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        lectureTwoViewModel =
                ViewModelProviders.of(this).get(LectureTwoViewModel.class);
        View root = inflater.inflate(R.layout.fragment_lecture_two, container, false);
        final TextView textView = root.findViewById(R.id.text_slideshow);
        lectureTwoViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }
}