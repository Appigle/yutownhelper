package com.chenley.an.yutownhelper.Activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.chenley.an.yutownhelper.R;
import com.chenley.an.yutownhelper.utils.ToastHelper;
import com.daimajia.slider.library.Animations.DescriptionAnimation;
import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;

import butterknife.Bind;
import butterknife.ButterKnife;

public class SlideImageActivity extends AppCompatActivity {

    @Bind(R.id.slider)
    SliderLayout mSlider;

    int[] pics = new int[]{R.drawable.cloudsea, R.drawable.forest, R.drawable.young, R.drawable.sky, R.drawable.sea};
    String[] titles = new String[]{"大雾云海", "绿荫森林", "青春","太空","贝壳"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slide_image);
        ButterKnife.bind(this);
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
}
