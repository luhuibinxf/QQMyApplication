package phone.app.feicui.edu.storage.Activity;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.CompoundButton;

import phone.app.feicui.edu.storage.R;
import phone.app.feicui.edu.storage.Util.SaveInstance;

public class PreservationActivity extends AppCompatActivity {
    Context mCt;
    CheckBox mCB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mCt = this;
        setContentView(R.layout.activity_preservation);
        mCB = (CheckBox) findViewById(R.id.m_check);
        mCB.setChecked(SaveInstance.getSaveInstance(mCt).getBooleanValue("isSaved"));
        mCB.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    SaveInstance.getSaveInstance(mCt).putBoolean("isSaved", true);
                } else {
//                    SaveInstance.getSaveInstance(mct).putBoolean("isChecked", false);
                    SaveInstance.getSaveInstance(mCt).putBoolean("isSaved", false);
                }
            }
        });
    }
}
