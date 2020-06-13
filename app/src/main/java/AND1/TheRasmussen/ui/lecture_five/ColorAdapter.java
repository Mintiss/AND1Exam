package AND1.TheRasmussen.ui.lecture_five;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import AND1.TheRasmussen.R;

public class ColorAdapter extends RecyclerView.Adapter<ColorAdapter.ViewHolder> {

    private ArrayList<ListItem> list;

    public ColorAdapter(ArrayList<ListItem> list) {
        this.list = list;
    }

    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.fragment_lecture_five_item, parent, false);
        return new ViewHolder(view);
    }

    public void onBindViewHolder(ViewHolder viewHolder, int position) {
        viewHolder.hex.setText(list.get(position).getColorHex());
        viewHolder.box.setBackgroundColor(Color.parseColor(list.get(position).getColorHex()));

    }

    public int getItemCount() {
        return list.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        TextView hex, box;

        ViewHolder(View itemView) {
            super(itemView);
            hex = itemView.findViewById(R.id.lecture_five_hex);
            box = itemView.findViewById(R.id.lecture_five_box);
        }
    }
}
