package AND1.TheRasmussen.ui.lecture_seven;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;

import java.util.List;

import AND1.TheRasmussen.R;

public class LectureSevenFragment extends Fragment implements View.OnClickListener {

    private View view;
    private LectureSevenViewModel mViewModel;
    private RadioButton red, green, blue, clear;
    private TextView colorText;
    private TextView previousColors;
    private Button clearList;


    public static LectureSevenFragment newInstance() {
        return new LectureSevenFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        mViewModel = new ViewModelProvider(this).get(LectureSevenViewModel.class);

        view = inflater.inflate(R.layout.fragment_lecture_seven, container, false);
        colorText = view.findViewById(R.id.lecture_seven_color_text);
        previousColors = view.findViewById(R.id.lecture_seven_previous_colors);
        clearList = view.findViewById(R.id.lecture_seven_clear_list_button);

        red = view.findViewById(R.id.lecture_seven_radio_red);
        green = view.findViewById(R.id.lecture_seven_radio_green);
        blue = view.findViewById(R.id.lecture_seven_radio_blue);
        clear = view.findViewById(R.id.lecture_seven_radio_blank);

        red.setOnClickListener(this);
        green.setOnClickListener(this);
        blue.setOnClickListener(this);
        clear.setOnClickListener(this);
        clearList.setOnClickListener(this);

        if (mViewModel.preferencesContainColor()){

            String color = mViewModel.getColor();

            switch (color){
                case "red":
                    colorText.setBackgroundColor(Color.RED);
                    red.setSelected(true);
                    break;
                case "green":
                    colorText.setBackgroundColor(Color.GREEN);
                    green.setSelected(true);
                    break;
                case "blue":
                    colorText.setBackgroundColor(Color.BLUE);
                    blue.setSelected(true);
                    break;
                case "blank":
                    colorText.setBackgroundColor(Color.TRANSPARENT);
                    clear.setSelected(true);
                    break;
            }
        }

        mViewModel.getPreviousColorList().observe(getViewLifecycleOwner(), new Observer<List<ColorEntity>>() {
            @Override
            public void onChanged(List<ColorEntity> colorEntities) {
                    if (!colorEntities.isEmpty()) {
                        previousColors.setText("");
                        for (ColorEntity colorEntity : colorEntities) {
                            previousColors.append(colorEntity.getColor() + "\t");
                        }
                    } else {
                        previousColors.setText("Nothing");
                    }
            }
        });

        return view;
    }


    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.lecture_seven_clear_list_button){
            mViewModel.clearList();
        }
        else{
            boolean checked = ((RadioButton) v).isChecked();

            switch(v.getId()) {
                case R.id.lecture_seven_radio_red:
                    if (checked)
                        mViewModel.storeColorInLocalDB("red");
                    mViewModel.storeColor("red");
                    colorText.setBackgroundColor(Color.RED);
                    break;
                case R.id.lecture_seven_radio_blue:
                    if (checked)
                        mViewModel.storeColorInLocalDB("blue");
                    mViewModel.storeColor("blue");
                    colorText.setBackgroundColor(Color.BLUE);
                    break;
                case R.id.lecture_seven_radio_green:
                    if (checked)
                        mViewModel.storeColorInLocalDB("green");
                    mViewModel.storeColor("green");
                    colorText.setBackgroundColor(Color.GREEN);
                    break;
                case R.id.lecture_seven_radio_blank:
                    if (checked)
                        mViewModel.storeColorInLocalDB("blank");
                    mViewModel.storeColor("blank");
                    colorText.setBackgroundColor(Color.TRANSPARENT);
                    break;
            }
        }
    }
}
