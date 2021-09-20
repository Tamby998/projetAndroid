package hm.tamby.kotrana;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.navigation.NavigationView;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;

import hm.tamby.kotrana.R;
import hm.tamby.kotrana.databinding.ActivityHomePageBinding;

public class HomePage extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;
    private ActivityHomePageBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityHomePageBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.appBarHomePage.toolbar);
        /**binding.appBarAccueil.fab.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
        Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
        .setAction("Action", null).show();
        }
        });*/

        TextView card_view_image_title = findViewById(R.id.card_view_image_title) ;
        card_view_image_title.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), ListDetails.class) ;
                startActivity(intent) ;
//                Toast.makeText(getApplicationContext(), "Click" , Toast.LENGTH_SHORT).show() ;
            }
        });

        TextView card_view_image_title1 = findViewById(R.id.card_view_image_title1) ;
        card_view_image_title1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), ListDetailsJeuDePass.class) ;
                startActivity(intent) ;
//                Toast.makeText(getApplicationContext(), "Click" , Toast.LENGTH_SHORT).show() ;
            }
        });

        TextView card_view_image_title2 = findViewById(R.id.card_view_image_title2) ;
        card_view_image_title2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), ListDetailsTirs.class) ;
                startActivity(intent) ;
//                Toast.makeText(getApplicationContext(), "Click" , Toast.LENGTH_SHORT).show() ;
            }
        });

        TextView card_view_image_title3 = findViewById(R.id.card_view_image_title3) ;
        card_view_image_title3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), ListDetailsDrible.class) ;
                startActivity(intent) ;
//                Toast.makeText(getApplicationContext(), "Click" , Toast.LENGTH_SHORT).show() ;
            }
        });


        DrawerLayout drawer = binding.drawerLayout;
        NavigationView navigationView = binding.navView;
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow)
                .setOpenableLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_home_page);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.home_page, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_home_page);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }
}