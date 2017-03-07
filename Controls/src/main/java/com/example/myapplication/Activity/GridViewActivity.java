package com.example.myapplication.Activity;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.SimpleAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.myapplication.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GridViewActivity extends AppCompatActivity {
    private GridView mgv;
    private Context mcont;
    int[] image = new int[]{R.mipmap.a0, R.mipmap.a1, R.mipmap.a3, R.mipmap.a4, R.mipmap.a5, R.mipmap.a6, R.mipmap.a7, R.mipmap.a8, R.mipmap.a9, R.mipmap.a10, R.mipmap.a11, R.mipmap.a12, R.mipmap.a13, R.mipmap.a14, R.mipmap.a15, R.mipmap.a16, R.mipmap.a17, R.mipmap.a18};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_view);
        mgv = (GridView) findViewById(R.id.m_gridView);
        int[] to = new int[]{R.id.m_grid_image};
        String[] from = new String[]{"image"};
        List<Map<String, Object>> listItems = getAllData();
        SimpleAdapter adapter = new SimpleAdapter(this, listItems, R.layout.activity_gridlv, from, to);
        mgv.setAdapter(adapter);
        mgv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(GridViewActivity.this, "狗狗" + position, Toast.LENGTH_LONG).show();
            }
        });
//        mgv.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.sogou.com/"));
//                mcont.startActivity(i);
//            }
//        });
    }

    private List<Map<String, Object>> getAllData() {
        List<Map<String, Object>> map = new ArrayList<Map<String, Object>>();
        for (int i = 0; i < image.length; i++) {
            Map<String, Object> listItem = new HashMap<String, Object>();
            listItem.put("image", image[i]);
            map.add(listItem);
        }
        return map;
    }
}
