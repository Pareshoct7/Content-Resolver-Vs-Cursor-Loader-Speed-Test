package com.example.sense.mobilecontactslibrary;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import com.example.sense.mobilecontactslibrary.ContactList.ListFragment.ContactListFragment;
import com.example.sense.mobilecontactslibrary.Utilities.C;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private static final int READ_CONTACT_PERMISSION_REQUEST_CODE = 76;
    private ViewPager viewPager;
    private TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        viewPager = (ViewPager) findViewById(R.id.viewPager);
        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        checkPermission();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {

    }

    private void launchViewPager() {
        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());

        viewPagerAdapter.addTab(C.CURSOR_CONTENT_RESOLVER, ContactListFragment.newInstance(C.CURSOR_CONTENT_RESOLVER));
        viewPagerAdapter.addTab(C.CURSOR_LOADER, ContactListFragment.newInstance(C.CURSOR_LOADER));
        viewPager.setAdapter(viewPagerAdapter);
        tabLayout.setupWithViewPager(viewPager);
    }

    private void checkPermission() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_CONTACTS) == PackageManager.PERMISSION_GRANTED) {
            launchViewPager();
        } else {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                requestPermissions(new String[]{Manifest.permission.READ_CONTACTS}, READ_CONTACT_PERMISSION_REQUEST_CODE);
            }
        }
    }

    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        if (requestCode == READ_CONTACT_PERMISSION_REQUEST_CODE && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            launchViewPager();
        }
    }

    public class ViewPagerAdapter extends FragmentPagerAdapter {

        private final ArrayList<FragModel> fragmentList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return fragmentList.get(position).fragment;
        }

        @Override
        public int getCount() {
            return fragmentList.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return fragmentList.get(position).title;
        }

        public void addTab(String title, Fragment fragment) {
            fragmentList.add(new FragModel(title, fragment));
        }

        class FragModel {
            Fragment fragment;
            String title;

            public FragModel(String title, Fragment fragment) {
                this.fragment = fragment;
                this.title = title;
            }
        }
    }
}
