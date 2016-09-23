package com.chenley.an.yutownhelper.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.chenley.an.yutownhelper.R;
import com.chenley.an.yutownhelper.adapter.ShoppingMallAdapter;
import com.chenley.an.yutownhelper.utils.ToastHelper;
import com.daimajia.slider.library.Animations.DescriptionAnimation;
import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;
import com.malinskiy.superrecyclerview.SuperRecyclerView;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ShoppingMallPageActivity extends AppCompatActivity {

    @Bind(R.id.slider)
    SliderLayout mSlider;
    @Bind(R.id.rl_toptitlebar_back)
    RelativeLayout rlToptitlebarBack;
    @Bind(R.id.tv_title)
    TextView tvTitle;
    @Bind(R.id.iv_launch_task)
    ImageView ivLaunchTask;
    @Bind(R.id.rl_toptitlebar_more)
    RelativeLayout rlToptitlebarMore;
    @Bind(R.id.rl_topbar)
    RelativeLayout rlTopbar;
    @Bind(R.id.sr_productshow)
    SuperRecyclerView srProductshow;

    private ShoppingMallAdapter mShoppingMallAdapter;


    int[] pics = new int[]{R.drawable.cloudsea, R.drawable.forest, R.drawable.young, R.drawable.sky, R.drawable.sea};
    String[] titles = new String[]{"大雾云海", "绿荫森林", "青春", "太空", "贝壳"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopping_mall_page);
        ButterKnife.bind(this);
        initHeadImageView();
        initProductView();
    }

    private void initProductView() {
        mShoppingMallAdapter = new ShoppingMallAdapter(ShoppingMallPageActivity.this);
        GridLayoutManager mGridLayoutManager = new GridLayoutManager(ShoppingMallPageActivity.this,
                2,GridLayoutManager.VERTICAL,false);
        srProductshow.setLayoutManager(mGridLayoutManager);
        srProductshow.setAdapter(mShoppingMallAdapter);
        List<String> add = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            add.add("xx" + i);
        }
        mShoppingMallAdapter.addItems(add);
    }

    private void initHeadImageView() {
        for (int i = 0; i < pics.length; i++) {
            TextSliderView textSliderView = new TextSliderView(this);
            textSliderView
                    .description(titles[i])
                    .image(pics[i])
                    .setScaleType(BaseSliderView.ScaleType.Fit)
                    .setOnSliderClickListener(new BaseSliderView.OnSliderClickListener() {
                        @Override
                        public void onSliderClick(BaseSliderView slider) {
                            ToastHelper.showAlert(getApplicationContext(), "这是轮播图片组件！");
                        }
                    });
            mSlider.addSlider(textSliderView);
            mSlider.setPresetTransformer(SliderLayout.Transformer.Accordion);
            mSlider.setPresetIndicator(SliderLayout.PresetIndicators.Right_Bottom);
            mSlider.setCustomAnimation(new DescriptionAnimation());
            mSlider.setDuration(4000);
            mSlider.startAutoCycle();
        }
    }

    @OnClick({R.id.rl_toptitlebar_back, R.id.tv_title, R.id.iv_launch_task, R.id.rl_toptitlebar_more, R.id.rl_topbar, R.id.slider, R.id.sr_productshow})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.rl_toptitlebar_back:
                break;
            case R.id.tv_title:
                break;
            case R.id.iv_launch_task:
                break;
            case R.id.rl_toptitlebar_more:
                break;
            case R.id.rl_topbar:
                break;
            case R.id.slider:
                break;
            case R.id.sr_productshow:
                break;
        }
    }
}
