package com.chenley.an.yutownhelper.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import butterknife.Bind;
import butterknife.ButterKnife;
import com.chenley.an.yutownhelper.R;
import com.chenley.an.yutownhelper.views.DragWebView;

/**
 * 商品详情的详情页
 */
public class ProductH5Fragment extends Fragment {

  @Bind(R.id.detail_webView) DragWebView detailWebView;
  private String detailUrl = "http://www.ymatou.com/product/fc3fb6cc7cf243829b9fcd37deaa54af.html";

  @Nullable @Override
  public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
      @Nullable Bundle savedInstanceState) {
    View view = inflater.inflate(R.layout.fragment_special_h5_layout, null);
    ButterKnife.bind(this, view);
    init();
    return view;
  }

  private void init() {
    initWebSetting();
    initView();
  }

  private void initWebSetting() {
    WebSettings webSettings = detailWebView.getSettings();
    webSettings.setJavaScriptEnabled(true);
    webSettings.setSupportZoom(true);
    detailWebView.setWebViewClient(new WebViewClient() {
      @Override public boolean shouldOverrideUrlLoading(WebView view, String url) {
        return false;
      }
    });
  }

  public void initView() {
    detailWebView.loadUrl(detailUrl);
  }

  @Override public void onDestroyView() {
    super.onDestroyView();
    ButterKnife.unbind(this);
  }
}
