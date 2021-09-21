package hm.tamby.kotrana.ui.home;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

/**
 * HomeViewModel
 */
public class HomeViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    /**
     * Model
     */
    public HomeViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is home fragment");
    }

    /**
     *
     * @return
     */
    public LiveData<String> getText() {
        return mText;
    }
}