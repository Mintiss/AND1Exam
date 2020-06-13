package AND1.TheRasmussen.ui.lecture_eight;

import androidx.lifecycle.ViewModel;

public class LectureEightViewModel extends ViewModel {

    private LectureEightRepository repository;

    public String getDadJoke() {
       return repository.getDadJoke();
    }
}
