package AND1.TheRasmussen.ui.lecture_four;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;

import java.util.Random;

import AND1.TheRasmussen.R;

public class LectureFourFragment extends Fragment implements View.OnClickListener {

    private View view;
    private Button snackButton;
    private LectureFourViewModel lectureFourViewModel;
    private FloatingActionButton fab;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        lectureFourViewModel =
                ViewModelProviders.of(this).get(LectureFourViewModel.class);
         view = inflater.inflate(R.layout.fragment_lecture_four, container, false);

         snackButton = view.findViewById(R.id.lecture_four_snack_button);
         fab = view.findViewById(R.id.fab);

         fab.setOnClickListener(this);
         snackButton.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.fab:
                NavDirections action;
                switch (new Random().nextInt(10)+1){
                    case 1:
                        action = LectureFourFragmentDirections.actionNavLectureFourToNavHome();
                        Navigation.findNavController(getActivity(), R.id.nav_host_fragment).navigate(action);
                        break;
                    case 2:
                        action = LectureFourFragmentDirections.actionNavLectureFourToNavLectureEight();
                        Navigation.findNavController(getActivity(), R.id.nav_host_fragment).navigate(action);
                        break;
                    case 3:
                        action = LectureFourFragmentDirections.actionNavLectureFourToNavLectureFive();
                        Navigation.findNavController(getActivity(), R.id.nav_host_fragment).navigate(action);
                        break;
                    case 4:
                        action = LectureFourFragmentDirections.actionNavLectureFourToNavLectureNine();
                        Navigation.findNavController(getActivity(), R.id.nav_host_fragment).navigate(action);
                        break;
                    case 5:
                        action = LectureFourFragmentDirections.actionNavLectureFourToNavLectureOne();
                        Navigation.findNavController(getActivity(), R.id.nav_host_fragment).navigate(action);
                        break;
                    case 6:
                        action = LectureFourFragmentDirections.actionNavLectureFourToNavLectureSeven();
                        Navigation.findNavController(getActivity(), R.id.nav_host_fragment).navigate(action);
                        break;
                    case 7:
                        action = LectureFourFragmentDirections.actionNavLectureFourToNavLectureSix();
                        Navigation.findNavController(getActivity(), R.id.nav_host_fragment).navigate(action);
                        break;
                    case 8:
                        action = LectureFourFragmentDirections.actionNavLectureFourToNavLectureTen();
                        Navigation.findNavController(getActivity(), R.id.nav_host_fragment).navigate(action);
                        break;
                    case 9:
                        action = LectureFourFragmentDirections.actionNavLectureFourToNavLectureThree();
                        Navigation.findNavController(getActivity(), R.id.nav_host_fragment).navigate(action);
                        break;
                    case 10:
                        action = LectureFourFragmentDirections.actionNavLectureFourToNavLectureTwo();
                        Navigation.findNavController(getActivity(), R.id.nav_host_fragment).navigate(action);
                        break;

                }
                break;
             default:
                 break;

        }

        Snackbar.make(view.findViewById(R.id.coordinator_layout), "This is a useless Snack Bar", BaseTransientBottomBar.LENGTH_SHORT).show();

    }
}