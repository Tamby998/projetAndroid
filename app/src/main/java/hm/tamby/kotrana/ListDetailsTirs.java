package hm.tamby.kotrana;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
/**
 * Details
 */
public class ListDetailsTirs extends AppCompatActivity {

    RecyclerView recyclerView;
    DatabaseReference database;
    MyAdapter myAdapter;
    ArrayList<Details> details;
    /**
     * Recuperation donnees dans Firebase Realtime
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_details_tirs);

        recyclerView = findViewById(R.id.list_detail);
        database = FirebaseDatabase.getInstance().getReference("Echauffement");
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        details = new ArrayList<>();
        myAdapter = new MyAdapter(this, details);
        recyclerView.setAdapter(myAdapter);

        database.addValueEventListener(new ValueEventListener() {
            /**
             * Recuperation des donnees
             * @param snapshot
             */
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot dataSnapshot : snapshot.getChildren()){
                    Details details1 = dataSnapshot.getValue(Details.class);
                    details.add(details1);
                }
                myAdapter.notifyDataSetChanged();
            }

            /**
             * Error
             * @param error
             */
            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}