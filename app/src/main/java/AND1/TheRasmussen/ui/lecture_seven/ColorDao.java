package AND1.TheRasmussen.ui.lecture_seven;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;
@Dao
public interface ColorDao {

    @Insert
    void insert(ColorEntity color);

    @Query("SELECT * FROM color_table ORDER BY id DESC")
    LiveData<List<ColorEntity>> getPreviousColorList();

    @Query("DELETE FROM color_table")
    void deleteAllNotes();
}
