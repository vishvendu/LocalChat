package com.example.vishvendu.localchat.Utils;

import android.app.Application;

import com.example.vishvendu.localchat.database.DaoMaster;
import com.example.vishvendu.localchat.database.DaoSession;

import org.greenrobot.greendao.database.Database;

/**
 * Created by vishvendu on 22/11/17.
 */

public class ChatApplication extends Application {

    private DaoSession daoSession;

    @Override
    public void onCreate() {
        super.onCreate();

        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(this, "contacts-db");
        Database db = helper.getWritableDb();
        daoSession = new DaoMaster(db).newSession();
    }

    public DaoSession getDaoSession() {
        return daoSession;
    }

}
