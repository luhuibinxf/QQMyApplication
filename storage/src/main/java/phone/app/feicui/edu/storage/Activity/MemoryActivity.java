package phone.app.feicui.edu.storage.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import phone.app.feicui.edu.storage.R;
import phone.app.feicui.edu.storage.Util.MemoryUtil;

public class MemoryActivity extends AppCompatActivity {
    Button mBt;
    TextView mTv;
    MemoryUtil mu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_memory);
        mu = new MemoryUtil();//不初始化的结果？？？？
        mTv = (TextView) findViewById(R.id.memory_textView);
        mBt = (Button) findViewById(R.id.memory_read);
        mBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mTv.setText(mu.readFileFromExteranlStorage());
            }
        });
        mBt = (Button) findViewById(R.id.meyory_write);
        mBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mu.witteFileExteranlStorage();
            }
        });
    }
}
