package com.chenley.an.yutownhelper.Fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.chenley.an.yutownhelper.R;


public class FragmentThree extends Fragment {


    public interface FTwoBtnClickListener {
        void onTwoBtnClick();
    }
    public static FragmentThree newInstance() {
        return new FragmentThree();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_fragment_three, container, false);
        return view;
    }

}
