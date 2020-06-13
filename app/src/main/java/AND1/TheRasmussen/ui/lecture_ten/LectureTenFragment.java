package AND1.TheRasmussen.ui.lecture_ten;

import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import AND1.TheRasmussen.R;

public class LectureTenFragment extends Fragment {

    private LectureTenViewModel mViewModel;

    public static LectureTenFragment newInstance() {
        return new LectureTenFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_lecture_ten, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(LectureTenViewModel.class);
        // TODO: Use the ViewModel
    }

}
