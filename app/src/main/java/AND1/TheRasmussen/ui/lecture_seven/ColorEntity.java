package AND1.TheRasmussen.ui.lecture_seven;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "color_table")
public class ColorEntity {

    @PrimaryKey(autoGenerate = true)
    private int id;
    private String color;

    public ColorEntity(int id, String color) {
        this.id = id;
        this.color = color;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
