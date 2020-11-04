package com.example.finalexam;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class MyFragmentAdapter extends FragmentPagerAdapter {
    List<String>list;
    List<Fragment>list2;
    public MyFragmentAdapter(@NonNull FragmentManager fm, List<String>list,List<Fragment>list2) {
        super(fm);
        this.list=list;
        this.list2=list2;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return list2.get(position);
    }

    @Override
    public int getCount() {
        return list.size();
    }
    public CharSequence getPageTitle(int position) {
        return list.get(position);
    }
}
