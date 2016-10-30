package com.chenley.an.yutownhelper.activity;

import android.animation.IntEvaluator;
import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.net.http.SslError;
import android.os.Build;
import android.os.Bundle;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.JavascriptInterface;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.SslErrorHandler;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.chenley.an.yutownhelper.R;

import butterknife.Bind;
import butterknife.ButterKnife;

public class WebViewDemo extends AppCompatActivity {
    private static final String TAG = "WebViewDemo@@";

    @Bind(R.id.wv_test)
    WebView mWebView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view_demo);
        ButterKnife.bind(this);
        initWebSettings();
        initWebViewContent();
        initWebViewClient();
        initWebViewWithJavaScript();
    }

    @Override
    protected void onDestroy() {
        //当Activity销毁时，将mWebView置空，防止内存泄露
        if (mWebView != null) {
            mWebView.loadDataWithBaseURL(null, "", "text/html", "utf-8", null);
            mWebView.clearHistory();
            ((ViewGroup) mWebView.getParent()).removeView(mWebView);
            mWebView.destroy();
            mWebView = null;
        }
        super.onDestroy();
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        //功能后退键处理网页后退和退出程序冲突
        if (keyCode == KeyEvent.ACTION_DOWN && mWebView.canGoBack()) {
            mWebView.goBack();
            return true;//返回True表示事件消费
        }
        return super.onKeyDown(keyCode, event);
    }

    /**
     * 判断WebView的加载页面的位置
     *
     * @param mWebView
     */
    private void pagePosition(WebView mWebView) {
        if (mWebView.getContentHeight() * mWebView.getScaleY()
                == (mWebView.getHeight() + mWebView.getScrollY())) {
            //页面处于底端
        } else if (mWebView.getScrollY() == 0) {
            //页面处于顶端
        } else {
            //页面处于中间位置
            int ScrollHeight = (int) mWebView.getScrollY();
        }
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
    }

    /**
     * 采用ValueAnimator，监听动画过程，实现对象属性的改变
     * @param target
     * @param start
     * @param end
     */
    public void performValueAnimator(final View target, final int start, final int end) {
        ValueAnimator animator = ValueAnimator.ofFloat(1, 100);//创建动画对象
        //添加动画更新监听
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            //创建一个整型估值器
            private IntEvaluator intEvaluator = new IntEvaluator();
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                //获取当前动画的进度值，整型1-100之间
                int currentValue = (int) animation.getAnimatedValue();
                Log.d(TAG, "onAnimationUpdate: currentValue = "+currentValue);
                //获取当前进度咱整个动画过程的比例，浮点型0-1之间
                float fraction = animation.getAnimatedFraction();
                //直接调用整型估值器，通过比例计算出尺寸，然后设置给View
                target.getLayoutParams().width = intEvaluator.evaluate(fraction, start, end);
                target.requestLayout();
            }
        });
    }

    /**
     * 设置与JS脚本交互
     */
    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    private void initWebViewWithJavaScript() {
        if (Build.VERSION.SDK_INT >= 17) {
            mWebView.addJavascriptInterface(new JsInterface(), "JsInterface");
        } else {
            //处理4.2版本以下的JS注入漏洞问题代码
        }
    }

    /**
     * 设置WebViewClient
     */
    private void initWebViewClient() {
        //setWebChromeClient:主要处理解析，渲染网页等浏览器做的事情；
        //WebChromeClient是辅助WebView处理Js的对话框，网站图标，网站title，加载进度条等；
        mWebView.setWebChromeClient(new WebChromeClient() {
            /**
             * 加载进度更新
             * @param view
             * @param newProgress
             */
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                super.onProgressChanged(view, newProgress);
            }

            /**
             * 接收到图标Icon
             * @param view
             * @param icon
             */
            @Override
            public void onReceivedIcon(WebView view, Bitmap icon) {
                super.onReceivedIcon(view, icon);
            }

            /**
             * 创建窗口
             * @param view
             * @param isDialog
             * @param isUserGesture
             * @param resultMsg
             * @return
             */
            @Override
            public boolean onCreateWindow(WebView view, boolean isDialog, boolean isUserGesture, Message resultMsg) {
                return super.onCreateWindow(view, isDialog, isUserGesture, resultMsg);
            }

            /**
             * 请求焦点
             * @param view
             */
            @Override
            public void onRequestFocus(WebView view) {
                super.onRequestFocus(view);
            }

            /**
             * 关闭窗口
             * @param window
             */
            @Override
            public void onCloseWindow(WebView window) {
                super.onCloseWindow(window);
            }

            /**
             * js弹窗
             * @param view
             * @param url
             * @param message
             * @param result
             * @return
             */
            @Override
            public boolean onJsAlert(WebView view, String url, String message, JsResult result) {
                return super.onJsAlert(view, url, message, result);
            }

            /**
             * Js确认弹窗
             * @param view
             * @param url
             * @param message
             * @param result
             * @return
             */
            @Override
            public boolean onJsConfirm(WebView view, String url, String message, JsResult result) {
                return super.onJsConfirm(view, url, message, result);
            }

            /**
             * js提示窗
             * @param view
             * @param url
             * @param message
             * @param defaultValue
             * @param result
             * @return
             */
            @Override
            public boolean onJsPrompt(WebView view, String url, String message, String defaultValue, JsPromptResult result) {
                return super.onJsPrompt(view, url, message, defaultValue, result);
            }
        });

        //WebViewClient就是辅助WebView处理各种通知和请求
        mWebView.setWebViewClient(new WebViewClient() {
            /**
             * 是否重载URL链接
             * @param view
             * @param url
             * @return
             */
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                return super.shouldOverrideUrlLoading(view, url);
            }

            /**
             * 加载Page开始
             * @param view
             * @param url
             * @param favicon
             */
            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);
            }

            /**
             * 加载Page结束
             * @param view
             * @param url
             */
            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
            }

            /**
             * 加载资源
             * @param view
             * @param url
             */
            @Override
            public void onLoadResource(WebView view, String url) {
                super.onLoadResource(view, url);
            }

            /**
             * 是否拦截请求
             * @param view
             * @param request
             * @return
             */
            @Override
            public WebResourceResponse shouldInterceptRequest(WebView view, WebResourceRequest request) {
                return super.shouldInterceptRequest(view, request);
            }

            /**
             * 接收错误
             * @param view
             * @param request
             * @param error
             */
            @Override
            public void onReceivedError(WebView view, WebResourceRequest request, WebResourceError error) {
                super.onReceivedError(view, request, error);
            }

            /**
             * 接收HttpError
             * @param view
             * @param request
             * @param errorResponse
             */
            @Override
            public void onReceivedHttpError(WebView view, WebResourceRequest request, WebResourceResponse errorResponse) {
                super.onReceivedHttpError(view, request, errorResponse);
            }

            /**
             * 接收SSL错误
             * @param view
             * @param handler
             * @param error
             */
            @Override
            public void onReceivedSslError(WebView view, SslErrorHandler handler, SslError error) {
                super.onReceivedSslError(view, handler, error);
            }
        });
    }

    /**
     * 加载WebView的内容
     */
    private void initWebViewContent() {
        //加载网络网页资源
        mWebView.loadUrl("http://www.zhihu.com");
        //加载res/assets/test.html网页文件
        mWebView.loadUrl("file:///android_assets/test.html");
        //加载SD卡内test.html文件
        mWebView.loadUrl("content://com.android.htmlfileprovider/sdcard/test.html");
    }

    /**
     * 初始化WebView的设置
     */
    private void initWebSettings() {
        WebSettings webSettings = mWebView.getSettings();
        //获取触摸焦点，用来输入密码，用户名等操作
        mWebView.requestFocusFromTouch();
        //设置使用WebView的宽度来调节图片等宽度
        webSettings.setUseWideViewPort(true);
        //加载网页适应屏幕
        webSettings.setLoadWithOverviewMode(true);
        //设置不支持页面缩放
        webSettings.setSupportZoom(false);
        //设置内置的缩放插件可用
        webSettings.setBuiltInZoomControls(true);
        //隐藏原始的缩放控件
        webSettings.setDisplayZoomControls(false);
        //支持内容重新布局
        webSettings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NORMAL);
        //WebView的缓存选项
        webSettings.setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);
        //设置是否可以访问手机文件
        webSettings.setAllowFileAccess(true);
        //当WebView调用RequestFocus的时候为WebView设置焦点
        webSettings.setNeedInitialFocus(true);
        //设置支持通过JavaScript打开窗口
        webSettings.setJavaScriptCanOpenWindowsAutomatically(true);
        //设置网页的编码格式
        webSettings.setDefaultTextEncodingName("UTF-8");
        //设置是否自动加载图片
        webSettings.setLoadsImagesAutomatically(true);
        //设置是否支持JavaScript脚本,Android 版本大于17( November 2012: Android 4.2, Moar jelly beans!)，
        // 则需要在方法上添加@JavaScriptInterface注解
        webSettings.setJavaScriptEnabled(true);
    }

    /**
     * 与JavaScript交互类
     * JS脚本注入漏洞在Android 4.2以后通过注解修复，在4.2之前需要单独处理
     * 【1】让JS调用一个Javascript方法，这个方法中是调用prompt方法，通过prompt把JS中的信息传递过来，
     * 这些信息应该是我们组合成的一段有意义的文本，可能包含：特定标识，方法名称，参数等。
     * 在onJsPrompt方法中，我们去解析传递过来的文本，得到方法名，参数等，再通过反射机制，
     * 调用指定的方法，从而调用到Java对象的方法。
     * 【2】关于返回值，可以通过prompt返回回去，这样就可以把Java中方法的处理结果返回到Js中。
     */
    private class JsInterface extends Object {
        /**
         * JS调用无参方法
         *
         * @return
         */
        @JavascriptInterface
        public String JSCallJava() {
            return "HtmlCallJava";
        }

        /**
         * JS调用带参方法
         *
         * @param args
         * @return
         */
        @JavascriptInterface
        public String JSCallJavaWithArgs(String args) {
            return "JSCallJavaWithArgs" + args;
        }

        /**
         * 本地方法调用无参JS脚本方法
         */
        public void JavaCallJS() {
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    //通过LoadUrl方式调用JS脚本方法
                    mWebView.loadUrl("javascript:JavaCallJS()");
                }
            });
        }

        /**
         * 本地方法调用有参JS脚本方法
         *
         * @param args
         */
        public void JavaCallJSWithArgs(final String args) {
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    //通过LoadUrl方式调用JS脚本方法
                    mWebView.loadUrl("javascript:JavaCallJS(" + args + ")");
                }
            });
        }
    }
}
