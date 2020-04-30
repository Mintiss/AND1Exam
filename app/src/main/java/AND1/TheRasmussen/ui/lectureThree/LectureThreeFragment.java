package AND1.TheRasmussen.ui.lectureThree;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import AND1.TheRasmussen.R;

import static android.app.Activity.RESULT_OK;

public class LectureThreeFragment extends Fragment implements View.OnClickListener{

    private View view;
    private Button fragmentButton;
    private EditText toActivity;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_lecture_three, container, false);
        fragmentButton = view.findViewById(R.id.lecture_three_fragment_button);
        toActivity = view.findViewById(R.id.lecture_three_fragment_edit_view);

        fragmentButton.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v) {
        if(toActivity.getText().toString().equals("")){
            Intent intent = new Intent(getActivity(), LectureThreeActivity.class);
            startActivity(intent);
        }
        else {
            Intent intent = new Intent(getActivity(), LectureThreeActivity.class);
            intent.putExtra("text", toActivity.getText().toString());
            startActivityForResult(intent, 1);
        }
    }

}