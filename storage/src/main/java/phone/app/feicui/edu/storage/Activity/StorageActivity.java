package phone.app.feicui.edu.storage.Activity;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import phone.app.feicui.edu.storage.Bean.SmsBean;
import phone.app.feicui.edu.storage.Dao.SmsDao;
import phone.app.feicui.edu.storage.R;

public class StorageActivity extends AppCompatActivity {
    ListView mLv;
    Button mBt;
    ArrayList<SmsBean> arrayList;
    SmsDao sd;
    Context mCtx;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mCtx = this;
        setContentView(R.layout.activity_storage);
        mLv = (ListView) findViewById(R.id.sms_listview);
        sd = new SmsDao(mCtx);
        arrayList = sd.readlist();
        mBt = (Button) findViewById(R.id.sms_read);
        mBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mLv.setAdapter(new CustomAdater());
            }
        });
        mBt = (Button) findViewById(R.id.sms_write);
        mBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sd.writeXml();
            }
        });
    }

    class CustomAdater extends BaseAdapter {

        @Override
        public int getCount() {
            return arrayList.size();
        }

        @Override
        public Object getItem(int position) {
            return arrayList.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View v = convertView;
            if (v == null) {
                LayoutInflater layoutInflater = (LayoutInflater) mCtx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                v = layoutInflater.inflate(R.layout.smes_lv, null);
            }
            TextView sNnm = (TextView) v.findViewById(R.id.sms_num);//少了v.会出现什么异常
            TextView sMgs = (TextView) v.findViewById(R.id.sms_mgs);
            TextView sDate = (TextView) v.findViewById(R.id.sms_date);
            SmsBean sb = arrayList.get(position);
            sNnm.setText(sb.num);
            sMgs.setText(sb.msg);
            sDate.setText(sb.date);
            return v;
        }
    }

}
