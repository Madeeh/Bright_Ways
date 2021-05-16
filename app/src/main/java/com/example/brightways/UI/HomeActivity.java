package com.example.brightways.UI;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.brightways.R;
import com.example.brightways.UI.Fragments.HomeFragment;
import com.example.brightways.UI.Fragments.OrderFragment;
import com.example.brightways.UI.Fragments.PhoneFragment;
import com.example.brightways.UI.Fragments.ProfileFragment;
import com.example.brightways.UI.Fragments.RateFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import io.paperdb.Paper;

public class HomeActivity extends AppCompatActivity {
    FirebaseAuth auth;
    DatabaseReference ProductsRef;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        auth = FirebaseAuth.getInstance();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        ProductsRef = FirebaseDatabase.getInstance().getReference().child("Products");


        Paper.init(this);


        BottomNavigationView bottomNav = findViewById(R.id.bottomMenu);
        bottomNav.setOnNavigationItemSelectedListener(navListener);

        //I added this if statement to keep the selected fragment when rotating the device
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                    new HomeFragment()).commit();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.navigation_drawer, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.setting:
                Toast.makeText(this, "Setting Click", Toast.LENGTH_SHORT).show();

                break;
            case R.id.logout:
                auth.signOut();
                Intent intent = new Intent(HomeActivity.this, LoginActivity.class);
                startActivity(intent);
                break;
        }
        return true;
    }

    private final BottomNavigationView.OnNavigationItemSelectedListener navListener =
            item -> {
                Fragment selectedFragment = null;
                switch (item.getItemId()) {
                    case R.id.menu_home:
                        selectedFragment = new HomeFragment();
                        break;
                    case R.id.menu_Profile:
                        selectedFragment = new ProfileFragment();
                        break;
                    case R.id.menu_rate:
                        selectedFragment = new RateFragment();
                        break;
                    case R.id.menu_order:
                        selectedFragment = new OrderFragment();
                        break;
                    case R.id.menu_phone:
                        selectedFragment = new PhoneFragment();
                        break;
                }
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        selectedFragment).commit();
                return true;
            };
}