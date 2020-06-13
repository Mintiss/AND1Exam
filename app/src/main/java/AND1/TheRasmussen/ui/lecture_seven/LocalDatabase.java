package AND1.TheRasmussen.ui.lecture_seven;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {ColorEntity.class}, version = 1)
public abstract class LocalDatabase extends RoomDatabase {


    private static LocalDatabase instance;
    public abstract ColorDao colorDao();

    public static synchronized  LocalDatabase getInstance(Context context)
    {
        if(instance == null)
        {
            instance = Room.databaseBuilder(context.getApplicationContext(),
                    LocalDatabase.class,"local_database")
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return instance;
    }
}
