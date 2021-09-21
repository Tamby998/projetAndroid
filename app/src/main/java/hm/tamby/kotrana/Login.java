package hm.tamby.kotrana;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;


/**
 * Login
 */
public class Login extends AppCompatActivity {
    private EditText atvEmailLog, atvPasswordLog;
    FirebaseAuth auth;

    /**
     * Creation Activity Login
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login2);

        Button btnSignUn = findViewById(R.id.btnSignUn) ;
        btnSignUn.setOnClickListener(new View.OnClickListener() {
            /**
             * Evenement pour e button SignUp
             * @param view
             */
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Registration.class) ;
                startActivity(intent) ;
//                Toast.makeText(getApplicationContext(), "Click" , Toast.LENGTH_SHORT).show() ;
            }
        });

        atvEmailLog=findViewById(R.id.atvEmailLog);
        atvPasswordLog=findViewById(R.id.atvPasswordLog);
        Button btnSignIn = findViewById(R.id.btnSignIn);
        auth=FirebaseAuth.getInstance();
        btnSignIn.setOnClickListener(v -> {
            String email= atvEmailLog.getText().toString().trim();
            String password=atvPasswordLog.getText().toString().trim();
            if(email.isEmpty())
            {
                atvEmailLog.setError("Email is empty");
                atvEmailLog.requestFocus();
                return;
            }
            if(!Patterns.EMAIL_ADDRESS.matcher(email).matches())
            {
                atvEmailLog.setError("Enter the valid email");
                atvEmailLog.requestFocus();
                return;
            }
            if(password.isEmpty())
            {
                atvPasswordLog.setError("Password is empty");
                atvPasswordLog.requestFocus();
                return;
            }
            if(password.length()<6)
            {
                atvPasswordLog.setError("Length of password is more than 6");
                atvPasswordLog.requestFocus();
                return;
            }
            auth.signInWithEmailAndPassword(email,password).addOnCompleteListener(task -> {
                if(task.isSuccessful())
                {
                    startActivity(new Intent(Login.this, HomePage.class));
                }
                else
                {
                    Toast.makeText(Login.this,
                            "Please Check Your login Credentials",
                            Toast.LENGTH_SHORT).show();
                }
            });
        });
        //btnSignIn.setOnClickListener(v -> startActivity(new Intent(Login.this,Registration.class )));
    }
}