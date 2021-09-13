package hm.tamby.kotrana.vue;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import hm.tamby.kotrana.R;

public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login2);

        ImageView imageView = findViewById(R.id.ivFacebook) ;
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Registration.class) ;
                startActivity(intent) ;
//                Toast.makeText(getApplicationContext(), "Click" , Toast.LENGTH_SHORT).show() ;
            }
        });

    }

}