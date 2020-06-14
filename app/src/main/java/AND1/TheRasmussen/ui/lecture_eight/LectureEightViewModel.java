package AND1.TheRasmussen.ui.lecture_eight;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import AND1.TheRasmussen.ui.lecture_seven.LectureSevenRepository;

public class LectureEightViewModel extends AndroidViewModel {

    private LectureEightRepository repository;

    public LectureEightViewModel(@NonNull Application application) {
        super(application);
        repository = LectureEightRepository.getInstance(application);

    }

    public MutableLiveData<String> getDadJoke() {
        return repository.getDadJoke();
    }

    public void updateDadJoke() {
        repository.updateDadJoke();
    }
}
