package com.example.myapplication.dao;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.net.Uri;

import com.example.myapplication.Method.Press;
import com.example.myapplication.R;

import java.util.ArrayList;
import java.util.Map;

/**
 * Created by Administrator on 2016/12/26.
 */

public class PressBusiness {
    public ArrayList<Press> getPress(Context context) {
        ArrayList<Press> presses = new ArrayList<Press>();
        for (int i = 0; i < 10; i++) {
            Press mp = new Press();
            mp.icon = context.getResources().getDrawable(R.mipmap.press);
            mp.title = "习近平：重用改革促进派";
            mp.content = "习近平要求推出立得住，群众认可硬招实招，提出群众幸福感。";
            mp.price = 10.0;
            mp.number = 1000;
            mp.uri = Uri.parse("https://www.baidu.com/");
            presses.add(mp);
        }
        return presses;
    }


}
