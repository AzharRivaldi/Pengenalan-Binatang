package com.example.aldhiramdans.binatang;

import android.content.Context;
import android.os.Handler;
import android.support.multidex.MultiDex;
import android.util.Log;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Application extends android.app.Application {
    private static final String TAG = android.app.Application.class.getSimpleName();
    public static final boolean LOG = true;

    public static final String DATABASE_NAME = "base_location.db";
    public static final byte DATABASE_VERSION = 1;
    public static Context CONTEXT = null;

    private static Application instance;
    private static Handler handler = new Handler();

    public static final ExecutorService service = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
    //public static DatabaseManager database = null;

    public static Context getContext() {
        return Application.CONTEXT;
    }

    public static synchronized Application getInstance() {
        if (instance == null) {
            instance = new Application();
        }
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Application.CONTEXT = getBaseContext();
        Application.service.execute(new Runnable() {
            @Override
            public void run() {
                setupMultidex();
            }
        });
    }

    private synchronized void setupMultidex() {
        MultiDex.install(this);
    }

    // Submits request to be executed in UI thread.
    public void runOnUiThread(final Runnable runnable) {
        handler.post(runnable);
    }

    public void runOnUIThreadDelay(Runnable run, long timemilis) {
        handler.postDelayed(run, timemilis);
    }

    public void runInBackground(final Runnable runnable) {
        service.submit(new Runnable() {
            @Override
            public void run() {
                try {
                    runnable.run();
                } catch (Exception e) {
                    Log.e(TAG, "backgroundThread");
                    e.printStackTrace();
                }
            }
        });
    }
}
