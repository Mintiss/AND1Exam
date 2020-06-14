package AND1.TheRasmussen.ui.lecture_ten;

import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.ArrayList;

import AND1.TheRasmussen.R;

public class LectureTenFragment extends Fragment implements View.OnClickListener {

    private View view;
    private Button byeButton;
    public static LectureTenFragment newInstance() {
        return new LectureTenFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {


        view = inflater.inflate(R.layout.fragment_lecture_ten, container, false);

        byeButton = view.findViewById(R.id.bye_button);
        byeButton.setOnClickListener(this);

        return view;
    }


    @Override
    public void onClick(View v) {
        getActivity().moveTaskToBack(true);
        getActivity().finish();
    }
}
