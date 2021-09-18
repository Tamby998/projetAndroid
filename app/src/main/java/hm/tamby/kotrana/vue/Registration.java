package hm.tamby.kotrana.vue;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import hm.tamby.kotrana.R;
import hm.tamby.kotrana.modele.ConnexionDB;
import hm.tamby.kotrana.modele.Inscription;

public class Registration extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        final EditText txtUsername =  findViewById(R.id.txtUsername);
        final EditText txtEmail = findViewById(R.id.txtEmail);
        final EditText txtMdp =  findViewById(R.id.txtMdp);
        Button btnSignup = findViewById(R.id.btnSignUp);
        ConnexionDB connexionDB = new ConnexionDB();
        btnSignup.setOnClickListener(v->{
            Inscription inscription = new Inscription(txtUsername.getText().toString(),txtEmail.getText().toString(),txtMdp.getText().toString());
            connexionDB.add(inscription).addOnSuccessListener(suc-> Toast.makeText(this,"Inscription effectué avec succès",Toast.LENGTH_SHORT).show()).addOnFailureListener(err-> Toast.makeText(this,"" + err.getMessage(),Toast.LENGTH_SHORT).show());
         });
    }

}