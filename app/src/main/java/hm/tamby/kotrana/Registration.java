package hm.tamby.kotrana;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

/**
 * Registration
 */
public class Registration extends AppCompatActivity {
    private FirebaseAuth auth;
    private EditText atvUsernameReg, atvEmailReg, atvPasswordReg;
    private Button btnSignUp;
    private ProgressBar progressbar;

    /**
     * Creation Activity Registration
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        // taking FirebaseAuth instance
        auth = FirebaseAuth.getInstance();

        // initialising all views through id defined above
        atvUsernameReg = findViewById(R.id.atvUsernameReg);
        atvEmailReg = findViewById(R.id.atvEmailReg);
        atvPasswordReg = findViewById(R.id.atvPasswordReg);
        btnSignUp = findViewById(R.id.btnSignUp);
        progressbar = findViewById(R.id.progressbar);

        // Set on Click Listener on Registration button
        btnSignUp.setOnClickListener(new View.OnClickListener() {
            /**
             * @param v
             */
            @Override
            public void onClick(View v)
            {
                registerNewUser();
            }
        });
    }

    /**
     * Enregistrement nouveau user
     */
    private void registerNewUser()
    {

        // show the visibility of progress bar to show loading
        progressbar.setVisibility(View.VISIBLE);

        // Take the value of two edit texts in Strings
        String username, email, password;
        username = atvUsernameReg.getText().toString();
        email = atvEmailReg.getText().toString();
        password = atvPasswordReg.getText().toString();

        // Validations for input username and email and password
        if (TextUtils.isEmpty(username)) {
            Toast.makeText(getApplicationContext(),
                    "Please enter username!!",
                    Toast.LENGTH_LONG)
                    .show();
            return;
        }
        if (TextUtils.isEmpty(email)) {
            Toast.makeText(getApplicationContext(),
                    "Please enter email!!",
                    Toast.LENGTH_LONG)
                    .show();
            return;
        }
        if (TextUtils.isEmpty(password)) {
            Toast.makeText(getApplicationContext(),
                    "Please enter password!!",
                    Toast.LENGTH_LONG)
                    .show();
            return;
        }

        auth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            /**
             * @param task
             */
            @Override
                    public void onComplete(@NonNull Task<AuthResult> task)
                    {
                        if (task.isSuccessful()) {
                            Toast.makeText(getApplicationContext(),
                                    "Registration successful!",
                                    Toast.LENGTH_LONG)
                                    .show();

                            // hide the progress bar
                            progressbar.setVisibility(View.GONE);

                            // if the user created intent to login activity
                            Intent intent
                                    = new Intent(Registration.this,
                                    Login.class);
                            startActivity(intent);
                        } else {
                            // Registration failed
                            Toast.makeText(
                                    getApplicationContext(),
                                    "Registration failed!!"
                                            + " Please try again later",
                                    Toast.LENGTH_LONG)
                                    .show();

                            // hide the progress bar
                            progressbar.setVisibility(View.GONE);
                        }
                    }
        });
    }
}