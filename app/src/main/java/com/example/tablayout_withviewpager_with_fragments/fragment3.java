package com.example.tablayout_withviewpager_with_fragments;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class fragment3 extends Fragment {
    ViewPager viewPager;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_fragment3, container, false);

        viewPager = view.findViewById(R.id.viewpager1);
        int image[] = {R.drawable.officialravindra,R.drawable.russel,R.drawable.smith,R.drawable.starc,R.drawable.tahir,R.drawable.officialravindra,R.drawable.yuz,R.drawable.ic_launcher_background,R.drawable.ic_launcher_foreground,R.drawable.ic_launcher_background};

        String[] ary = {"RAVINDRA","SAMEER","SHEKHAR","AJAY","NITESH","YASH","SAURABH","SHYAAMAL","VIRAT","DHONI"};


        viewPager.setAdapter(new pager_adapter(getContext(),image,ary));
        return  view;
    }
}