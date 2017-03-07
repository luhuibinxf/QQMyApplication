package com.example.administrator.qqmyapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class QQMainActivity extends AppCompatActivity implements View.OnClickListener {
    private final String TAG = "QQMainActivity";
    private Button mjumpBt;
    private TextView mtextView1;
    private boolean flag = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qqmain);
        mjumpBt = (Button) findViewById(R.id.jump);
        mtextView1 = (TextView) findViewById(R.id.textView1);
        mjumpBt.setOnClickListener(this);//词句不能少
        mtextView1.setOnClickListener(this);
        Log.i(TAG, "onCreate");
    }

    protected void onStart() {
        super.onStart();
        Log.i(TAG, "onStart");
    }

    protected void onRestart() {
        super.onRestart();
        Log.i(TAG, "onRestart");
    }

    protected void onResume() {
        super.onResume();
        Log.i(TAG, "onResume");
    }

    protected void onPause() {
        super.onPause();
        Log.i(TAG, "onPause");
    }

    protected void onStop() {
        super.onStop();
        Log.i(TAG, "onStop");
    }

    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "onDestroy");
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.jump:
                Intent intent = new Intent(QQMainActivity.this, MainActivity.class);
                startActivity(intent);
                break;
            case R.id.textView1:
                Toast.makeText(QQMainActivity.this, "哈哈哈哈", Toast.LENGTH_LONG).show();
        }
    }
}
