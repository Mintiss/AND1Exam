package AND1.TheRasmussen.ui.lecture_five;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import AND1.TheRasmussen.R;

public class LectureFiveFragment extends Fragment {

    private ArrayList<ListItem> colors;
    private RecyclerView colorList;
    private ColorAdapter adapter;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_lecture_five, container, false);

        colorList = root.findViewById(R.id.recycler_view);
        colorList.hasFixedSize();
        colorList.setLayoutManager(new LinearLayoutManager(getContext()));
        colors = new ArrayList<>();
        for (int i = 0; i<=1000000000; i++){
            colors.add(new ListItem(String.format("#%06X", (0xFFFFFF & i))));
            i+=10000000;
        }


        adapter = new ColorAdapter(colors);
        colorList.setAdapter(adapter);



        return root;
    }
}