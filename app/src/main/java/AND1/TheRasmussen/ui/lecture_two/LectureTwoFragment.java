package AND1.TheRasmussen.ui.lecture_two;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import java.util.Random;

import AND1.TheRasmussen.R;

import static android.content.res.Configuration.ORIENTATION_LANDSCAPE;

public class LectureTwoFragment extends Fragment implements View.OnClickListener{

    private String goBack;
    private View view;
    private Button editTextButton, plusButton, minusButton;
    private ProgressBar progressBar;
    private EditText editText;
    private TextView styledTextView, introTextView, progressTextView;
    private ImageButton iconButton;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_lecture_two, container, false);

        editText = view.findViewById(R.id.lecture_two_edit_text);
        editTextButton =  view.findViewById(R.id.lecture_two_button);
        progressBar = view.findViewById(R.id.lecture_two_progressbar);
        plusButton = view.findViewById(R.id.lecture_two_plus_button);
        minusButton = view.findViewById(R.id.lecture_two_minus_button);
        iconButton = view.findViewById(R.id.lecture_two_icon_button);
        styledTextView = view.findViewById(R.id.lecture_two_styled_text);
        introTextView = view.findViewById(R.id.lecture_two_intro_text);
        progressTextView = view.findViewById(R.id.lecture_two_progress_text);


        editTextButton.setOnClickListener(this);
        plusButton.setOnClickListener(this);
        minusButton.setOnClickListener(this);
        iconButton.setOnClickListener(this);


        if(view.getResources().getConfiguration().orientation == ORIENTATION_LANDSCAPE){
            goBack = " GO BACK";
            editText.setHint(goBack);
            plusButton.setText(goBack);
            minusButton.setText(goBack);
            styledTextView.setText(goBack);
            editTextButton.setText(goBack);
            introTextView.setText(goBack);
            progressTextView.setText(goBack);

        }

        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){

            case R.id.lecture_two_button:
                Log.i("Example", "Some logging functionality.");
                Toast.makeText(getContext(), "This is a Toast", Toast.LENGTH_SHORT).show();
                editTextButton.setText(editText.getText().toString());
                break;
            case R.id.lecture_two_plus_button:
                if(plusButton.isPressed()) {
                    progressBar.incrementProgressBy(10);
                    break;
                }
            case R.id.lecture_two_minus_button:
                if(minusButton.isPressed()) {
                    progressBar.incrementProgressBy(-10);
                    break;
                }
            case R.id.lecture_two_icon_button:
                switch (new Random().nextInt(5)){

                    case 0:
                        iconButton.setImageDrawable(view.getResources().getDrawable(R.drawable.ic_menu_slideshow));
                        styledTextView.setTextAppearance(R.style.TextAppearance_AppCompat_Menu);
                        break;
                    case 1:
                        iconButton.setImageDrawable(view.getResources().getDrawable(R.drawable.ic_menu_camera));
                        styledTextView.setTextAppearance(R.style.TextAppearance_AppCompat_Large);
                        break;
                    case 2:
                        iconButton.setImageDrawable(view.getResources().getDrawable(R.drawable.ic_menu_share));
                        styledTextView.setTextAppearance(R.style.TextAppearance_MdcTypographyStyles_Subtitle1);
                        break;
                    case 3:
                        iconButton.setImageDrawable(view.getResources().getDrawable(R.drawable.ic_menu_send));
                        styledTextView.setTextAppearance(R.style.TextAppearance_MdcTypographyStyles_Button);
                        break;
                    case 4:
                        iconButton.setImageDrawable(view.getResources().getDrawable(R.drawable.ic_menu_gallery));
                        styledTextView.setTextAppearance(R.style.TextAppearance_MdcTypographyStyles_Overline);
                        break;
                    case 5:
                        iconButton.setImageDrawable(view.getResources().getDrawable(R.drawable.ic_menu_manage));
                        styledTextView.setTextAppearance(R.style.TextAppearance_AppCompat_Medium_Inverse);
                        break;
                }



        }




    }
}