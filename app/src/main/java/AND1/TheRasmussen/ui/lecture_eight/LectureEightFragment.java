package AND1.TheRasmussen.ui.lecture_eight;

import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import AND1.TheRasmussen.R;

public class LectureEightFragment extends Fragment {

    private LectureEightViewModel mViewModel;

    public static LectureEightFragment newInstance() {
        return new LectureEightFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_lecture_eight, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(LectureEightViewModel.class);
        // TODO: Use the ViewModel
    }

}
