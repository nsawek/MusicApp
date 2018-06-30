package com.example.snowa.musicapp;

import android.app.Application;

import io.realm.RealmConfiguration;
import sun.security.krb5.Realm;

import static io.realm.Realm.compactRealm;
import static io.realm.Realm.setDefaultConfiguration;

public class MusicApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        Realm.init(this);
        RealmConfiguration realmConfiguration = new RealmConfiguration.Builder()
                .schemaVersion(1)
                .deleteRealmIfMigrationNeeded()
                .build();
        Realm.​compactRealm(realmConfiguration);
        Realm.​setDefaultConfiguration(realmConfiguration);
    }
}
