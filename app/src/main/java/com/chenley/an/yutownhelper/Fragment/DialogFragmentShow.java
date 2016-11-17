package com.chenley.an.yutownhelper.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.chenley.an.yutownhelper.R;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

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
public class DialogFragmentShow extends DialogFragment {

    @Bind(R.id.id_label_your_name)
    TextView idLabelYourName;
    @Bind(R.id.id_txt_your_name)
    EditText idTxtYourName;
    @Bind(R.id.id_sure_edit_name)
    Button idSureEditName;
    @Bind(R.id.radioButton2)
    RadioButton radioButton2;
    @Bind(R.id.checkBox)
    CheckBox checkBox;

    public DialogFragmentShow() {
    }

    public static DialogFragmentShow newInstance() {
        return new DialogFragmentShow();
    }
    private OnNameCompletedListener mListener;

    public OnNameCompletedListener getmListener() {
        return mListener;
    }

    public void setOnNameCompletedListener(OnNameCompletedListener mListener) {
        this.mListener = mListener;
    }

    public interface OnNameCompletedListener{
        void onNameCompleted(String name);
    }

    @Override
    public void onDetach() {
        super.onDetach();
        if (mListener != null) {
            mListener = null;
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        getDialog().requestWindowFeature(Window.FEATURE_NO_TITLE);
        View view = inflater.inflate(R.layout.fragment_dialog, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
    private String mArgument;
    public static final String ARGUMENT = "argument";
    public static final String RESPONSE = "response";
    public static final String EVALUATE_DIALOG = "evaluate_dialog";
    public static final int REQUEST_EVALUATE = 0X110;
    @OnClick({R.id.id_label_your_name, R.id.id_txt_your_name, R.id.id_sure_edit_name, R.id.radioButton2, R.id.checkBox})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.id_label_your_name:
                break;
            case R.id.id_txt_your_name:
                break;
            case R.id.id_sure_edit_name:
                break;
            case R.id.radioButton2:

               /* String name = idTxtYourName.getText().toString();
                if (!TextUtils.isEmpty(name)) {
                    if (mListener != null) {
                        mListener.onNameCompleted(name);
                    }
                }
                this.dismiss();*/

                EvaluateDialog dialog = EvaluateDialog.newInstance();
                dialog.setTargetFragment(DialogFragmentShow.this, REQUEST_EVALUATE);
                dialog.show(getActivity().getSupportFragmentManager(),DialogFragmentShow.class.getName());
                break;
            case R.id.checkBox:
                break;
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == DialogFragmentShow.REQUEST_EVALUATE) {
            String result = data.getStringExtra(EvaluateDialog.RESPONSE_EVALUATE);
            Toast.makeText(getActivity(), "result= " + result, Toast.LENGTH_SHORT).show();
            /*Intent intent = new Intent();
            intent.putExtra(DialogFragmentShow.RESPONSE, result);
            getActivity().setResult(Activity.RESULT_OK,intent);*/
        }
    }
}