package com.example.navdrawer;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import com.bumptech.glide.Glide;
import com.example.navdrawer.fragments.Makanan_Fav_Fragment;
import com.example.navdrawer.fragments.Makanan_Fragment;
import com.example.navdrawer.fragments.Minuman_Fragment;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {

    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle toggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        String fragmentName = getIntent().getStringExtra("fragmentBack");
        Fragment fragmentBack = null;

        showHomePage();

        if ("makananFragment".equals(fragmentName)) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.content_frame, new Makanan_Fragment())
                    .commit();
            getSupportActionBar().setTitle("Makanan Page");
        } else if ("minumanFragment".equals(fragmentName)) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.content_frame, new Minuman_Fragment())
                    .commit();
            getSupportActionBar().setTitle("Minuman Page");
        } else if ("makananFavFragment".equals(fragmentBack)) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.content_frame, new Makanan_Fav_Fragment())
                    .commit();
            getSupportActionBar().setTitle("Makanan Fav Page");
        } else {
            showHomePage();
        }

        drawerLayout = findViewById(R.id.drawer_layout);
        toggle = new ActionBarDrawerToggle(
                this, drawerLayout, toolbar, R.string.open_drawer, R.string.close_drawer);

        drawerLayout.addDrawerListener(toggle);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int itemId = item.getItemId();

                if (itemId == R.id.menu_makanan) {
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.content_frame, new Makanan_Fragment())
                            .commit();
                    getSupportActionBar().setTitle("Minuman Page");
                }
                else if (itemId == R.id.menu_minuman) {
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.content_frame, new Minuman_Fragment())
                            .commit();
                    getSupportActionBar().setTitle("Minuman Page");
                } else {
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.content_frame, new Makanan_Fav_Fragment())
                            .commit();
                    getSupportActionBar().setTitle("MakananFav Page");
                }

                drawerLayout.closeDrawers();
                return true;
            }
        });

        ImageView imageView = navigationView.getHeaderView(0).findViewById(R.id.imageViewProfile);

        String imageUrl = "https://i.pinimg.com/736x/ea/5c/5c/ea5c5cec244c144c1b2e9de01866907f.jpg";
        Glide.with(this)
                .load(imageUrl)
                .into(imageView);

    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        toggle.syncState();
    }

    private void showHomePage() {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.content_frame, new Makanan_Fragment())
                .commit();

        getSupportActionBar().setTitle("Makanan Page");
    }
}