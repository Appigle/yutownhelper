package com.chenley.an.yutownhelper.activity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.ImageView;

import com.chenley.an.yutownhelper.R;
import com.chenley.an.yutownhelper.base.BaseActionBarActivity;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import rx.Observable;
import rx.Observer;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action0;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

/**
 * Author:    Chenley
 * Version    V2.0
 * Date:      2016/8/29
 * Description:
 * Modification    History:
 * Date         	Author        		Version        	Description
 * ------------------------------------------------------------------
 * 2016/8/29         Chenley             2.0                2.0
 * Why & What is modified:
 */
public class RxJavaKnowledgeActivity extends BaseActionBarActivity {
    private final String TAG = this.getClass().getSimpleName() + "@@";
    @Bind(R.id.btn_observable)
    Button btnObservable;
    @Bind(R.id.iv_rxjavademo)
    ImageView ivRxjavademo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rxjava_knowledge);
        ButterKnife.bind(this);
        rxJavaFunc();
        printStr();
        setImageViewWithRxJava();
        scheduler();
    }

    /**
     * Scheduler: 调度器使用
     */
    private void scheduler() {
        Observable.just(1, 2, 3, 4)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<Integer>() {
                    @Override
                    public void call(Integer integer) {
                        Log.d(TAG, "call() called with: " + "integer = [" + integer + "]");
                    }
                });
    }

    /**
     * 使用RxJava模式打印字符串数组
     */
    private void printStr() {
        String[] names = {"tom", "lily", "hanmeimei"};
        Observable.from(names).subscribe(new Action1<String>() {
            @Override
            public void call(String s) {
                Log.d(TAG, "call() called with: " + "s = [" + s + "]");
            }
        });
    }

    /**
     * 使用RxJava模式设置ImageView的背景显示
     */
    private void setImageViewWithRxJava() {
        Observable.create(new Observable.OnSubscribe<Drawable>() {
            @Override
            public void call(Subscriber<? super Drawable> subscriber) {
                Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.cloudsea);
                Drawable d  = new BitmapDrawable(getResources(),bitmap);
                subscriber.onNext(d);
                subscriber.onCompleted();
            }
        })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Drawable>() {
                    @Override
                    public void onCompleted() {
                        Log.d(TAG, "onCompleted() called with: " + "");
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d(TAG, "onError() called with: " + "e = [" + e + "]");
                    }

                    @Override
                    public void onNext(Drawable drawable) {
                        ivRxjavademo.setImageDrawable(drawable);
                    }
                });
    }

    /**
     * RxJava使用的方法
     */
    private void rxJavaFunc() {

        //基础方式创建一个观测者
        Observer<String> observer = new Observer<String>() {
            @Override
            public void onCompleted() {
                Log.i(TAG, "onCompleted() called with: " + "");
            }

            @Override
            public void onError(Throwable e) {
                Log.i(TAG, "onError() called with: " + "e = [" + e + "]");
            }

            @Override
            public void onNext(String s) {
                Log.i(TAG, "onNext() called with: " + "s = [" + s + "]");
            }
        };

        //Subscriber是Observer的一个具体实现子类，使用方法类似Observer，多了一些扩展方法
        Subscriber<String> subscriber = new Subscriber<String>() {
            @Override
            public void onCompleted() {
                Log.d(TAG, "onCompleted() called with: " + "");
            }

            @Override
            public void onError(Throwable e) {
                Log.d(TAG, "onError() called with: " + "e = [" + e + "]");
            }

            @Override
            public void onNext(String s) {
                Log.d(TAG, "onNext() called with: " + "s = [" + s + "]");
            }
        };

        //被观察者的创建方式1：create（）
        Observable<String> observable = Observable.create(new Observable.OnSubscribe<String>() {
            @Override
            public void call(Subscriber<? super String> subscriber) {
                subscriber.onNext("Hello");
                subscriber.onNext("World!");
                subscriber.onNext("RxJava");
                subscriber.onCompleted();
            }
        });

        //被观察者的创建方式2：just（） 将传入的参数依次发送出来
        Observable<String> observable1 = Observable.just("Hello", "World!", "RxJava");
        // 将会依次调用：
        // onNext("Hello");
        // onNext("World!");
        // onNext("RxJava");
        // onCompleted();

        //被观察者的创建方式3：from（T[])/from(Iteraable<? extends T>) 将传入的数组或者Iterable拆分成具体对象后发送出来
        String[] words = {"Hello", "World!", "RxJava"};
        Observable observable2 = Observable.from(words);
        // 将会依次调用：
        // onNext("Hello");
        // onNext("World!");
        // onNext("RxJava");
        // onCompleted();

        /*
        上面三种方式创建被观察者Obersvable对象，是等价的！
         */

        observable.subscribe(subscriber);
        //or
        observable.subscribe(observer);

        Action1<String> onNextAction = new Action1<String>() {
            @Override
            public void call(String s) {
                Log.d(TAG, "call() called with: " + "s = [" + s + "]");
            }
        };
        Action1<Throwable> onErrorAction = new Action1<Throwable>() {
            @Override
            public void call(Throwable throwable) {
                Log.d(TAG, "call() called with: " + "throwable = [" + throwable + "]");
            }
        };
        Action0 onCompletedAction = new Action0() {
            @Override
            public void call() {
                Log.d(TAG, "call() called with: " + "completed");
            }
        };

        //自动创建Subscriber,并使用onNextAciton来定义onNext（）；
        observable.subscribe(onNextAction);
        //自动创建Subscriber,并使用onNextAciton和onErrorAciton，来定义onNext（）和onError（）；
        observable.subscribe(onNextAction, onErrorAction);
        //自动创建Subscriber,并使用onNextAction来定义onNext（），使用onErrorAciton来定义onError（），使用onCompletedAction来定义onCompleted（）
        observable.subscribe(onNextAction, onErrorAction, onCompletedAction);

    }

    @OnClick(R.id.btn_observable)
    public void onClick() {
    }
}