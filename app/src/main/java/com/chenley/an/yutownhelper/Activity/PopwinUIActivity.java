package com.chenley.an.yutownhelper.Activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.chenley.an.yutownhelper.R;
import com.chenley.an.yutownhelper.utils.ToastHelper;
import com.chenley.an.yutownhelper.utils.ViewHelper;
import com.makeramen.roundedimageview.RoundedImageView;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class PopwinUIActivity extends AppCompatActivity {

    @Bind(R.id.btn_empty_hongbao)
    Button btnEmptyHongbao;
    @Bind(R.id.btn_opent_hongbao)
    Button btnOpentHongbao;
    @Bind(R.id.button13)
    Button button13;
    @Bind(R.id.button14)
    Button button14;
    @Bind(R.id.button15)
    Button button15;
    @Bind(R.id.button16)
    Button button16;
    @Bind(R.id.button17)
    Button button17;
    @Bind(R.id.button18)
    Button button18;
    @Bind(R.id.button19)
    Button button19;
    @Bind(R.id.button20)
    Button button20;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_popwin_ui);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.btn_empty_hongbao, R.id.btn_opent_hongbao,R.id.button13, R.id.button14, R.id.button15, R.id.button16, R.id.button17, R.id.button18})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_empty_hongbao:
                showHongbaoPopWin(true);
                break;
            case R.id.btn_opent_hongbao:
                showHongbaoPopWin(false);
                break;
            case R.id.button13:

                break;
            case R.id.button14:
                break;
            case R.id.button15:
                break;
            case R.id.button16:
                break;
            case R.id.button17:
                break;
            case R.id.button18:
                break;
        }
    }

    /**
     * 抢红包结果popwin
     */
    private void showHongbaoPopWin(boolean isEmptyHongbao) {
        View view = LayoutInflater.from(this).inflate(R.layout.popwin_get_hongbao, null, false);
        final PopupWindow pw = new PopupWindow(view, ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT, true);
        pw.showAtLocation(view, Gravity.CENTER, 0, 0);
        RoundedImageView riv_avatar = (RoundedImageView) view.findViewById(R.id.riv_avatar);//头像
        ImageView img_close_icon = (ImageView) view.findViewById(R.id.img_close_icon);//取消按钮
        TextView tv_name = (TextView) view.findViewById(R.id.tv_name);//姓名
        TextView tv_whos_hongbao = (TextView) view.findViewById(R.id.tv_whos_hongbao);//谁的红包
        TextView tv_content_hongbao = (TextView) view.findViewById(R.id.tv_content_hongbao);//红包描述
        TextView tv_getDetail_hongbao = (TextView) view.findViewById(R.id.tv_getDetail_hongbao);//获取红包详情
        TextView tv_open_hongbao = (TextView) view.findViewById(R.id.tv_open_hongbao);//打开红包
        img_close_icon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pw.dismiss();
            }
        });
        tv_open_hongbao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ToastHelper.showAlert(getApplicationContext(), "打开拆红包界面");
            }
        });
        tv_getDetail_hongbao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ToastHelper.showAlert(getApplicationContext(), "打开红包详情界面");
            }
        });
        if (isEmptyHongbao) {//红包被领完了
            ViewHelper.setViewsGone(false, tv_content_hongbao, tv_getDetail_hongbao);
            ViewHelper.setGone(tv_open_hongbao, true);
        } else {//打开红包
            ViewHelper.setViewsGone(true, tv_content_hongbao, tv_getDetail_hongbao);
            ViewHelper.setGone(tv_open_hongbao, false);
        }

    }

}
