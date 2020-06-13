package AND1.TheRasmussen.ui.lecture_seven;

import android.app.Application;
import android.content.SharedPreferences;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

public class LectureSevenViewModel extends AndroidViewModel {

    private LectureSevenRepository repository;

    public LectureSevenViewModel(Application application) {
        super(application);
        repository = LectureSevenRepository.getInstance(application);

    }

    public void storeColor(String color){
        repository.storeColor(color);
    }

    public boolean preferencesContainColor() {
        return repository.containsColor();
    }

    public String getColor() {
        return repository.getColor();
    }

    public void storeColorInLocalDB(String color) {
        repository.storeColorInLocalDB(color);
    }

    public LiveData<List<ColorEntity>> getPreviousColorList() {
        return repository.getPreviousColorList();
    }

    public void clearList() {
        repository.clearList();
    }
}
