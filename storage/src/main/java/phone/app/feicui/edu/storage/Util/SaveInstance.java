package phone.app.feicui.edu.storage.Util;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Administrator on 2017/1/1.
 */

public class SaveInstance {
    static Context mctx;
    private static SaveInstance saveInstance = null;
    SharedPreferences sp = null;
    SharedPreferences.Editor se;

    public SaveInstance() {
        sp = mctx.getSharedPreferences("is", Context.MODE_APPEND);//这句话的作用
        se = sp.edit();
    }

    public synchronized static SaveInstance getSaveInstance(Context ctx) {
        mctx = ctx;//上面为什么是静态的
        if (saveInstance == null) {
            return new SaveInstance();
        }
        return saveInstance;
    }

//    public void putString(String key, String value) {
//        se.putString("isSaved", "ok");
//        se.commit();
//    }

    public void putBoolean(String key, boolean value) {
        se.putBoolean(key, value);
        se.commit();
    }

//    public String getStringValue(String key) {
//        return sp.getString(key, "unSaved");
//    }

    public boolean getBooleanValue(String key) {
        return sp.getBoolean(key, false);
    }
}
