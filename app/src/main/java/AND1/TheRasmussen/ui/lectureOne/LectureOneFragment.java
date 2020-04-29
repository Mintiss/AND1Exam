package AND1.TheRasmussen.ui.lectureOne;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import AND1.TheRasmussen.R;

public class LectureOneFragment extends Fragment implements View.OnClickListener {

    private View view;
    private Button button;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_lecture_one, container, false);

        button =  view.findViewById(R.id.lecture_one_button);
        button.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v) {
        Toast.makeText(getContext(), "YEET", Toast.LENGTH_SHORT).show();

    }
}