package hm.tamby.kotrana.modele;

import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ConnexionDB {
    private DatabaseReference databaseReference;

    public ConnexionDB() {
        FirebaseDatabase db = FirebaseDatabase.getInstance();
        databaseReference = db.getReference(Inscription.class.getSimpleName());
    }
    public Task<Void> add(Inscription inscription){
        return databaseReference.push().setValue(inscription);
    }
}
