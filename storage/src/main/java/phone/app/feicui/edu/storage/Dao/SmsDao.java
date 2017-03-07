package phone.app.feicui.edu.storage.Dao;

import android.content.Context;
import android.content.res.AssetManager;
import android.util.Xml;
import android.widget.Switch;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlSerializer;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import phone.app.feicui.edu.storage.Bean.SmsBean;

import static android.content.Context.MODE_PRIVATE;

/**
 * Created by Administrator on 2016/12/29.
 */

public class SmsDao {
    Context context;

    public SmsDao(Context ctx) {
        context = ctx;
    }

    public ArrayList<SmsBean> getAllSms() {
        ArrayList<SmsBean> Alsb = new ArrayList<SmsBean>();
        return Alsb;
    }

    public ArrayList<SmsBean> readlist() {
        ArrayList arrayList = null;
        SmsBean sb = null;
        XmlPullParser xp = Xml.newPullParser();//1.通过Xml获取一个XmlPullParser对象
        AssetManager asset = context.getAssets();
        try {
            InputStream i = asset.open("sms.xml");
            xp.setInput(i, "utf-8");
            int eType = xp.getEventType();
            while (eType != XmlPullParser.END_DOCUMENT) {
                String currentName = xp.getName();
                switch (eType) {
                    case XmlPullParser.START_TAG:
                        if (currentName.equals("Smss")) {
                            arrayList = new ArrayList<SmsBean>();
                        } else if (currentName.equals("Sms")) {
                            sb = new SmsBean();//写的时候注意细节（单词的大小写，单词是否正确）
                            sb.id = xp.getAttributeValue(null, "id");
                        } else if (currentName.equals("num")) {
                            sb.num = xp.nextText();
                        } else if (currentName.equals("msg")) {
                            sb.msg = xp.nextText();
                        } else if (currentName.equals("date")) {
                            sb.date = xp.nextText();
                        }
                        break;
                    case XmlPullParser.END_TAG:
                        if (currentName.equals("Sms")) {
                            arrayList.add(sb);
                        }
                        break;
                    default:
                        break;

                }
                eType = xp.next();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (XmlPullParserException e) {
            e.printStackTrace();
        }
        return arrayList;
    }

    public void writeXml() {
        ArrayList<SmsBean> arrayList = getAllSms();
        XmlSerializer xs = Xml.newSerializer();
        ArrayList<SmsBean> allSms = getAllSms();
        try {
            xs.setOutput(context.openFileOutput("back.txt", Context.MODE_PRIVATE), "utf-8");
            xs.startDocument("utf-8", true);
            xs.startTag(null, "Smss");
            for (SmsBean bean : allSms) {
                xs.startTag(null, "sms");
                xs.attribute(null, "id", bean.id + "");//注意这里的写法
                xs.startTag(null, "num");//开始标签
                xs.text(bean.num);
                xs.endTag(null, "num");
                xs.startTag(null, "msg");
                xs.text(bean.msg);
                xs.endTag(null, "msg");
                xs.startTag(null, "date");
                xs.text(bean.date);
                xs.endTag(null, "date");
                xs.endTag(null, "sms");
            }
            xs.endTag(null, "Smss");
            xs.endDocument();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
