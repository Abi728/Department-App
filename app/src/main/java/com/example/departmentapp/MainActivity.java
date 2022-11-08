package com.example.departmentapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;
    ActionBarDrawerToggle actionBarDrawerToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.navigationView);

        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.open_menu, R.string.close_menu);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        NavigationView navigationView = findViewById(R.id.navigationView);
        navigationView.setNavigationItemSelectedListener(this);

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.drawer_layout,
                    new DirectoryFragment()).commit();
            navigationView.setCheckedItem(R.id.nav_directory);
        }
    }

    @Override
    Public

    boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {

            case R.id.nav_directory:
                getSupportFragmentManager().beginTransaction().replace(R.id.drawer_layout,
                        new DirectoryFragment()).commit();
                break;

            case R.id.nav_courses:
                getSupportFragmentManager().beginTransaction().replace(R.id.drawer_layout,
                        new CoursesFragment()).commit();
                break;

            case R.id.nav_timetable:
                getSupportFragmentManager().beginTransaction().replace(R.id.drawer_layout,
                        new TimetableFragment()).commit();
                break;

            case R.id.nav_admission:
                getSupportFragmentManager().beginTransaction().replace(R.id.drawer_layout,
                        new AdmissionFragment()).commit();
                break;

            case R.id.nav_twitter:
                getSupportFragmentManager().beginTransaction().replace(R.id.drawer_layout,
                        new TwitterFragment()).commit();
                break;

            case R.id.nav_instagram:
                getSupportFragmentManager().beginTransaction().replace(R.id.drawer_layout,
                        new InstagramFragment()).commit();
                break;

            case R.id.nav_email:
                getSupportFragmentManager().beginTransaction().replace(R.id.drawer_layout,
                        new EmailFragment()).commit();
                break;

            case R.id.nav_logout:
                Toast.makeText(this, "Logged Out", Toast.LENGTH_SHORT).show();
                break;


        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }


    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
}