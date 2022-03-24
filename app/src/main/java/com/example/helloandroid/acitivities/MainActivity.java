package com.example.helloandroid.acitivities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.helloandroid.R;
import com.example.helloandroid.fragments.AutonomousFragment;
import com.example.helloandroid.fragments.ClosedCoursesFragment;
import com.example.helloandroid.fragments.ClosedInstitutesFragment;
import com.example.helloandroid.fragments.DashboardFragment;
import com.example.helloandroid.fragments.FacultiesFragment;
import com.example.helloandroid.fragments.GraphsChartsFragment;
import com.example.helloandroid.fragments.NBAFragment;
import com.example.helloandroid.fragments.OtherApprovalsFragment;
import com.example.helloandroid.fragments.UnapprovedFragment;
import com.example.helloandroid.fragments.UniversitiesFragment;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Toolbar toolbar= findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawerLayout= findViewById(R.id.drawer_layout);

        NavigationView navigationView= findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        ActionBarDrawerToggle toggle= new ActionBarDrawerToggle(this, drawerLayout, toolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        if(savedInstanceState==null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container, new DashboardFragment())
                    .addToBackStack(null).commit();
            navigationView.setCheckedItem(R.id.nav_dashboard);
        }

    }

    @Override
    public void onBackPressed() {
        if(drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()){
            case R.id.nav_dashboard:
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container, new DashboardFragment())
                        .addToBackStack(null).commit();
                break;
            case R.id.nav_universities:
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container, new UniversitiesFragment())
                        .addToBackStack(null).commit();
                break;
            case R.id.nav_otherApprovals:
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container, new OtherApprovalsFragment())
                        .addToBackStack(null).commit();
                break;
            case R.id.nav_nba:
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container, new NBAFragment())
                        .addToBackStack(null).commit();
                break;
            case R.id.nav_autonomous:
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container, new AutonomousFragment())
                        .addToBackStack(null).commit();
                break;
            case R.id.nav_faculties:
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container, new FacultiesFragment())
                        .addToBackStack(null).commit();
                break;
            case R.id.nav_graphCharts:
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container, new GraphsChartsFragment())
                        .addToBackStack(null).commit();
                break;
            case R.id.nav_closedCourses:
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container, new ClosedCoursesFragment())
                        .addToBackStack(null).commit();
                break;
            case R.id.nav_closedInstitutes:
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container, new ClosedInstitutesFragment())
                        .addToBackStack(null).commit();
                break;
            case R.id.nav_unapproved:
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container, new UnapprovedFragment())
                        .addToBackStack(null).commit();
                break;
        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }
}