package jiaoyibo.bawei.com.jiaoyibo20190109.helper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * <p>文件描述：<p>
 * <p>作者：JYB<p>
 * <p>创建时间：2019/1/9<p>
 * <p>更改时间：2019/1/9<p>
 * <p>版本号：1<p>
 */
public class openHelper extends SQLiteOpenHelper {

    public openHelper(Context context) {
        super(context, "news.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table user(id integer primary key autoincrement," +
                "news_id text," +
                "news_title text," +
                "news_summary text," +
                "pic_url text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
