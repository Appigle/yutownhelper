package com.chenley.an.yutownhelper.Activity;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.akexorcist.roundcornerprogressbar.IconRoundCornerProgressBar;
import com.akexorcist.roundcornerprogressbar.RoundCornerProgressBar;
import com.chenley.an.yutownhelper.R;

import java.lang.ref.WeakReference;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class PbAct extends AppCompatActivity {

    @Bind(R.id.progressBar)
    ProgressBar progressBar;
    @Bind(R.id.btn_aa)
    Button btnAa;
    @Bind(R.id.view)
    View view;
    @Bind(R.id.btn_copy)
    Button btnCopy;
    @Bind(R.id.tv_copydata)
    TextView tvCopydata;
    @Bind(R.id.rcpb_normal)
    RoundCornerProgressBar rcpbNormal;
    @Bind(R.id.ircpb_with_icon)
    IconRoundCornerProgressBar ircpbWithIcon;
    @Bind(R.id.ircpb_with_icon2)
    IconRoundCornerProgressBar ircpbWithIcon2;

    private int targetProgress = 100;
    private int curProgress = 0 ;

    public int getCurProgress() {
        return curProgress;
    }

    public void setCurProgress(int curProgress) {
        this.curProgress = curProgress;
    }

    public int getTargetProgress() {
        return targetProgress;
    }

    public void setTargetProgress(int targetProgress) {
        this.targetProgress = targetProgress;
    }

/*    private Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            if (curProgress <= targetProgress) {
                rcpbNormal.setProgress(curProgress);
                mHandler.sendEmptyMessageDelayed(0x123,100);
                curProgress++;
            }
        }
    };*/

    private static class myHandler extends Handler{
        private final WeakReference<PbAct> mWeakPbAct ;

        public myHandler(PbAct mPbAct) {
           mWeakPbAct = new WeakReference<PbAct>(mPbAct);
        }

        @Override
        public void handleMessage(Message msg) {
            PbAct mPbAct = mWeakPbAct.get();


        }
    }
    //static inner class doesn't hold an implicit reference to the outer class
    private static class MyHandler2 extends Handler {
        //Using a weak reference means you won't prevent garbage collection
        private final WeakReference<PbAct> myClassWeakReference;

        public MyHandler2(PbAct myClassInstance) {
            myClassWeakReference = new WeakReference<PbAct>(myClassInstance);
        }

        @Override
        public void handleMessage(Message msg) {
            PbAct mPbAct = myClassWeakReference.get();
            if (mPbAct != null) {
                    if (mPbAct.getCurProgress() <= mPbAct.getTargetProgress()) {
                        mPbAct.rcpbNormal.setProgress(mPbAct.getCurProgress());
                        this.sendEmptyMessageDelayed(0x123,100);
                        mPbAct.setCurProgress(mPbAct.getCurProgress()+1);
                }
            }
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pb);
        ButterKnife.bind(this);
        updatePb();
    }

    private void updatePb() {
        targetProgress = 30;
    }


    /**
     * 实现文本复制功能
     * add by wangqianzhou
     *
     * @param content
     */
    public void copy(String content, Context context) {
        // 得到剪贴板管理器
        ClipboardManager cmb = (ClipboardManager) context.getSystemService(Context.CLIPBOARD_SERVICE);
        cmb.setPrimaryClip(new ClipData(ClipData.newPlainText("expressno", content)));
    }

    /**
     * 实现粘贴功能
     * add by wangqianzhou
     *
     * @param context
     * @return
     */
    public String paste(Context context) {
// 得到剪贴板管理器
        ClipboardManager cmb = (ClipboardManager) context.getSystemService(Context.CLIPBOARD_SERVICE);
        return cmb.getPrimaryClip().toString().trim();
    }

    @OnClick({R.id.btn_aa, R.id.btn_copy,R.id.rcpb_normal})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_aa:
                break;
            case R.id.rcpb_normal:
                curProgress = 6;

                MyHandler2 mMyHandler2 = new MyHandler2(this);
                mMyHandler2.sendEmptyMessage(0x123);
                break;
            case R.id.btn_copy:
                Toast.makeText(PbAct.this, "点击复制了：+content", Toast.LENGTH_SHORT).show();
                copy("测试复制：这是复制内容", this);
                break;
        }
    }

   /* 首先创建一个ClipboardManager对象cmb并将其与系统剪贴板相关联。之后通过setText(CharSequence text)函数即可将String类型的内容复制到剪贴板。此外ClipboardManager类还提供有abstract CharSequence getText()函数以及abstract boolean hasText()，分别可以获取剪贴板中的字符串内容以及查询剪贴板当前是否保存有内容。ClipboardManager类有两个版本，这里使用的是从API Level 1就开始被支持的仅能保存字符串的剪贴板管理器，自从Android 3.0（API Level 11）起新版本的ClipboardManager类则支持更多功能。详情请参见官方文档。
    android2.1之前版本使用如下方法
    复制代码 代码如下:*/

//    IClipboard clip = IClipboard.Stub.asInterface(ServiceManager.getService("clipboard"));
//    clip.getClipboardText().toString();//获得复制的内容
//    clip.setClipboardText(text);//设置Clipboard 的内容
}
