package com.example.myapplication.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.myapplication.R;

public class ControlsActivity extends AppCompatActivity implements View.OnClickListener {
    Button mbut;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_controls);
        mbut = (Button) findViewById(R.id.m_bt_list);
        mbut.setOnClickListener(this);
        mbut = (Button) findViewById(R.id.m_bt_grid);
        mbut.setOnClickListener(this);
        mbut = (Button) findViewById(R.id.m_bt_spinner);
        mbut.setOnClickListener(this);
        mbut = (Button) findViewById(R.id.m_bt_expandable);
        mbut.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        Intent intent;
        switch (v.getId()) {
            case R.id.m_bt_list:
                intent = new Intent(ControlsActivity.this, ListViewActivity.class);
                startActivity(intent);
                break;
            case R.id.m_bt_grid:
                intent = new Intent(ControlsActivity.this, GridViewActivity.class);
                startActivity(intent);
                break;
            case R.id.m_bt_spinner:
                intent = new Intent(ControlsActivity.this, SpinnerActivity.class);
                startActivity(intent);
                break;
            case R.id.m_bt_expandable:
                intent = new Intent(ControlsActivity.this, null);
                startActivity(intent);
                break;
        }

    }
}
