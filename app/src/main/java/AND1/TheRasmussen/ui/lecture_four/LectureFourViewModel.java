package AND1.TheRasmussen.ui.lecture_four;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class LectureFourViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public LectureFourViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is lec 4 fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}