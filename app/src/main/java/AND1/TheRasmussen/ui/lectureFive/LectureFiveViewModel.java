package AND1.TheRasmussen.ui.lectureFive;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class LectureFiveViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public LectureFiveViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is lec 5 fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}