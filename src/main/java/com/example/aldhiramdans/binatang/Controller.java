package com.example.aldhiramdans.binatang;

import android.content.Context;
import android.util.Log;

import com.example.aldhiramdans.binatang.listener.BaseListener;
import com.example.aldhiramdans.binatang.model.BuahModel;
import com.example.aldhiramdans.binatang.model.HewanModel;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class Controller {

    private static final String TAG = Controller.class.getSimpleName();
    private Context context;
    private BaseListener listener;

    public Controller(BaseListener listener) {
        context = Application.getContext();
        this.listener = listener;
    }

    public void getData() {
        Application.service.execute(new Runnable() {
            @Override
            public void run() {
                boolean isSuccess = false;
                ArrayList<HewanModel> list = new ArrayList<>();
                try {
                    JSONObject obj = new JSONObject(JsonUtil.loadLocationJson(context, "hewan.json"));
                    JSONArray data = obj.getJSONArray("data");
                    int count = data.length();
                    for (int i = 0; i < count; i++) {
                        list.add(HewanModel.parse(data.getJSONObject(i)));
                    }
                    isSuccess = true;
                    Log.d(TAG + ".save()", "success save");
                } catch (JSONException ex) {
                    isSuccess = false;
                    listener.onError(ex);
                    Log.d(TAG + ".save()", "failed save");
                    ex.printStackTrace();
                } finally {
                    if (isSuccess) {
                        listener.onSuccess(list);
                    }
                }
            }
        });
    }
}
