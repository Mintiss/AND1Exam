package AND1.TheRasmussen.ui.lecture_seven;

import android.app.Application;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteConstraintException;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import java.util.List;
import java.util.concurrent.ExecutionException;

import static android.content.Context.MODE_PRIVATE;

public class LectureSevenRepository {

    private static LectureSevenRepository instance;
    private SharedPreferences prefs;
    private ColorDao colorDao;


    public LectureSevenRepository(Application application) {
        LocalDatabase database = LocalDatabase.getInstance(application);
        colorDao = database.colorDao();
        prefs = application.getSharedPreferences("MyPreferences", MODE_PRIVATE);

    }

    public static LectureSevenRepository getInstance(Application application) {
        if (instance == null) {
            instance = new LectureSevenRepository(application);
        }
        return instance;
    }

    public void storeColor(String color) {
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString("color", color);
        editor.apply();
    }

    public boolean containsColor() {
        if (prefs.contains("color"))
            return true;
        else return false;
    }

    public String getColor() {
        return prefs.getString("color", "blank");
    }

    public LiveData<List<ColorEntity>> getPreviousColorList() {

        try {
            return new getColorsAsync(colorDao).execute().get();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void storeColorInLocalDB(String color) {
        new InsertColorEntityAsync(colorDao).execute(new ColorEntity(0,color));

    }

    public void clearList() {
        new ClearListAsync(colorDao).execute();
    }

    private static class getColorsAsync extends AsyncTask<Void,Void, LiveData<List<ColorEntity>>>
    {
        private ColorDao colorDao;

        private getColorsAsync(ColorDao colorDao){
            this.colorDao=colorDao;
        }

        @Override
        protected LiveData<List<ColorEntity>> doInBackground(Void... voids) {
            return colorDao.getPreviousColorList();
        }
    }

    private static class InsertColorEntityAsync extends AsyncTask<ColorEntity,Void,Void>
    {
        private ColorDao colorDao;

        private InsertColorEntityAsync(ColorDao colorDao){
            this.colorDao=colorDao;
        }

        @Override
        protected Void doInBackground(ColorEntity... colorEntities) {
            try {
                colorDao.insert(colorEntities[0]);
            } catch (SQLiteConstraintException e)
            {
                return null;
            }
            return null;
        }
    }

    private static class ClearListAsync extends AsyncTask<Void,Void,Void>
    {
        private ColorDao colorDao;

        private ClearListAsync(ColorDao colorDao){
            this.colorDao=colorDao;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            colorDao.deleteAllNotes();
            return null;
        }
    }
}
