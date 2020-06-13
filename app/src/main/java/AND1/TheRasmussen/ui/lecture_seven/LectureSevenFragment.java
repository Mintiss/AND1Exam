package AND1.TheRasmussen.ui.lecture_seven;

import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import AND1.TheRasmussen.R;

public class LectureSevenFragment extends Fragment {

    private LectureSevenViewModel mViewModel;

    public static LectureSevenFragment newInstance() {
        return new LectureSevenFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_lecture_seven, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(LectureSevenViewModel.class);
        // TODO: Use the ViewModel
    }

}
