package com.chenley.an.yutownhelper.Fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.chenley.an.yutownhelper.R;


public class FragmentTwo extends Fragment implements View.OnClickListener {
    private Button mBtn;
    private FTwoBtnClickListener fTwoBtnClickListener;

    public static FragmentTwo newInstance() {
        return new FragmentTwo();
    }

    public interface FTwoBtnClickListener {
        void onTwoBtnClick();
    }

    public void setFTwoBtnClickListener(FTwoBtnClickListener fTwoBtnClickListener) {
        this.fTwoBtnClickListener = fTwoBtnClickListener;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_fragment_two, container, false);
        mBtn = (Button) view.findViewById(R.id.id_fragment_two_btn);
        mBtn.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View v) {
        if (fTwoBtnClickListener != null) {
            fTwoBtnClickListener.onTwoBtnClick();
        }
    }
}
