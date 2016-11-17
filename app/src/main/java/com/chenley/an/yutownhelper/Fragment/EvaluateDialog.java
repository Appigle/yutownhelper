package com.chenley.an.yutownhelper.fragment;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;

/**
 * Author:    Chenley
 * Version    V2.0
 * Date:      2016/8/11
 * Description:
 * Modification    History:
 * Date         	Author        		Version        	Description
 * ------------------------------------------------------------------
 * 2016/8/11         Chenley             2.0                2.0
 * Why & What is modified:
 */
public class EvaluateDialog extends DialogFragment {
    private static final String TAG = "EvaluateDialog==";
    private String[] mEvaluteVals = new String[] { "GOOD", "BAD", "NORMAL" };
    public static final String RESPONSE_EVALUATE = "response_evaluate";
    public static EvaluateDialog newInstance() {
        Bundle args = new Bundle();
        EvaluateDialog fragment = new EvaluateDialog();
        fragment.setArguments(args);
        return fragment;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
       
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        builder.setTitle("Evaluate :").setItems(mEvaluteVals,
                new DialogInterface.OnClickListener()
                {
                    @Override
                    public void onClick(DialogInterface dialog, int which)
                    {
                        setResult(which);
                    }
                });
        return builder.create();
    }
    // 设置返回数据  
    protected void setResult(int which)
    {
        // 判断是否设置了targetFragment  
        if (getTargetFragment() == null)
            return;

        Intent intent = new Intent();
        intent.putExtra(RESPONSE_EVALUATE, mEvaluteVals[which]);
        getTargetFragment().onActivityResult(DialogFragmentShow.REQUEST_EVALUATE,
                Activity.RESULT_OK, intent);
    }
}