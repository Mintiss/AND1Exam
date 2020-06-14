package AND1.TheRasmussen.ui.lecture_six;

import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import AND1.TheRasmussen.R;

public class LectureSixFragment extends Fragment {


    public static LectureSixFragment newInstance() {
        return new LectureSixFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_lecture_six, container, false);
    }


}
