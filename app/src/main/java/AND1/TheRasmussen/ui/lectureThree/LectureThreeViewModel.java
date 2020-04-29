package AND1.TheRasmussen.ui.lectureThree;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class LectureThreeViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public LectureThreeViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is lec 3 fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}