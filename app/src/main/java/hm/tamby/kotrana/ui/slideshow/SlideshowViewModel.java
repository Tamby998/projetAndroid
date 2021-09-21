package hm.tamby.kotrana.ui.slideshow;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

/**
 * Slides
 */
public class SlideshowViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    /**
     * Model
     */
    public SlideshowViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is slideshow fragment");
    }

    /**
     * @return
     */
    public LiveData<String> getText() {
        return mText;
    }
}