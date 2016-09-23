package com.chenley.an.yutownhelper.activity.FragmentAct;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.chenley.an.yutownhelper.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class FragmentWithViewPagerActivity extends AppCompatActivity {

    @Bind(R.id.lv_list)
    ListView lvList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_with_view_pager);
        ButterKnife.bind(this);
        initListView();
    }

    private void initListView() {
        final List<String> list = new ArrayList<>();
        list.add("传统的ViewPager实现");
        list.add("FragmentManager+Fragment实现");
        list.add("ViewPager+FragmentPagerAdapter实现");
        list.add("TabPageIndicator+ViewPager+FragmentPagerAdapter");
        lvList.setAdapter(new ArrayAdapter<String>(this, R.layout.listitem, R.id.tv_item, list));
        lvList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(FragmentWithViewPagerActivity.this, list.get(position), Toast.LENGTH_SHORT).show();
                switch (position) {
                    case 0:
                        startActivity(new Intent(FragmentWithViewPagerActivity.this, TraditionalViewPagerAcvitity.class));
                        break;
                    case 1:
                        startActivity(new Intent(FragmentWithViewPagerActivity.this, FragmentMainActivity.class));
                        break;
                    case 2:
                        startActivity(new Intent(FragmentWithViewPagerActivity.this, FragmentANDViewPagerActivity.class));
                        break;
                    case 3:

                        break;
                    default:
                        break;
                }
            }
        });
    }


}
