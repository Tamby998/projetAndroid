package hm.tamby.kotrana.ui.slideshow;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.google.firebase.auth.FirebaseAuth;

import hm.tamby.kotrana.HomePage;
import hm.tamby.kotrana.Login;
import hm.tamby.kotrana.R;
import hm.tamby.kotrana.Registration;
import hm.tamby.kotrana.Webview;
import hm.tamby.kotrana.databinding.FragmentSlideshowBinding;

public class SlideshowFragment extends Fragment {

    private SlideshowViewModel slideshowViewModel;
    private FragmentSlideshowBinding binding;

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_slideshow, container, false);

        initUI(v);

        return v;
        }
    private void initUI(View v){
        Button button1 =(Button)v.findViewById(R.id.btnActiverRecherche);
        button1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                //tu fais ce que tu veux dans le onClick
                Intent intent = new Intent(getActivity().getApplicationContext(), Webview.class) ;
                startActivity(intent) ;
            }
        });
    }

}

