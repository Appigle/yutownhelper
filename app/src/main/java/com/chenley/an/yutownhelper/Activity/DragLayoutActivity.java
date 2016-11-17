package com.chenley.an.yutownhelper.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;
import butterknife.Bind;
import butterknife.ButterKnife;
import com.chenley.an.yutownhelper.fragment.DragFragmentOne;
import com.chenley.an.yutownhelper.fragment.ProductH5Fragment;
import com.chenley.an.yutownhelper.R;
import com.chenley.an.yutownhelper.views.DragLayout;

public class DragLayoutActivity extends AppCompatActivity {

  @Bind(R.id.dragLayout) DragLayout dragLayout;
  ProductH5Fragment f2;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_drag_layout);
    ButterKnife.bind(this);
    f2 =  new ProductH5Fragment();
    if (savedInstanceState == null) {
      getSupportFragmentManager().beginTransaction()
          .add(R.id.fragment_one, new DragFragmentOne())
          .add(R.id.fragment_two,f2)
          .commit();
    }
    init();
  }

  private void init() {
    initDrag();
  }

  private void initDrag() {
    DragLayout.ShowNextPageDrag next = new DragLayout.ShowNextPageDrag() {
      @Override
      public void onDragNext() {
        Toast.makeText(DragLayoutActivity.this, "下一页", Toast.LENGTH_SHORT).show();
        f2.initView();
      }
    };
    dragLayout.setNextPageListener(next);
  }
}
