package com.example.tablayout_withviewpager_with_fragments;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    TabLayout tabLayout;
    ViewPager viewPager;
    NavigationView navigationView;
    FloatingActionButton floatingActionButton;
    DrawerLayout drawerLayout;

    ActionBarDrawerToggle toggle;
    androidx.appcompat.widget.Toolbar toolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.drawer_main);
        viewPager = findViewById(R.id.viewpager);
        tabLayout = findViewById(R.id.tablayout);
        floatingActionButton = findViewById(R.id.floating_btn);
        floatingActionButton.setBackgroundResource(R.drawable.ic_baseline_call_24);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewPager.setCurrentItem(2);
                Toast.makeText(MainActivity.this, "This is Floating Action Button", Toast.LENGTH_SHORT).show();
            }
        });

        drawerLayout = findViewById(R.id.drawerlayout);
        navigationView = findViewById(R.id.navigationView1);
        toolbar = findViewById(R.id.Toolbar);

        setSupportActionBar(toolbar);


        navigationView.setNavigationItemSelectedListener(this);




        toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.Start, R.string.close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        toggle.getDrawerArrowDrawable().setColor(getResources().getColor(R.color.white));

        tabLayout.setupWithViewPager(viewPager);
        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(viewPagerAdapter);
        /*viewPager.setPagingEnabled(true);*/

        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }


    public class ViewPagerAdapter extends FragmentStatePagerAdapter {
        public ViewPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int i) {
            switch (i) {
                case 0:
                    return new fragment1();

                case 1:

                    return new fragment2();

                case 2:
                    return new fragment3();

                default:
                    return new fragment1();
            }
        }

        @Override
        public int getCount() {
            return 3;
        }


        @Nullable
        @Override
        public CharSequence getPageTitle(int i) {
            switch (i) {
                case 0:
                    return "LOGIN";

                case 1:
                    return "PROFILE";


                case 2:
                    return "FRIENDS";

                default:
                    return "LOGIN";
            }


        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.nav_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.Home: {
                Toast.makeText(MainActivity.this, "Home Pressed", Toast.LENGTH_SHORT).show();
                drawerLayout.closeDrawer(GravityCompat.START);
                break;
            }
            case R.id.call: {
                Toast.makeText(MainActivity.this, "Call Pressed", Toast.LENGTH_SHORT).show();
                drawerLayout.closeDrawer(GravityCompat.START);
                break;
            }
            case R.id.setting: {
                Toast.makeText(MainActivity.this, "Settigs Pressed", Toast.LENGTH_SHORT).show();
                drawerLayout.closeDrawer(GravityCompat.START);
                break;
            }
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawerlayout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        Log.d("TAG", "onNavigationItemSelected: " + item.getItemId());
        switch (item.getItemId()) {
            case R.id.Home: {
                Toast.makeText(getApplicationContext(), "Home Pressed", Toast.LENGTH_SHORT).show();
                drawerLayout.closeDrawer(GravityCompat.START);
                break;
            }
            case R.id.call: {
                Toast.makeText(getApplicationContext(), "Call Pressed", Toast.LENGTH_SHORT).show();
                drawerLayout.closeDrawer(GravityCompat.START);
                break;
            }
            case R.id.setting: {
                Toast.makeText(getApplicationContext(), "Settigs Pressed", Toast.LENGTH_SHORT).show();
                drawerLayout.closeDrawer(GravityCompat.START);
                break;
            }

            default:
                drawerLayout.closeDrawer(GravityCompat.START);
                Toast.makeText(this, "hiii", Toast.LENGTH_SHORT).show();


        }
        return true;
    }

}