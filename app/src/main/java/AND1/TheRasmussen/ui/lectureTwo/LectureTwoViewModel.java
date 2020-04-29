package AND1.TheRasmussen.ui.lectureTwo;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class LectureTwoViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public LectureTwoViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is lec 2 fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}