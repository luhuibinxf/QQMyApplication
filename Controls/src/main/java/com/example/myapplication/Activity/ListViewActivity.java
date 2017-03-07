package com.example.myapplication.Activity;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.DataSetObserver;
import android.net.Uri;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.myapplication.Method.Press;
import com.example.myapplication.R;
import com.example.myapplication.dao.PressBusiness;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.zip.Inflater;

public class ListViewActivity extends AppCompatActivity {
    private Context mcont;
    private ListView mcuslv;
    private ArrayList<Press> mpre;
    private PressBusiness mpbs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mcont = this;//这样写？？？
        setContentView(R.layout.activity_list_view);
        mcuslv = (ListView) findViewById(R.id.m_lv);
        mpbs = new PressBusiness();
        mpre = mpbs.getPress(mcont);
        mcuslv.setAdapter(new CustomAdater());
//        mcuslv.setOnClickListener(this);
    }

    private class CustomAdater implements ListAdapter {
        Map<Integer, String> map = new HashMap<Integer, String>();

        @Override
        public boolean areAllItemsEnabled() {
            return false;
        }

        @Override
        public boolean isEnabled(int position) {
            return false;
        }

        @Override
        public void registerDataSetObserver(DataSetObserver observer) {

        }

        @Override
        public void unregisterDataSetObserver(DataSetObserver observer) {

        }

        @Override
        public int getCount() {
            return mpre.size();
        }

        @Override
        public Object getItem(int position) {
            return mpre.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public boolean hasStableIds() {
            return false;
        }

        @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View v = convertView;
            if (v == null) {
                LayoutInflater layoutInflater = (LayoutInflater) mcont.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                v = layoutInflater.inflate(R.layout.activity_listview, null);
            }
            ImageView preIcon = (ImageView) v.findViewById(R.id.m_list_image);
            preIcon.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.baidu.com/"));
                    mcont.startActivity(i);
                }
            });
            TextView preTitle = (TextView) v.findViewById(R.id.m_list_text1);
            preTitle.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.sogou.com/"));
                    mcont.startActivity(i);
                }
            });
            TextView preContent = (TextView) v.findViewById(R.id.m_list_text2);
            preContent.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.Google.com/"));
                    mcont.startActivity(i);
                }
            });
            TextView prePrice = (TextView) v.findViewById(R.id.m_list_text3);
            TextView prenumber = (TextView) v.findViewById(R.id.m_list_text4);
            Press p = mpre.get(position);
            preIcon.setBackground(mpbs.getPress(mcont).get(position).icon);
            preTitle.setText(mpbs.getPress(mcont).get(position).title);
            preContent.setText(mpbs.getPress(mcont).get(position).content);
            prePrice.setText("价格:" + mpbs.getPress(mcont).get(position).price);
            prenumber.setText("评论:" + mpbs.getPress(mcont).get(position).number);
            return v;
        }

        @Override
        public int getItemViewType(int position) {
            return position;
        }

        @Override
        public int getViewTypeCount() {
            return mpre.size();
        }

        @Override
        public boolean isEmpty() {
            return false;
        }
    }
}
