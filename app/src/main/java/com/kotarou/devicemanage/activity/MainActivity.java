package com.kotarou.devicemanage.activity;


import android.os.Bundle;


import androidx.fragment.app.FragmentTransaction;

import com.kotarou.devicemanage.R;
import com.kotarou.devicemanage.fragment.NavigationFragment;

public class MainActivity extends BaseActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        NavigationFragment navigationFragment = new NavigationFragment();
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.add(R.id.main_frame, navigationFragment).commit();
    }
}