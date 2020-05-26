package com.handydev.financier.app;

import android.content.Context;
import android.content.res.Configuration;

import androidx.multidex.MultiDexApplication;

import com.handydev.financier.utils.MyPreferences;
import com.handydev.main.googledrive.GoogleDriveClient;

import org.androidannotations.annotations.AfterInject;
import org.androidannotations.annotations.EApplication;
import org.greenrobot.eventbus.EventBus;

@EApplication
public class FinancierApp extends MultiDexApplication {

    public EventBus bus;

    //@Bean

    public static GoogleDriveClient driveClient;

    @AfterInject
    public void init() {
        bus = EventBus.getDefault();
        driveClient = new GoogleDriveClient(getApplicationContext());
        //bus.register(driveClient);
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(MyPreferences.switchLocale(base));

    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        MyPreferences.switchLocale(this);
    }

    /*@Override
    public void onCreate() {
        //val eventBus: EventBus = EventBus.builder().addIndex(MyEventBusIndex()).build()
        //        EventBus.builder().addIndex(MyEventBusIndex()).installDefaultEventBus()
    }*/
}