package com.chenley.an.yutownhelper.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.chenley.an.yutownhelper.R;
import com.chenley.an.yutownhelper.bean.KeyIntJsonBean;
import com.google.gson.Gson;

public class KeyIntJsonPaseActivity extends AppCompatActivity {
  public static final String KEY_INT_JSON = "{\n"
      + "    \"apistatus\": 1,\n"
      + "    \"result\": {\n"
      + "        \"4\": [\n"
      + "            {\n"
      + "                \"endTime\": 1480031820000,\n"
      + "                \"id\": 24,\n"
      + "                \"images\": [\n"
      + "                    {\n"
      + "                        \"height\": 200,\n"
      + "                        \"id\": 4,\n"
      + "                        \"imageId\": \"750-200-f5cebca194ba0201f3cef84c4616851d\",\n"
      + "                        \"linkUrl\": \"http://wiki.17shihui.com/pages/viewpage.action?pageId=721636\",\n"
      + "                        \"width\": 750\n"
      + "                    },\n"
      + "                    {\n"
      + "                        \"height\": 200,\n"
      + "                        \"id\": 5,\n"
      + "                        \"imageId\": \"750-200-f0005d177254573edd741b6ce55ff1ae\",\n"
      + "                        \"linkUrl\": \"https://www.google.com.hk/search?q=jenkins&oq=jenkins&aqs=chrome..69i57.3322j0j4&sourceid=chrome&ie=UTF-8\",\n"
      + "                        \"width\": 750\n"
      + "                    }\n"
      + "                ],\n"
      + "                \"startTime\": 1477958220000,\n"
      + "                \"typeId\": 4\n"
      + "            }\n"
      + "        ],\n"
      + "        \"5\": [\n"
      + "            {\n"
      + "                \"endTime\": 1479297900000,\n"
      + "                \"id\": 26,\n"
      + "                \"images\": [\n"
      + "                    {\n"
      + "                        \"height\": 200,\n"
      + "                        \"id\": 6,\n"
      + "                        \"imageId\": \"750-200-df0d3ae1715706d173b96ce03060b981\",\n"
      + "                        \"linkUrl\": \"http://wiki.17shihui.com/pages/viewpage.action?pageId=721636\",\n"
      + "                        \"width\": 750\n"
      + "                    }\n"
      + "                ],\n"
      + "                \"startTime\": 1478001900000,\n"
      + "                \"typeId\": 5\n"
      + "            }\n"
      + "        ],\n"
      + "        \"6\": [],\n"
      + "        \"7\": []\n"
      + "    }\n"
      + "}";

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_key_int_json_pase);
    ButterKnife.bind(this);
  }

  @OnClick(R.id.btn_pase_json) public void onClick() {
    Gson gson = new Gson();
    KeyIntJsonBean bean = gson.fromJson(KEY_INT_JSON, KeyIntJsonBean.class);
    Toast.makeText(this, "bean=" + bean.toString(), Toast.LENGTH_SHORT).show();
  }
}
