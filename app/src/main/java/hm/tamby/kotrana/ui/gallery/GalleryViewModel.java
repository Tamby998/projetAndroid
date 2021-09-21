package hm.tamby.kotrana.ui.gallery;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

/**
 * Model
 */
public class GalleryViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    /**
     * Fragment
     */
    public GalleryViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is gallery fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}